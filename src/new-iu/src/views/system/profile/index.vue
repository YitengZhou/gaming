<template>
  <el-card class="body-card">
    <el-tabs :tab-position="device == 'mobile' ? 'top' : 'left'">
      <el-tab-pane :lazy="true">
        <modify-password />
        <span slot="label"><i class="el-icon-lock" /> 密码修改</span>
      </el-tab-pane>
    </el-tabs>
  </el-card>
</template>

<style lang="scss">
    .profile-info {
        flex: 1 1;
        padding: 8px 40px;
        .profile-info-title {
            color: rgba(0, 0, 0, .85);
            font-size: 20px;
            font-weight: 500;
            line-height: 28px;
            margin-bottom: 12px;
        }
        .profile-info-content {
            padding-top: 12px;
        }
    }
</style>

<style lang="scss" scoped>
    .el-tabs--left{
        ::v-deep .el-tabs__header{
            margin-right: 0px !important;
        }
        ::v-deep .el-tabs__content{
            border-left: 1px solid #DCDFE6;
        }
    }
</style>

<script>
    import { mapGetters } from 'vuex'
    import ModifyPassword from './components/modify-password'

    export default {
        name: 'Profile',
        components: { ModifyPassword },
        data() {
            return {}
        },
        computed: {
            ...mapGetters([
                'name',
                'avatar',
                'roles',
                'device'
            ])
        },
        methods: {



        }
    }
</script>
