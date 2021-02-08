/**
 * 急速快车的接口访问配置
 */
import request from '@/utils/request'

/**
 * 接口地址定义
 */
const api = {
    testCreate: '/game/fastcar/test-create',
    getFastCarList: '/game/fastcar/get-fastcar-list'
  }

/**
 * 急速赛车手动生成
 */
export function testCreate() {
    return request({
      url: api.testCreate,
      method: 'post'
    })
}

/**
 * 急速赛车列表查询
 * @param {*} parameter
 */
export function getFastCarList(parameter) {
  return request({
      url: api.getFastCarList,
      method: 'get',
      params: parameter
  })
}