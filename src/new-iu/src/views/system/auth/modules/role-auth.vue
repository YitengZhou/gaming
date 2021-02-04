<template>
  <el-dialog title="设置角色权限" :visible.sync="visible" @close="dialogClose">
    <el-form ref="dataForm" :rules="rules" :model="roleInfo" label-position="left" label-width="100px">
      <el-form-item label="角色ID" prop="roleId">
        <el-input v-model="roleInfo.roleId" :disabled="true" />
      </el-form-item>
      <el-form-item label="角色姓名" prop="roleName">
        <el-input v-model="roleInfo.roleName" :disabled="true" />
      </el-form-item>
      <el-form-item label="描述" prop="description">
        <el-input v-model="roleInfo.description" :disabled="true" />
      </el-form-item>
      <el-form-item label="所属服务" prop="service">
        <el-input v-model="serviceString" :disabled="true" />
      </el-form-item>
      <el-form-item label="原角色权限" prop="perString">
        <el-input v-model="perString" :disabled="true" />
      </el-form-item>
      <el-form-item label="设置权限">
        <el-tree
          ref="permissionTree"
          :check-strictly="checkStrictly"
          :data="permissionList"
          show-checkbox
          node-key="id"
          :default-expanded-keys="treeExpandData"
          class="permission-tree"
        />
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="visible = false">
        取消
      </el-button>
      <el-button type="primary" @click="setPermissions">
        确认
      </el-button>
    </div>
  </el-dialog>
</template>

<script>
    import { permissionDefine } from '@/constant/permission-define'
    
    export default {
        data() {
            return {
                visible: false,
                type: 'SET_PERMISSION',
                roleInfo: {
                    roleId:'',
                    roleName: '',
                    description: '',
                    permList: []
                },
                treeExpandData: [],
                perString: '',
                serviceString: '',
                permissionList: [],
                checkStrictly: false,
                rules: {
                    roleName: [{ required: true, message: '请填写角色名', trigger: 'change' }],
                    description: [{ required: true, message: '请填写描述', trigger: 'change' }],
                    service: [{ required: true, message: '请填写所属服务', trigger: 'change' }]
                }
            }
        },
        methods: {
            dialogClose(){
                this.treeExpandData = []
                this.permissionList = []
                this.$refs.permissionTree.setCheckedKeys([])
            },
            handleSetPermissions(row) {
                this.roleInfo = Object.assign({}, row)
                const permissions = []
                let ret = ''
                this.roleInfo.permList.forEach((item, index) => {
                    permissions.push(item.permissionName)
                    ret += `【${item.description}】`
                })
                this.perString = ret
                // set tree
                permissionDefine.forEach(item => {
                    if (item.id === this.roleInfo.service){
                        this.permissionList.push(item)
                        this.serviceString = item.label
                    }
                })
                this.visible = true
                this.$nextTick(() => {
                    this.treeExpandData.push(this.roleInfo.service)
                    this.$refs.permissionTree.setCheckedKeys(permissions)
                })
            },
            setPermissions() {
                const setPerm = []
                this.$refs.permissionTree.getCheckedKeys().forEach(item => {
                    if (item.indexOf(':') !== -1) {
                        setPerm.push({ 'permissionName':item })
                    }
                })
                this.roleInfo.permList = setPerm
                this.visible = false
                this.$emit('confirm', this.type, this.roleInfo)
            },
            getChecked(){
                return this.$refs.permissionTree.getCheckedNodes()
            }
        }
    }
</script>