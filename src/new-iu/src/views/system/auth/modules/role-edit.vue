<template>
  <el-dialog :title="textMap[type]" :visible.sync="visible">
    <el-form ref="dataForm" :rules="rules" :model="roleInfo" label-position="left" label-width="100px">
      <el-form-item label="角色ID" prop="roleId">
        <el-input v-model="roleInfo.roleId" :disabled="!disabled" placeholder="请输入角色ID" clearable />
      </el-form-item>
      <el-form-item label="角色名称" prop="roleName">
        <el-input v-model="roleInfo.roleName" placeholder="请输入角色名称" clearable />
      </el-form-item>
      <el-form-item label="所属服务" prop="service">
        <el-select v-model="roleInfo.service" placeholder="请选择所属服务" style="width: 100%" clearable>
          <el-option v-for="item in serviceType" :key="item.key" :label="item.label" :value="item.key" />
        </el-select>
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
    import {serviceType} from '@/constant/service'

    export default {
        data() {
            return {
                type: '',
                title: '',
                visible: false,
                disabled: true,
                roleInfo: {
                    roleName: '',
                    description: '',
                    service: '',
                    permList: {}
                },
                serviceType,
                textMap: {
                    UPDATE: '编辑角色',
                    ADD: '新建角色'
                },
                rules: {
                    roleId: [{ required: true, message: '请输入角色名称', trigger: 'change' }],
                    roleName: [{ required: true, message: '请输入角色描述', trigger: 'change' }],
                    service: [{ required: true, message: '请选择所属服务', trigger: 'change' }]
                }
            }
        },
        methods: {
            clear() {
                this.disabled = true
                this.roleInfo = {
                    roleName: '',
                    description: '',
                    service: '',
                    permList: {}
                }
                this.$nextTick(() => {
                    this.$refs.dataForm && this.$refs.dataForm.clearValidate()
                })
            },
            add() {
                this.clear()
                this.type = 'ADD'
                this.visible = true
            },
            update(row) {
                this.clear()
                this.type = 'UPDATE'
                this.visible = true
                this.disabled = false
                this.roleInfo = Object.assign({}, row)
            },
            handlerProcess(){
                this.$refs.dataForm.validate(valid => {
                    if(valid){
                        this.visible = false
                        this.$emit('confirm', this.type, this.roleInfo)
                    }else{
                        return false
                    }
                })
            }
        }
    }
</script>
