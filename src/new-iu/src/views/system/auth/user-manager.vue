<template>
  <el-card v-loading="cardLoading" :element-loading-text="cardLoadingText" class="body-card">
    <div class="table-search-wrapper">
      <el-form>
        <el-row :gutter="48">
          <el-col :md="8" :sm="24">
            <el-form-item>
              <div class="serach-item">
                <span class="item-lable">用户ID:</span>
                <el-input v-model="options.userId" :clearable="true" size="small" placeholder="请输入用户编号" />
              </div>
            </el-form-item>
          </el-col>
          <el-col :md="8" :sm="24">
            <el-form-item>
              <div class="serach-item">
                <span class="item-lable">用户名:</span>
                <el-input v-model="options.userName" :clearable="true" size="small" placeholder="请输入用户名称" />
              </div>
            </el-form-item>
          </el-col>
          <el-col :md="8" :sm="24" class="table-search-buttons">
            <span>
              <el-button size="small" type="primary" icon="el-icon-search" @click="search">查询</el-button>
              <el-button size="small" icon="el-icon-refresh" @click="resetSearch">重置</el-button>
            </span>
          </el-col>
        </el-row>
        <el-row :gutter="48">
          <el-col class="table-operator">
            <el-button size="small" type="primary" icon="el-icon-plus" @click="$refs.editForm.add()">新建</el-button>
          </el-col>
        </el-row>
      </el-form>
    </div>
    <el-table v-loading="tableLoading" :data="tableData.dataList" stripe style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="{row}">
          <table width="100%">
            <tr>
              <td class="expand-title">创建时间:</td>
              <td class="expand-content" style="width:50%">{{ row.createTime }}</td>
              <td class="expand-title">修改时间:</td>
              <td class="expand-content" style="width:50%">{{ row.updateTime }}</td>
            </tr>
          </table>
          <el-divider class="expand-divider" />
          <table width="100%">
            <tr>
              <td class="expand-title">角色设置:</td>
              <td class="expand-content" colspan="3" style="width:100%">
                <div>
                  {{ row.roleList | roleListFilter }}
                </div>
              </td> 
            </tr>
          </table>
          <el-divider class="expand-divider" />
        </template>
      </el-table-column>
      <el-table-column prop="userId" label="用户ID" width="180" />
      <el-table-column prop="userName" label="用户名" width="200" />
      <el-table-column prop="status" label="帐号状态" width="120">
        <template slot-scope="{row}">
          <el-tag :type="row.status | getStatusTagType" size="small" effect="dark">
            {{ row.status | getStatusLabel }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="loginFail" label="连续登录失败次数" />
      <el-table-column prop="money" label="金额" />
      <el-table-column label="操作" align="center" width="300" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-popover
            :ref="`able-popover-${scope.$index}`"
            width="200" placement="top" class="action-popover" popper-class="popper-wapper"
          >
            <p>
              <i class="el-icon-question" style="color: rgb(255, 153, 0);" />
              确定{{ scope.row.status | getStatusOperateLabel }}当前记录吗？
            </p>
            <div style="text-align: right; margin: 0">
              <el-button class="popover-btn" size="mini" type="text" @click="ableConfirmClose(scope.$index)">取消</el-button>
              <el-button class="popover-btn" size="mini" type="primary" @click="ableConfirmSubmit(scope.$index, scope.row)">确定</el-button>
            </div>
            <el-button slot="reference" :type="scope.row.status | getStatusOperateBtnType" 
                       size="mini" :icon="scope.row.status | getStatusOperateIcon"
            />
          </el-popover>
          <el-button type="primary" size="mini" icon="el-icon-edit" @click="$refs.editForm.update(scope.row)" />
          <el-button type="info" size="mini" icon="el-icon-refresh" @click="$refs.editForm.resetPassword(scope.row)" />
          <el-popover
            :ref="`delete-popover-${scope.$index}`"
            width="200" placement="top" class="action-popover" popper-class="popper-wapper"
          >
            <p>
              <i class="el-icon-warning" style="color: rgb(255, 0, 0);" />
              确定永久删除该用户吗？
            </p>
            <div style="text-align: right; margin: 0">
              <el-button class="popover-btn" size="mini" type="text" @click="deleteConfirmClose(scope.$index)">取消</el-button>
              <el-button class="popover-btn" size="mini" type="primary" @click="deleteConfirmSubmit(scope.$index, scope.row)">确定</el-button>
            </div>
            <el-button slot="reference" type="danger" size="mini" icon="el-icon-delete" />
          </el-popover>
          <el-divider direction="vertical" />
          <el-button type="success" size="mini" icon="el-icon-s-check" @click="authRole(scope.row)">设置角色</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination-wrapper">
      <pagination :total="tableData.totalCount" :page.sync="tableData.pageIndex" :limit.sync="tableData.pageSize" @pagination="getUserList" />
    </div>
    <edit-Form ref="editForm" @confirm="handlerEditConfirm" />
    <auth-Form ref="authForm" @confirm="handlerEditConfirm" />
  </el-card>
</template>

<style lang="scss" scoped>
    .expand-title{
        min-width: 80px;
        border-bottom: 0px;
    }
    .expand-content{
        border-bottom: 0px;
    }
    .expand-divider{
        margin: 0px 0px;
    }
    .small-padding{
        .action-popover {
            margin: 10px;
        }
        .el-button--mini {
            min-width: 30px;
        }
    }
    .popper-wapper{
        .popover-btn {
            width: 50px;
            margin: 0px 10px 0px 10px;
        }
    }
    .pagination-wrapper{
        float: right;
        .pagination-container{
            padding: 0px 16px 20px 16px;
        }
    }
</style>

<script>
    import EditForm from './modules/user-edit'
    import AuthForm from './modules/user-auth'
    import Pagination from '@/components/Pagination'
    import { getServiceTypeTree } from '@/constant/service'
    import { getStatusLabel, getStatusTagType, getStatusOperateIcon, getStatusOperateLabel, getStatusOperateBtnType } from '@/constant/status'
    import { getUserList, addUser, updateUser, deleteUser, enableUser, disableUser, resetPassword, getRoleList, setRoles } from '@/api/system/system'

    export default {
        name: 'UserManager',
        components: { 
            EditForm,
            AuthForm,
            Pagination 
        },
        filters: {
            getStatusLabel(status){
                return getStatusLabel(status)
            },
            getStatusTagType(status){
                return getStatusTagType(status)
            },
            getStatusOperateIcon(status){
                return getStatusOperateIcon(status)
            },
            getStatusOperateLabel(status){
                return getStatusOperateLabel(status)
            },
            getStatusOperateBtnType(status){
                return getStatusOperateBtnType(status)
            },
            roleListFilter(roleList){
              let ret=''
              if (roleList && roleList.length>0){
                roleList.forEach((item, index) => {
                  ret+=`【${item.roleName}】`
                })
              }
              return ret===''? '无角色设置':ret
            }
        },
        data() {
            return {
                cardLoading: false,
                cardLoadingText: '',
                tableLoading: false,
                serviceRoleMap: null,
                visible: false,
                options: {
                    userId: '',
                    userName: ''
                },
                tableData: {
                    pageSize: 10,
                    pageIndex: 0,
                    totalCount: 0,
                    dataList: []
                }
            }
        },
        mounted() {
            this.search()
        },
        methods: {
            search() {
                this.tableData.pageIndex = 1
                this.getUserList()
            },
            resetSearch(){
                this.options.userId=''
                this.options.userName=''
                this.search()
            },
            ableConfirmClose(index) {
                this.$refs[`able-popover-${index}`].doClose()
            },
            ableConfirmSubmit(index, row){
                this.ableConfirmClose(index)
                this.handlerEditConfirm(row.status==='0'?'ENABLE':'DISABLE', row)
            },
            deleteConfirmClose(index) {
                this.$refs[`delete-popover-${index}`].doClose()
            },
            deleteConfirmSubmit(index, row) {
                this.deleteConfirmClose(index)
                this.handlerEditConfirm('DELETE', row)
            },
            authRole(user){
                this.initServiceRoleMap().then(() => {
                    this.$refs.authForm.authRole(user, this.serviceRoleMap)
                })
            },
            getUserList() {
                this.tableLoading = true
                getUserList({
                    userId: this.options.userId,
                    userName: this.options.userName,
                    pageSize: this.tableData.pageSize,
                    pageIndex: this.tableData.pageIndex
                }).then(res => {
                    if (res) {
                        this.tableData.pageSize = res.pageSize
                        this.tableData.pageIndex = res.pageIndex
                        this.tableData.totalCount = res.totalCount
                        this.tableData.dataList = res.dataList
                    }
                }).finally(() => {
                    this.tableLoading = false
                })
            },
            initServiceRoleMap(){
                return new Promise(resolve => {
                    if(this.serviceRoleMap){
                        resolve()
                    }else{
                        getRoleList().then(res => {
                            this.serviceRoleMap = getServiceTypeTree()
                            this.serviceRoleMap.forEach(x => {
                                const serviceRoleArray = res.filter(item => item.service===x.id)
                                if(serviceRoleArray && serviceRoleArray.length>0){
                                    serviceRoleArray.forEach(y => {
                                        x.children.push({
                                            id: y.roleId,
                                            label: y.roleName
                                        })
                                    })
                                }
                            })
                            resolve()
                        })
                    }
                })
            },
            handlerEditConfirm(type, userInfo){
                let promise = null
                if(type==='ADD'){
                    promise = addUser(userInfo)
                }else if(type==='UPDATE'){
                    promise = updateUser(userInfo)
                }else if(type==='DELETE'){
                    promise = deleteUser(userInfo)
                }else if(type==='ENABLE'){
                    promise = enableUser(userInfo)
                }else if(type==='DISABLE'){
                    promise = disableUser(userInfo)
                }else if(type==='RESETPASSWORD'){
                    promise = resetPassword(userInfo)
                }else if(type==='SETROLES'){
                    promise = setRoles(userInfo)
                }
                if(promise){
                    this.cardLoading = true
                    this.cardLoadingText = '正在提交，请稍候'
                    promise.then(res => {
                        this.getUserList()
                        this.$notify({
                          title: 'Success',
                          message: type + '操作成功',
                          type: 'success',
                          duration: 3000
                        })
                    })
                    .finally(() => {
                        this.cardLoading = false
                        this.cardLoadingText = ''
                    })
                }
            }
        }
    }
</script>