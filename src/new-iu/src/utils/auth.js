import Cookies from 'js-cookie'

const TokenKey = 'YT_GAMBLING_ADMIN_TOKEN'
const UserIdKey = 'YT_GAMBLING_ADMIN_USER_ID'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token, { expires: 3 })
}

export function getUserId() {
  return Cookies.get(UserIdKey)
}

export function removeUserId() {
  return Cookies.remove(UserIdKey)
}

export function setUserId(userId) {
  return Cookies.set(UserIdKey, userId, { expires: 3 })
}