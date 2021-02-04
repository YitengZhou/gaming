<template>
  <el-dialog :title="title" :visible.sync="visible">
    <el-form ref="dataForm" :rules="rules" :model="userInfo" label-position="right" label-width="80px">
      <el-form-item label="用户Id" prop="userId">
        <el-input v-model="userInfo.userId" :disabled="userIdDisable" placeholder="请输入用户Id" />
      </el-form-item>
      <el-form-item label="用户名称" prop="userName">
        <el-input v-model="userInfo.userName" :disabled="usernameDisable" placeholder="请输入用户名称" />
      </el-form-item>
      <el-form-item v-if="passwordVisible" label="初始密码" prop="password">
        <el-input v-model="userInfo.password" type="password" placeholder="请输入初始密码" />
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="visible = false">
        取消
      </el-button>
      <el-button type="primary" @click="handlerProcess">
        确认
      </el-button>
    </div>
  </el-dialog>
</template>

<script>
    export default {
        data() {
            return {
                type: '',
                title: '',
                visible: false,
                userIdDisable: false,
                usernameDisable: false,
                passwordVisible: false,
                userInfo: {
                    userId: '',
                    userName: '',
                    password: ''
                },
                rules: {
                    userId: [{ required: true, trigger: 'blur', message: '请输入用户编号' }],
                    userName: [{ required: true, trigger: 'blur', message: '请输入用户名称' }],
                    password: [{ required: true, trigger: 'blur', validator: (rule, value, callback) => {
                        if(this.passwordVisible){
                            if (!value || value.length <= 0) {
                                callback(new Error('请输入初始密码'))
                            } else if (value.length < 6) {
                                callback(new Error('初始密码长度不能小于6位字符'))
                            } else {
                                callback()
                            }
                        }else{
                            callback()
                        }
                    } }]
                }
            }
        },
        methods: {
            clear() {
                this.userIdDisable = false
                this.usernameDisable = false
                this.passwordVisible = false
                this.userInfo.userId = ''
                this.userInfo.userName = ''
                this.userInfo.password = ''
                this.$nextTick(() => {
                    this.$refs.dataForm && this.$refs.dataForm.clearValidate()
                })
            },
            add() {
                this.clear()
                this.type = 'ADD'
                this.title = '添加用户'
                this.visible = true
                this.passwordVisible = true
            },
            update(userInfo) {
                this.clear()
                this.type = 'UPDATE'
                this.title = '编辑用户'
                this.visible = true
                this.userIdDisable = true
                this.userInfo.userId = userInfo.userId
                this.userInfo.userName = userInfo.userName
                this.userInfo.password = userInfo.password
            },
            resetPassword(userInfo){
                this.clear()
                this.type = 'RESETPASSWORD'
                this.title = '重置密码'
                this.visible = true
                this.userIdDisable = true
                this.usernameDisable = true
                this.passwordVisible = true
                this.userInfo.userId = userInfo.userId
                this.userInfo.userName = userInfo.userName
                this.userInfo.password = userInfo.password
            },
            handlerProcess(){
                this.$refs.dataForm.validate(valid => {
                    if(valid){
                        this.visible = false
                        this.$emit('confirm', this.type, this.userInfo)
                    }else{
                        return false
                    }
                })
            }
        }
    }
</script>