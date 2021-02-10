import Layout from '@/layout'

const gamblingConfig = {
  serviceType: 'gambling',
  serviceName: '休闲养生平台',
  defaultPath: '/gambling',
  constRoutes: [
    {
      path: '/gambling',
      component: Layout,
      redirect: '/gambling/index',
      name: 'gambling',
      children: [
        {
          path: 'index',
          name: 'gambling:index',
          meta: { title: '日常统计', icon: 'dashboard', affix: true },
          component: () => import('@/views/gambling/index')
        }
      ]
    }
  ],
  asyncRoutes: [
    {
      path: '/gambling/game',
      name: 'gambling-game',
      alwaysShow: true,
      component: Layout,
      redirect: 'noRedirect',
      meta: { title: '休闲类型', icon: 'el-icon-setting'},
      children: [
        {
          path: 'fastcar',
          name: 'gambling-game-fastcar',
          meta: { title: '急速赛车' },
          component: () => import('@/views/gambling/game/fastcar')
        },
        {
          path: 'fastcar-information',
          name: 'gambling-game-fastcar-information',
          meta: { title: '急速赛车资讯' },
          component: () => import('@/views/gambling/game/fastcar-information')
        },
        {
          path: 'baccarat',
          name: 'system-auth-baccarat',
          meta: { title: '百家乐' },
          component: () => import('@/views/gambling/game/baccarat')
        }
      ]
    }
  ]
}

export default gamblingConfig
