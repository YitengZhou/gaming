/**
 * 急速快车的接口访问配置
 */
import request from '@/utils/request'

/**
 * 接口地址定义
 */
const api = {
    raceDoneManual: '/game/fastcar/race-done-manual',
    getFastCarList: '/game/fastcar/get-fastcar-list',
    betRace: '/game/fastcar/addBetRace'
  }

/**
 * 急速赛车手动生成
 */
export function raceDoneManual() {
    return request({
      url: api.raceDoneManual,
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

/**
 * 添加竞猜
 * @param {*} parameter 
 */
export function betRace(parameter) {
  return request({
    url: api.betRace,
    method: 'post',
    data: parameter
  })
}