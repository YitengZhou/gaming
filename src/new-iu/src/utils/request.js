import axios from 'axios'
import store from '@/store'
import { getToken } from '@/utils/auth'
import { MessageBox, Message } from 'element-ui'

// create an axios instance
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
  // withCredentials: true, // send cookies when cross-domain requests
  timeout: 15000 // request timeout
})

// request interceptor
service.interceptors.request.use(
  config => {
    // do something before request is sent

    if (store.getters.token) {
      // let each request carry token
      // ['X-Token'] is a custom headers key
      // please modify it according to the actual situation
      config.headers['X-Token'] = getToken()
    }
    return config
  },
  error => {
    // do something with request error
    console.log(error) // for debug
    return Promise.reject(error)
  }
)

// response interceptor
service.interceptors.response.use(
  /**
   * If you want to get http information such as headers or status
   * Please return  response => response
  */

  /**
   * Determine the request status by custom code
   * Here is just an example
   * You can also judge the status by HTTP Status Code
   */
  response => {
    return response.data
  },
  error => {
    if (error.response) {
      if (error.response.status === 401) {
        /**
         * 限制只弹一个超时提示框
         */
        const timeoutMessageBox = document.getElementsByClassName('login-timeout-messagebox')[0]
        if(!(timeoutMessageBox && timeoutMessageBox.parentNode && timeoutMessageBox.parentNode.style.display!=='none')){
          store.dispatch('user/resetToken').then(() => {
            MessageBox.confirm('您的登录已超时，请重新登录', '登录超时', {
              type: 'warning',
              cancelButtonText: '取消',
              confirmButtonText: '登录',
              customClass: 'login-timeout-messagebox'
            }).then(() => {
              location.reload()
            })
          })
        }
      } else {
        Message({
          type: 'error',
          showClose: true,
          duration: 5 * 1000,
          message: error.response.data
        })
      }
    } else {
      Message({
        type: 'error',
        showClose: true,
        duration: 5 * 1000,
        message: error.message
      })
    }
    return Promise.reject(error)
  }
)

export default service
