import Vue from 'vue'
import Router from 'vue-router'
import Layout from '@/layout'

Vue.use(Router)

import store from '../store'

const createRouter = () => {
  const allConstRoutes = [
    {
      hidden: true,
      path: '/401',
      component: () => import('@/views/error-page/401')
    },
    {
      hidden: true,
      path: '/404',
      component: () => import('@/views/error-page/404')
    },
    {
      hidden: true,
      path: '/login',
      component: () => import('@/views/system/login')
    },
    {
      hidden: true,
      component: Layout,
      path: '/system/profile',
      redirect: '/system/profile/index',
      children: [
        {
          path: 'index',
          name: 'system-profile',
          meta: { title: '个人中心', noCache: true },
          component: () => import('@/views/system/profile/index')
        }
      ]
    }
  ]
  return new Router({
    // mode: 'history', // require service support
    routes: allConstRoutes,
    scrollBehavior: () => ({ y: 0 })
  })
}

const router = createRouter()
router.afterEach((to, from) => {
  if (to && to.meta && to.meta.serviceType) {
    store.dispatch('permission/switchRoutes', to.meta.serviceType)
  }
})

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
