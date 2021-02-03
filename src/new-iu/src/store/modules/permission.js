import adminConfig from '@/router/modules/adminConfig'
// import gatewayConfig from '@/router/modules/gatewayConfig'
// import service1Config from '@/router/modules/choiceConfig'

/**
 * Use meta.permissions to determine if the current user has permission
 * @param permissions
 * @param route
 */
function hasPermission(permissions, route) {
  if (route.meta && route.meta.permissions) {
    return permissions.some(permission => route.meta.permissions.includes(permission))
  } else {
    return true
  }
}

/**
 *
 * @param {*} routes
 * @param {*} serviceType
 */
function setServiceType(routes, serviceType){
  routes.forEach(route => {
    if(!route.meta){
      route.meta = {}
    }
    route.meta.serviceType = serviceType
    if(route.children && route.children.length>0){
      setServiceType(route.children, serviceType)
    }
  })
}

/**
 *
 * @param {*} routesObject
 * @param {*} permissions
 * @param {*} routeConfig
 */
function setAllRoutesAndDic(routesObject, permissions, routeConfig){
  const tempRoutes = routeConfig.constRoutes.concat(
  filterAsyncRoutes(routeConfig.asyncRoutes, permissions))
  setServiceType(tempRoutes, routeConfig.serviceType)
  routesObject.routesDic[routeConfig.serviceType] = {
    serviceType: routeConfig.serviceType,
    serviceName: routeConfig.serviceName,
    defaultPath: routeConfig.defaultPath,
    routeArray: tempRoutes
  }
  routesObject.allRoutes = routesObject.allRoutes.concat(tempRoutes)
}

/**
 * Filter asynchronous routing tables by recursion
 * @param routes asyncRoutes
 * @param permissions
 */
export function filterAsyncRoutes(routes, permissions) {
  const res = []
  routes.forEach(route => {
    const tmp = { ...route }
    if (tmp.children) {
      tmp.children = filterAsyncRoutes(tmp.children, permissions)
    }
    if (hasPermission(permissions, tmp) || (tmp.children && tmp.children.length>0)) {
      res.push(tmp)
    }
  })
  return res
}

const state = {
  allRoutes: [],
  routesDic: {},
  currentRoutes: {}
}

const mutations = {
  SET_ROUTESDIC: (state, merge) => {
    state.allRoutes = merge.allRoutes
    state.routesDic = merge.routesDic
  },
  SET_CURRENTROUTES: (state, serviceType) => {
    if(serviceType){
      if(!state.currentRoutes.serviceType || state.currentRoutes.serviceType!==serviceType){
        const routesConfig = state.routesDic[serviceType] || {}
        state.currentRoutes = {
          serviceType: serviceType,
          defaultPath: routesConfig.defaultPath || '',
          routeArray: routesConfig.routeArray || []
        }
      }
    }
  }
}

const actions = {
  switchRoutes({ commit }, serviceType) {
    commit('SET_CURRENTROUTES', serviceType)
  },
  generateRoutes({ commit }, permissions) {
    return new Promise(resolve => {
      const routesObject = { allRoutes: [], routesDic: {} }
      setAllRoutesAndDic(routesObject, permissions, adminConfig)
      // setAllRoutesAndDic(routesObject, permissions, gatewayConfig)
      // setAllRoutesAndDic(routesObject, permissions, service1Config)
      commit('SET_ROUTESDIC', { allRoutes: routesObject.allRoutes, routesDic: routesObject.routesDic })
      resolve(routesObject.allRoutes)
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
