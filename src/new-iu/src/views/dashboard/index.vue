<template>
  <div class="dashboard-container">
    <el-card class="body-card">
      <div class="home">
        <div class="hero">
          <img :src="logoPath" alt="hero"> 
          <h1>养生休闲平台</h1> 
          <p class="description">欢迎您: {{ name }}</p> 
          <p class="action">
            <router-link to="/system/profile/index" class="nav-link action-button">
              个人中心 →
            </router-link>
          </p>
        </div>
        <div class="features">
          <div class="feature">
            <h2>系统管理平台</h2> 
            <p>Typical templates for enterprise applications and various components</p>
            <p class="action">
              <router-link to="/gateway/index" class="nav-link action-button">
                立即进入 →
              </router-link>
            </p>
          </div>
          <div class="feature">
            <h2>养生休闲平台</h2> 
            <p>Typical templates for enterprise applications and various components</p>
            <p class="action">
              <router-link to="/choice/index" class="nav-link action-button">
                立即进入 →
              </router-link>
            </p>
          </div>
          <div class="feature">
            <h2>更多功能</h2> 
            <p>Typical templates for enterprise applications and various components</p>
            <p class="action">
              <span class="nav-link action-button disable">
                后续更新 →
              </span>
            </p>
          </div>
        </div>
      </div>
    </el-card>
  </div>
</template>

<style lang="scss" scoped>
    .home{
        max-width: 960px;
        margin: 0 auto;
        padding: 3rem 2rem 2rem 2rem;
        .hero{
            text-align: center;
            img{
                display: block;
                max-height: 160px;
                margin: 2rem auto 1.5rem;
            }
            h1{
                color: #2c3e50;
                font-size: 2.5rem;
                margin: 1.8rem auto;
            }
            .description{
                color: #6a8bad;
                max-width: 35rem;
                font-size: 1.6rem;
                margin: 1.8rem auto;
            }
        }
        .features{
            border-top: 1px solid #eaecef;
            padding: 1.2rem 0;
            margin-top: 2.5rem;
            display: flex;
            flex-wrap: wrap;
            align-items: flex-start;
            align-content: stretch;
            justify-content: space-between;
            .feature{
                flex-grow: 1;
                flex-basis: 30%;
                max-width: 30%;
                h2{
                    font-size: 1.4rem;
                    font-weight: 500;
                    border-bottom: none;
                    padding-bottom: 0;
                    color: #3a5169;
                }
                p{
                    color: #4e6e8e;
                    line-height: 1.7;
                    display: block;
                    margin-block-start: 1em;
                    margin-block-end: 1em;
                    margin-inline-start: 0px;
                    margin-inline-end: 0px;
                }
                .action-button{
                    display: inline-block;
                    font-size: 1rem;
                    color: #fff;
                    background-color: #1890ff;
                    padding: .5rem 1.6rem;
                    border-radius: 4px;
                    transition: background-color .1s ease;
                    box-sizing: border-box;
                    border-bottom: 1px solid #1890ff;
                }
                .disable{
                    cursor: not-allowed;
                    background-color: #b4dbff !important;
                    border-bottom: 1px solid #b4dbff !important;
                }
            }
        }
    }
</style>

<script>
    import { mapGetters } from 'vuex'
    import logoPath from '@/assets/logo.png'

    export default {
      name: 'Dashboard',
      data() {
        return {
          logoPath: logoPath
        }
      },
      computed: {
        ...mapGetters([
          'userId',
          'name'
        ])
      }
    }
</script>
