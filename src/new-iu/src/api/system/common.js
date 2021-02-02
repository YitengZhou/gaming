/**
 * 系统管理通用的接口访问配置
 */
import request from '@/utils/request'

/**
 * 接口地址定义
 */
const api = {
  environment: '/system/info/environment',
  userSuggest: '/system/user/user-suggest'
}

/**
 *
 */
export function environment() {
  return request({
    url: api.environment,
    method: 'get'
  })
}

/**
 * 用户搜索建议接口
 * @param {*} parameter
 */
export function userSuggest(parameter) {
  return request({
    url: api.userSuggest,
    method: 'get',
    params: parameter
  })
}
