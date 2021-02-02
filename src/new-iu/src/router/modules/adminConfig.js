import Layout from '@/layout'

const adminConfig = {
  serviceType: 'admin',
  serviceName: '后台管理',
  defaultPath: '/',
  constRoutes: [
    {
      path: '/',
      component: Layout,
      redirect: '/dashboard',
      children: [
        {
          path: 'dashboard',
          name: 'dashboard',
          meta: { title: '控制台', icon: 'dashboard', affix: true },
          component: () => import('@/views/dashboard/index')
        }
      ]
    }
  ],
  asyncRoutes: [
    {
      path: '/system/auth',
      name: 'system-auth',
      alwaysShow: true,
      component: Layout,
      redirect: 'noRedirect',
      meta: { title: '授权管理', icon: 'el-icon-setting', permissions: ['system'] },
      children: [
        {
          path: 'user',
          name: 'system-auth-user-manager',
          meta: { title: '用户管理', permissions: ['system:search-user'] },
          component: () => import('@/views/system/auth/user-manager')
        },
        {
          path: 'role',
          name: 'system-auth-role-manager',
          meta: { title: '角色管理', permissions: ['system:search-role'] },
          component: () => import('@/views/system/auth/role-manager')
        }
      ]
    }
  ]
}

export default adminConfig
