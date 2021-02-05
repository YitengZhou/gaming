<template>
  <div class="navbar">
    <hamburger id="hamburger-container" :is-active="sidebar.opened" class="hamburger-container" @toggleClick="toggleSideBar" />

    <div v-if="routesDic" class="switch-container">
      <el-menu :default-active="currentRoutes.serviceType || ''" :collapse="true" @select="serviceSelect">
        <el-submenu index="menu-title">
          <template slot="title">
            <div><i class="el-icon-monitor" /></div>
          </template>
          <el-menu-item v-for="(value,key, i) in routesDic" :key="i" :index="key">{{ value.serviceName }}</el-menu-item>
        </el-submenu>
      </el-menu>
    </div>

    <breadcrumb id="breadcrumb-container" class="breadcrumb-container" />

    <div class="right-menu">
      <div v-if="(env||'')!=''" class="right-menu-item">
        <el-tag style="display: block;margin-top: 12px;" effect="dark">
          {{ env }}
        </el-tag>  
      </div>
      <div v-if="(env||'')!=''" class="right-menu-item">
        <el-tag style="display: block;margin-top: 12px;" effect="dark">
          {{ env }}
        </el-tag>  
      </div>
      <div v-if="(env||'')!=''" class="right-menu-item">
        <el-tag style="display: block;margin-top: 12px;" effect="dark">
          {{ env }}
        </el-tag>  
      </div>
      <template v-if="device!=='mobile'">
        <error-log class="errLog-container right-menu-item hover-effect" />
        <screenfull id="screenfull" class="right-menu-item hover-effect" />
      </template>
      <!-- 下拉菜单 -->
      <el-dropdown class="avatar-container right-menu-item hover-effect" trigger="click">
        <div class="avatar-wrapper">
          <img :src="avatar+'?imageView2/1/w/80/h/80'" class="user-avatar">
          <div class="name-avatar">{{ `${name} [ ${userId} ]` }}</div>
          <i class="el-icon-caret-bottom" />
        </div>
        <el-dropdown-menu slot="dropdown">
          <router-link to="/">
            <el-dropdown-item>控制台</el-dropdown-item>
          </router-link>
          <router-link to="/system/profile/index">
            <el-dropdown-item>个人中心</el-dropdown-item>
          </router-link>
          <el-dropdown-item divided @click.native="logout">
            <span style="display:block;">退出登录</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  // breadcrumb是左上角面包屑导航
  import Breadcrumb from '@/components/Breadcrumb'
  // Hamburger是左边弹入弹出按钮
  import Hamburger from '@/components/Hamburger'
  // ErrorLog弹出的信息
  import ErrorLog from '@/components/ErrorLog'
  // Screenfull是全屏按钮
  import Screenfull from '@/components/Screenfull'
  import { environment } from '@/api/system/common'

  export default {
    components: {
      Breadcrumb,
      Hamburger,
      ErrorLog,
      Screenfull
    },
    computed: {
      ...mapGetters([
        'userId',
        'name',
        'sidebar',
        'avatar',
        'device',
        'routesDic',
        'currentRoutes'
      ])
    },
    data(){
      return{
        env: ''
      }
    },
    mounted() {
      this.environment()
    },
    methods: {
      environment() {
        environment().then(response => {
          this.env = response
        })
      },
      toggleSideBar() {
        this.$store.dispatch('app/toggleSideBar')
      },
      async logout() {
        await this.$store.dispatch('user/logout')
        // 登出后仍保持在原链接，为避免无权限问题，需修改？？
        this.$router.push(`/login?redirect=${this.$route.fullPath}`)
      },
      serviceSelect(serviceType){
        if(!this.currentRoutes.serviceType || this.currentRoutes.serviceType!==serviceType){
          const defaultPath = (this.routesDic[serviceType] || {}).defaultPath
          if(defaultPath){
            this.$router.push({ path: defaultPath })
          }
        }
      }
    }
  }
</script>

<style lang="scss" scoped>
.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0,21,41,.08);

  .hamburger-container {
    line-height: 46px;
    height: 100%;
    float: left;
    cursor: pointer;
    transition: background .3s;
    -webkit-tap-highlight-color:transparent;
    &:hover {
      background: rgba(0, 0, 0, .025)
    }
  }
  .switch-container{
    float: left;
    display: inline-block;
    line-height: 50px;
    margin: 0px 5px 0px 5px;
    .el-menu--collapse{
      width: 50px;
    }
    ::v-deep .el-submenu__title {
      height: 50px;
      line-height: 46px;
      padding-left: 10px !important;
      i {
        color: #303133;
      }
      &:hover {
        background: #ffffff
      }
    }
  }
  .breadcrumb-container {
    float: left;
  }
  .errLog-container {
    display: inline-block;
    vertical-align: top;
  }
  .right-menu {
    float: right;
    height: 100%;
    line-height: 50px;
    &:focus {
      outline: none;
    }
    .right-menu-item {
      display: inline-block;
      padding: 0 8px;
      height: 100%;
      font-size: 18px;
      color: #5a5e66;
      vertical-align: text-bottom;
      &.hover-effect {
        cursor: pointer;
        transition: background .3s;
        &:hover {
          background: rgba(0, 0, 0, .025)
        }
      }
    }
    .avatar-container {
      margin-right: 30px;
      .avatar-wrapper {
        display: flex;
        position: relative;
        .name-avatar {
          font-size: 14px;
          margin-left: 6px;
        }
        .user-avatar {
          cursor: pointer;
          width: 35px;
          height: 35px;
          margin-top: 8px;
          border-radius: 6px;
        }
        .el-icon-caret-bottom {
          cursor: pointer;
          position: absolute;
          right: -20px;
          top: 20px;
          font-size: 12px;
        }
      }
    }
  }
}
</style>
