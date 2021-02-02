<template>
  <div class="login-container">
    <div class="bg" />
    <div class="bg-mask" />
    <div class="top">
      <div class="header">
        <a href="/">
          <img src="~@/assets/logo.jpg" class="logo" alt="logo">
          <el-badge :value="env" class="item" type="primary">
            <span class="title">养生休闲平台</span>
          </el-badge>
        </a>
      </div>
      <div class="desc">Eden-养生休闲平台</div>
    </div>
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form" autocomplete="on" label-position="left">
      <el-form-item prop="userId">
        <span class="svg-container">
          <svg-icon icon-class="user" />
        </span>
        <el-input
          ref="userId"
          v-model="loginForm.userId"
          type="text"
          tabindex="1"
          name="userId"
          autocomplete="on"
          placeholder="请输入帐号"
        />
      </el-form-item>
      <el-tooltip v-model="capsTooltip" content="大写锁定已打开" placement="right" manual>
        <el-form-item prop="password">
          <span class="svg-container">
            <svg-icon icon-class="password" />
          </span>
          <el-input
            ref="password"
            :key="passwordType"
            v-model="loginForm.password"
            :type="passwordType"
            tabindex="2"
            name="password"
            autocomplete="on"
            placeholder="请输入密码"
            @blur="capsTooltip = false"
            @keyup.native="checkCapslock"
            @keyup.enter.native="handleLogin"
          />
          <span class="show-pwd" @click="showPwd">
            <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'" />
          </span>
        </el-form-item>
      </el-tooltip>
      <el-form-item prop="imageCode">
        <span class="svg-container">
          <i class="el-icon-picture" />
        </span>
        <el-input
          ref="imageCode"
          v-model="loginForm.imageCode"
          type="text"
          tabindex="1"
          name="imageCode"
          autocomplete="off"
          placeholder="请输入图片验证码"
        />
        <img style="width:100px; height: auto;" :src="imageCodeUrl" @click="refreshTicket">
      </el-form-item>
      <el-button :loading="loading" type="primary" class="login-button" @click.native.prevent="handleLogin">登 录</el-button>
    </el-form>
    <div class="footer">
      <div class="copyright">
        Copyright &copy; 2021 Eden自定义开发
      </div>
    </div>
  </div>
</template>

<script>
import { environment } from '@/api/system/common'

export default {
  name: 'Login',
  data() {
    return {
      env: '',
      passwordType: 'password',
      loading: false,
      showDialog: false,
      capsTooltip: false,
      redirect: undefined,
      otherQuery: {},
      loginForm: {
        userId: '',
        password: '',
        ticket: '',
        imageCode: ''
      },
      loginRules: {
        userId: [{ required: true, trigger: 'blur', validator: (rule, value, callback) => {
          if (value.length <= 0) {
            callback(new Error('请输入帐号'))
          } else {
            callback()
          }
        } }],
        password: [{ required: true, trigger: 'blur', validator: (rule, value, callback) => {
          if (value.length <= 0) {
            callback(new Error('请输入密码'))
          } else if (value.length < 6) {
            callback(new Error('密码长度不能小于6位字符'))
          } else {
            callback()
          }
        } }],
        imageCode: [{ required: true, trigger: 'blur', validator: (rule, value, callback) => {
          if (value.length <= 0) {
            callback(new Error('请输入图形验证码'))
          } else {
            callback()
          }
        } }]
      }
    }
  },
  computed: {
    imageCodeUrl: function() {
      return `${process.env.VUE_APP_BASE_API}/system/info/image-code?ticket=${this.loginForm.ticket}`
    }
  },
  watch: {
    $route: {
      immediate: true,
      handler: function(route) {
        const query = route.query
        if (query) {
          this.redirect = query.redirect
          this.otherQuery = this.getOtherQuery(query)
        }
      }
    }
  },
  mounted() {
    this.environment()
    this.refreshTicket()
    if (this.loginForm.userId === '') {
      this.$refs.userId.focus()
    } else if (this.loginForm.password === '') {
      this.$refs.password.focus()
    }
  },
  methods: {
    uuid() {
      return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, c => {
        const r = Math.random() * 16 | 0
        const v = c === 'x' ? r : (r & 0x3 | 0x8)
        return v.toString(16)
      })
    },
    refreshTicket() {
      this.loginForm.ticket = this.uuid()
    },
    environment() {
      environment().then(response => {
        this.env = response
      })
    },
    checkCapslock(e) {
      const { key } = e
      this.capsTooltip = key && key.length === 1 && (key >= 'A' && key <= 'Z')
    },
    showPwd() {
      this.passwordType = this.passwordType === 'password' ? '' : 'password'
      this.$nextTick(() => {
        this.$refs.password.focus()
      })
    },
    getOtherQuery(query) {
      return Object.keys(query).reduce((acc, cur) => {
        if (cur !== 'redirect') {
          acc[cur] = query[cur]
        }
        return acc
      }, {})
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true
          this.$store.dispatch('user/login', this.loginForm)
            .then(() => {
              this.$router.push({ path: this.redirect || '/', query: this.otherQuery })
            })
            .catch(() => {
              this.refreshTicket()
            }).finally(() => { this.loading = false })
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
    .login-container {
        padding: 80px 0px 50px 0px;
        .bg {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            // background: #f0f2f5 url(~@/assets/background.jpg) no-repeat 50%;
            background-size: 100%;
            filter: blur(1px);
        }
        .bg-mask{
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(255, 255, 255, 0.6);
        }
        .top {
            text-align: center;
            .desc {
                position: relative;
                font-size: 14px;
                color: rgba(0, 0, 0, 0.45);
                margin-top: 12px;
                margin-bottom: 40px;
            }
            .header {
                height: 44px;
                line-height: 44px;
                .badge {
                    position: absolute;
                    display: inline-block;
                    line-height: 1;
                    vertical-align: middle;
                    margin-left: -12px;
                    margin-top: -10px;
                    opacity: 0.8;
                }
                .logo {
                    position: relative;
                    height: 44px;
                    vertical-align: top;
                    margin-right: 16px;
                    border-style: none;
                }
                .title {
                    font-size: 33px;
                    color: rgba(0, 0, 0, .85);
                    font-family: Avenir, 'Helvetica Neue', Arial, Helvetica, sans-serif;
                    font-weight: 600;
                    position: relative;
                    top: 2px;
                }
            }
        }
        width: 100%;
        min-height: 100%;
        overflow: hidden;
        .login-form {
            width: 500px;
            max-width: 100%;
            margin: 0 auto;
            overflow: hidden;
            position: relative;
        }
        .svg-container {
            padding: 6px 5px 6px 10px;
            color: #919597;
            vertical-align: middle;
            width: 30px;
            display: inline-block;
            font-size: 16px;
        }
        .show-pwd {
            position: absolute;
            right: 10px;
            top: 7px;
            font-size: 16px;
            color: #919597;
            cursor: pointer;
            user-select: none;
        }
        .thirdparty-button {
            position: absolute;
            right: 0;
            bottom: 6px;
        }
        @media only screen and (max-width: 470px) {
            .thirdparty-button {
                display: none;
            }
        }
    }
    .login-container ::v-deep .el-form-item {
        color: #454545;
        border-radius: 5px;
        margin-bottom: 26px;
        background: rgba(0, 0, 0, 0.1);
        border: 1px solid rgba(255, 255, 255, 0.1);
    }
    .login-container ::v-deep .el-form-item__content {
        display: flex;
        line-height: 30px;
    }
    .login-container ::v-deep .el-input {
        width: 80%;
        display: flex;
        input {
            align-self: center;
            border: 0px;
            height: 30px;
            color: #505355;
            border-radius: 0px;
            caret-color: #505355;
            background: transparent;
            -webkit-appearance: none;
            padding: 12px 5px 12px 15px;
            &:-webkit-autofill {
                -webkit-text-fill-color: #505355 !important;
            }
        }
    }
    .login-button{
        width:100%;
        margin-top:10px;
        line-height: 20px;
    }
    .footer {
        position: absolute;
        width: 100%;
        bottom: 0;
        padding: 0 16px;
        margin: 48px 0 24px;
        text-align: center;
        .links {
            margin-bottom: 8px;
            font-size: 14px;
            a {
                transition: all 0.3s;
                color: rgba(0, 0, 0, 0.45);
                &:not(:last-child) {
                    margin-right: 40px;
                }
            }
        }
        .copyright {
            font-size: 14px;
            color: rgba(0, 0, 0, 0.45);
        }
    }
</style>
