import { systemPermission } from './permission/system-permission'
// import { gatewayPermission } from './permission/gateway-permission'
// import { choicePermission } from './permission/choice-permission'

const permissionDefine = []
permissionDefine.push(systemPermission)
// permissionDefine.push(gatewayPermission)
// permissionDefine.push(choicePermission)

/**
 * 获得权限标签
 * @param {*} service
 * @param {*} value
 */
function getPermissionLabel(service, value) {
  for (const item of permissionDefine) {
    if (item.id === service) {
      for (const menu of item.children) {
        for (const role of menu.children) {
          for (const perm of role.children) {
            if (perm.id === value) {
              return perm.label
            }
          }
        }
      }
    }
  }
  return ''
}

// tips：tree全选时会将父节点也选中，为只获得权限id，利用字符':'判断，父目录id中不包含字符':'； 见role-auth.vue的setPermissions()
export { permissionDefine, getPermissionLabel }
