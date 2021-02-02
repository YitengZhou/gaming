<template>
  <div class="profile-info">
    <div class="profile-info-title">
      <span>密码修改</span>
    </div>
    <div class="profile-info-content">
      <el-row :gutter="16">
        <el-col>
          <el-form ref="dataForm" v-loading="loading" :rules="rules" :model="modifyModel">
            <el-form-item label="原密码" prop="password">
              <el-input v-model="modifyModel.password" placeholder="请输入原密码" show-password />
            </el-form-item>
            <el-form-item label="新密码" prop="newPassword">
              <el-input v-model="modifyModel.newPassword" placeholder="请输入新密码" show-password />
            </el-form-item>
            <el-form-item label="确认新密码" prop="confrimPassword">
              <el-input v-model="modifyModel.confrimPassword" placeholder="请确认新密码" show-password />
            </el-form-item>
            <el-form-item>
              <div class="form-footer">
                <el-button type="primary" @click="handlerProcess">
                  确认
                </el-button>
              </div>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<style lang="scss" scoped>
    .form-footer{
        margin-top: 20px;
    }
</style>

<script>
    import { Message } from 'element-ui'
    import { modifyPassword } from '@/api/system/system'

    export default {
        data() {
            return {
                loading: false,
                modifyModel:{
                    password:'',
                    newPassword:'',
                    confrimPassword:''
                },
                rules: {
                    password: [{ required: true, trigger: 'blur', message: '请输入原密码' }],
                    newPassword: [{ required: true, trigger: 'blur', validator: (rule, value, callback) => {
                        if (!value || value.length <= 0) {
                            callback(new Error('请输入新密码'))
                        } else if (value.length < 6) {
                            callback(new Error('密码长度不能小于6位字符'))
                        } else {
                            callback()
                        }
                    } }],
                    confrimPassword: [{ required: true, trigger: 'blur', validator: (rule, value, callback) => {
                        if (!value || value.length <= 0) {
                            callback(new Error('请确认新密码'))
                        } else if (value !== this.modifyModel.newPassword) {
                            callback(new Error('确认密码与新密码不一致'))
                        } else {
                            callback()
                        }
                    } }]
                }
            }
        },
        methods: {
            async logout() {
                await this.$store.dispatch('user/logout')
                this.$router.push(`/login`)
            },
            handlerProcess(){
                this.$refs.dataForm.validate(valid => {
                    if(valid){
                        modifyPassword(this.modifyModel).then(res => {
                            Message({
                                type: 'success',
                                message: '密码修改成功,请重新登录',
                                duration: 5 * 1000
                            })
                            this.logout()
                        }).finally(() => {
                            this.loading = false
                        })
                    }else{
                        return false
                    }
                })
            }
        }
    }
</script>