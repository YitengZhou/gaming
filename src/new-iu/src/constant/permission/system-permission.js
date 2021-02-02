const systemPermission = {
  id: 'system',
  label: '后台管理服务',
  children: [{
    id: 'system-manage',
    label: '系统管理',
    children: [{
      id: 'system-manage-user',
      label: '用户管理',
      children: [{
        id: 'system:search-user',
        label: '查询用户',
        isData: true
      },
      {
        id: 'system:manage-user',
        label: '管理用户',
        isData: true
      }]
    },
    {
      id: 'system-manage-role',
      label: '角色管理',
      children: [{
        id: 'system:search-role',
        label: '查询角色',
        isData: true
      },
      {
        id: 'system:manage-role',
        label: '管理角色',
        isData: true
      }]
    }]
  }]
}

export { systemPermission }
