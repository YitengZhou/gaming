import { resetRouter } from '@/router'
import { login, logout, userInfo } from '@/api/system/system'
import { getToken, setToken, removeToken, getUserId, setUserId, removeUserId } from '@/utils/auth'

const state = {
  token: getToken(),
  userId: getUserId(),
  money: 0.00,
  profit: 0.00,
  name: '',
  avatar: '',
  introduction: '',
  menu: '',
  permissions: []
}

const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_USERID: (state, userId) => {
    state.userId = userId
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_MONEY: (state, money) => {
    state.money = money
  },
  SET_PROFIT: (state, profit) => {
    state.profit = profit
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  },
  SET_PERMISSIONS: (state, permissions) => {
    state.permissions = permissions
  },
  SET_MENU: (state, menu) => {
    state.menu = menu
  },
  SET_INTRODUCTION: (state, introduction) => {
    state.introduction = introduction
  }
}

const actions = {
  // user login
  login({ commit }, userInfo) {
    const { userId, password, ticket, imageCode } = userInfo
    return new Promise((resolve, reject) => {
      login({ userId: userId.trim(), 
              password: password,
              ticket: ticket,
              imageCode: imageCode }).then(response => {
        commit('SET_TOKEN', response)
        commit('SET_USERID', userId.trim())
        setToken(response)
        setUserId(userId.trim())
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // get user info
  userInfo({ commit, state }) {
    return new Promise((resolve, reject) => {
      userInfo(state.token).then(response => {
        if (!response) {
          reject('登录失败，请重试')
        }
        let { name, avatar, money, profit, introduction, permissions } = response
        // roles must be a non-empty array
        if (!permissions || permissions.length <= 0) {
          permissions = ['NONE']
        }
        commit('SET_NAME', name)
        commit('SET_MONEY', money)
        commit('SET_PROFIT', profit)
        commit('SET_AVATAR', avatar)
        commit('SET_PERMISSIONS', permissions)
        commit('SET_INTRODUCTION', introduction)
        resolve(response)
      }).catch(error => {
        reject(error)
      })
    })
  },

  // user logout
  logout({ commit, state, dispatch }) {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {
        commit('SET_TOKEN', '')
        commit('SET_USERID', '')
        commit('SET_PERMISSIONS', [])
        removeToken()
        removeUserId()
        resetRouter()

        // reset visited views and cached views
        // to fixed https://github.com/PanJiaChen/vue-element-admin/issues/2485
        dispatch('tagsView/delAllViews', null, { root: true })

        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // remove token
  resetToken({ commit }) {
    return new Promise(resolve => {
      commit('SET_TOKEN', '')
      commit('SET_USERID', '')
      commit('SET_PERMISSIONS', [])
      removeToken()
      removeUserId()
      resolve()
    })
  }

  // dynamically modify permissions
  // async changeRoles({ commit, dispatch }, role) {
  //   const token = role + '-token'

  //   commit('SET_TOKEN', token)
  //   setToken(token)

  //   const { permissions } = await dispatch('userInfo')

  //   resetRouter()

  //   // generate accessible routes map based on permissions
  //   const accessRoutes = await dispatch('permission/generateRoutes', permissions, { root: true })
  //   // dynamically add accessible routes
  //   router.addRoutes(accessRoutes)

  //   // reset visited views and cached views
  //   dispatch('tagsView/delAllViews', null, { root: true })
  // }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
