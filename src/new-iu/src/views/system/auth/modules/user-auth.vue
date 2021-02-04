<template>
  <el-dialog title="角色设置" :visible.sync="visible" @close="dialogClose">
    <el-form ref="dataForm" :rules="rules" :model="userInfo" label-position="left" label-width="80px">
      <el-form-item label="用户编号" prop="userId">
        <el-input v-model="userInfo.userId" :disabled="true" placeholder="请输入用户编号" />
      </el-form-item>
      <el-form-item label="用户名称" prop="username">
        <el-input v-model="userInfo.username" :disabled="true" placeholder="请输入用户名称" />
      </el-form-item>
      <el-form-item label="原角色" prop="perString">
        <el-input v-model="perString" :disabled="true" />
      </el-form-item>
      <el-form-item label="角色列表">
        <el-tree
          ref="roleTree"
          :check-strictly="checkStrictly"
          :data="roleList"
          show-checkbox
          node-key="id"
          class="role-tree"
        />
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="visible = false">
        取消
      </el-button>
      <el-button type="primary" @click="setRoles">
        确认
      </el-button>
    </div>
  </el-dialog>
</template>

<script>
import { isInServiceType } from '@/constant/service'

export default {
    data() {
        return {
            type: '',
            title: '',
            userInfo: {},
            perString:'',
            visible: false,
            checked: [],
            roleList: [],
            checkStrictly: false,
            rules: {
                userId: [{ required: true, trigger: 'blur', message: '请输入用户编号' }],
                username: [{ required: true, trigger: 'blur', message: '请输入用户名称' }],
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
        dialogClose(){
            this.userInfo = {}
            this.perString = ''
            this.checked = []
            this.$refs.roleTree.setCheckedKeys([])
        },
        authRole (userInfo, roleList){
            this.type = 'SETROLES'
            this.userInfo = userInfo
            this.roleList = roleList
            let ret = ''
            if (userInfo.roleList && userInfo.roleList.length>0) {
                userInfo.roleList.forEach((item, index) => {
                    this.checked.push(item.roleId)
                    ret += `【${item.roleName}】`
                })
            }
            this.perString = ret
            this.visible = true
            this.$nextTick(() => {
                this.$refs.roleTree.setCheckedKeys(this.checked)
            })
        },
        setRoles(){
            const setRole = []
            this.$refs.roleTree.getCheckedKeys().forEach(item => {
                if(!isInServiceType(item)){
                  setRole.push({ 'roleId':item })
                }
            })
            this.userInfo.roleList = setRole
            this.visible = false
            this.$emit('confirm', this.type, this.userInfo)
        }
    }
}
</script>