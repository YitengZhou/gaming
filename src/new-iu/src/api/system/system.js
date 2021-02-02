/**
 * 系统管理相关的接口请求
 */
import request from '@/utils/request'

/**
 * 接口地址定义
 */
const api = {
  login: '/system/user/login',
  logout: '/system/user/logout',
  userInfo: '/system/user/user-info',
  modifyPassword: '/system/user/modify-password',
  addUser: '/system/user/add-user',
  updateUser: '/system/user/update-user',
  deleteUser: '/system/user/delete-user',
  enableUser: '/system/user/enable-user',
  disableUser: '/system/user/disable-user',
  resetPassword: '/system/user/reset-password',
  getUserList: '/system/user/get-user-list',
  getRoleList: '/system/user/role-list',
  getUserRoles: '/system/user/user-roles',
  setRoles: '/system/user/set-roles',
  roleQueryList: '/system/roles/get-role-list',
  addRole: '/system/roles/add',
  updateRole: '/system/roles/update',
  deleteRole: '/system/roles/delete',
  setPermissions: '/system/roles/set-permissions'
}

/**
 * 登录接口
 * @param {*} parameter
 */
export function login(parameter) {
  return request({
    url: api.login,
    method: 'post',
    data: parameter
  })
}

/**
 * 退出登录接口
 * @param {*} parameter
 */
export function logout(parameter) {
  return request({
    url: api.logout,
    method: 'post',
    data: parameter
  })
}

/**
 * 用户信息查询
 * @param {*} parameter
 */
export function userInfo(parameter) {
  return request({
    url: api.userInfo,
    method: 'get',
    params: parameter
  })
}

/**
 * 密码修改接口
 * @param {*} parameter
 */
export function modifyPassword(parameter) {
  return request({
    url: api.modifyPassword,
    method: 'post',
    data: parameter
  })
}

/**
 * 添加用户
 * @param {*} parameter
 */
export function addUser(parameter) {
  return request({
    url: api.addUser,
    method: 'post',
    data: parameter
  })
}

/**
 * 编辑用户
 * @param {*} parameter
 */
export function updateUser(parameter) {
  return request({
    url: api.updateUser,
    method: 'post',
    data: parameter
  })
}

/**
 * 删除用户
 * @param {*} parameter
 */
export function deleteUser(parameter) {
  return request({
    url: api.deleteUser,
    method: 'post',
    data: parameter
  })
}

/**
 * 启用用户
 * @param {*} parameter
 */
export function enableUser(parameter) {
  return request({
    url: api.enableUser,
    method: 'post',
    data: parameter
  })
}

/**
 * 禁用用户
 * @param {*} parameter
 */
export function disableUser(parameter) {
  return request({
    url: api.disableUser,
    method: 'post',
    data: parameter
  })
}

/**
 * 重置密码
 * @param {*} parameter
 */
export function resetPassword(parameter) {
  return request({
    url: api.resetPassword,
    method: 'post',
    data: parameter
  })
}

/**
 * 用户列表查询
 * @param {*} parameter
 */
export function getUserList(parameter) {
  return request({
    url: api.getUserList,
    method: 'get',
    params: parameter
  })
}

/**
 * 全部角色列表
 */
export function getRoleList() {
  return request({
    url: api.getRoleList,
    method: 'get'
  })
}

/**
 * 根据用户名角色列表
 * @param {*} parameter
 */
export function getUserRoles(parameter) {
  return request({
    url: api.getUserRoles,
    method: 'post',
    data: parameter
  })
}

/**
 * 设置角色
 * @param {*} parameter
 */
export function setRoles(parameter) {
  return request({
    url: api.setRoles,
    method: 'post',
    data: parameter
  })
}

/**
 * 角色列表查询
 * @param {*} parameter
 */
export function roleQueryList(parameter) {
  return request({
    url: api.roleQueryList,
    method: 'get',
    params: parameter
  })
}

/**
 * 增加角色
 * @param {} data
 */
export function addRole(data) {
  return request({
    url: api.addRole,
    method: 'post',
    data
  })
}

/**
 * 更新角色
 * @param {} data
 */
export function updateRole(data) {
  return request({
    url: api.updateRole,
    method: 'post',
    data
  })
}

/**
 * 删除角色
 * @param {*} data
 */
export function deleteRole(data) {
  return request({
    url: api.deleteRole,
    method: 'post',
    data
  })
}

/**
 * 设置角色权限
 * @param {*} data
 */
export function setPermissions(data) {
  return request({
    url: api.setPermissions,
    method: 'post',
    data
  })
}
