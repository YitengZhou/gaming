<template>
  <el-card v-loading="cardLoading" :element-loading-text="cardLoadingText" class="body-card">
    <div class="table-search-wrapper">
      <el-form>
        <el-row :gutter="48">
          <el-col :md="6" :sm="24">
            <el-form-item>
              <div class="serach-item">
                <span class="item-lable">角色名称:</span>
                <el-input v-model="options.name" size="small" placeholder="请输入角色名称" clearable @keyup.enter.native="handleFilter" />
              </div>
            </el-form-item>
          </el-col>
          <el-col :md="6" :sm="24">
            <el-form-item>
              <div class="serach-item">
                <span class="item-lable">角色描述:</span>
                <el-input v-model="options.description" size="small" placeholder="请输入角色描述" clearable @keyup.enter.native="handleFilter" />
              </div>
            </el-form-item>
          </el-col>
          <el-col :md="6" :sm="24">
            <el-form-item>
              <div class="serach-item">
                <span class="item-lable">所属服务:</span>
                <el-select v-model="options.service" placeholder="请选择所属服务" style="width: 100%" clearable>
                  <el-option v-for="item in serviceType" :key="item.key" :label="item.label" :value="item.key" />
                </el-select>
              </div>
            </el-form-item>
          </el-col>
          <el-col :md="6" :sm="24" class="table-search-buttons">
            <span>
              <el-button size="small" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
              <el-button size="small" style="margin-left: 16px" icon="el-icon-refresh" @click="resetSearchForm">重置</el-button>
            </span>
          </el-col>
        </el-row>
        <el-row :gutter="48">
          <el-col class="table-operator">
            <el-button size="small" type="primary" icon="el-icon-plus" @click="$refs.editRole.add()">新建</el-button>
          </el-col>
        </el-row>
      </el-form>
    </div>

    <el-table
      ref="table"
      v-loading="listLoading"
      :data="tableData.dataList"
      stripe
      style="width: 100%"
    >
      <el-table-column type="expand">
        <template slot-scope="{row}">
          <table width="100%">
            <tr>
              <td class="expand-title">创建时间</td>
              <td class="expand-content" style="width:50%">{{ row.createTime }}</td>
              <td class="expand-title">修改时间</td>
              <td class="expand-content" style="width:50%">{{ row.updateTime }}</td>
            </tr>
          </table>
          <el-divider class="expand-divider" />
          <table width="100%">
            <tr>
              <td class="expand-title">权限设置</td>
              <td class="expand-content" colspan="3" style="width:100%">
                <div>
                  {{ row.permList | permissionsFilter }}
                </div>
              </td> 
            </tr>
          </table>
          <el-divider class="expand-divider" />
        </template>
      </el-table-column>
      <el-table-column label="角色id" prop="name" width="200px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.roleId }}</span>
        </template>
      </el-table-column>
      <el-table-column label="角色名称" prop="description" align="center" width="200px">
        <template slot-scope="{row}">
          <el-tag>{{ row.roleName }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="所属服务" prop="service" align="center">
        <template slot-scope="{row}">
          <span>{{ row.service | serviceFileter }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="300" class-name="small-padding fixed-width">
        <template slot-scope="{row}">
          <el-button type="primary" size="mini" icon="el-icon-edit" @click="$refs.editRole.update(row)" />
          <!-- <el-button type="danger" size="mini" icon="el-icon-delete" @click="$refs.editRole.delete(row)" /> -->
          <el-popover
            :ref="`delete-popover-${row.eid}`"
            width="200" placement="top" class="action-popover" popper-class="popper-wapper"
          >
            <p>
              <i class="el-icon-warning" style="color: rgb(255, 0, 0);" />
              确定永久删除该角色吗？
            </p>
            <div style="text-align: right; margin: 0">
              <el-button class="popover-btn" size="mini" type="text" @click="deleteConfirmClose(row.eid)">取消</el-button>
              <el-button class="popover-btn" size="mini" type="primary" @click="deleteConfirmSubmit(row.eid, row)">确定</el-button>
            </div>
            <el-button slot="reference" type="danger" size="mini" icon="el-icon-delete" />
          </el-popover>
          <el-divider direction="vertical" />
          <el-button type="success" size="mini" icon="el-icon-s-check" @click="$refs.authRole.handleSetPermissions(row)">
            设置权限
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <div class="pagination-wrapper">
      <pagination v-show="tableData.totalCount>=0" :total="tableData.totalCount" :page.sync="tableData.pageIndex" :limit.sync="tableData.pageSize" @pagination="getList" />
    </div>

    <edit-Role ref="editRole" @confirm="handlerEditConfirm" />
    <auth-Role ref="authRole" @confirm="handlerEditConfirm" />
  </el-card>
</template>

<script>
    import Pagination from '@/components/Pagination'
    import EditRole from './modules/role-edit'
    import AuthRole from './modules/role-auth'
    import { getPermissionLabel } from '@/constant/permission-define'
    import { serviceType, getServiceLabel } from '@/constant/service'
    import { addRole, deleteRole, updateRole, roleQueryList, setPermissions } from '@/api/system/system'

    export default {
        name: 'RoleManager',
        components: { 
            Pagination,
            EditRole,
            AuthRole
        },
        filters: {
            permissionsFilter(value) {
                let ret = ''
                if (value && value.length > 0) {
                    value.forEach(item => {
                      ret += `【${item.description}】`
                    })
                }
                return ret===''? '无权限设置':ret
            },
            serviceFileter(value){
                return getServiceLabel(value)
            }
        },
        data() {
            return {
                cardLoading: false,
                cardLoadingText: '',
                listLoading: true,
                serviceType,
                options: {
                    name: '',
                    description: '',
                    service: ''
                },
                tableData: {
                    pageIndex: 0,
                    pageSize: 10,
                    totalCount: 0,
                    dataList: []
                }
            }
        },
        computed: {
            canPre() {
                return this.tableData.pageIndex && this.tableData.pageIndex > 0
            },
            canNext() {
                return this.tableData.totalCount === -1 || (this.tableData.totalCount >= this.tableData.pageSize)
            }
        },
        created() {
            this.getList()
        },
        methods: {
            getList() {
                this.listLoading = true
                roleQueryList({
                    name: this.options.name,
                    description: this.options.description,
                    service: this.options.service,
                    pageSize: this.tableData.pageSize,
                    pageIndex: this.tableData.pageIndex
                }).then(response => {
                    if (response){
                      this.tableData.pageSize = response.pageSize
                      this.tableData.pageIndex = response.pageIndex
                      this.tableData.totalCount = response.totalCount
                      this.tableData.dataList = response.dataList
                      // 从permission-define权限树tree中获取权限label
                      this.tableData.dataList.forEach(item => {
                          item.permList.forEach(perm => {
                            perm.description = getPermissionLabel(item.service, perm.permissionName)
                          })
                      })
                    }
                }).finally(() => {
                    this.listLoading = false
                })
            },
            prePage() {
                if (this.canPre) {
                    this.tableData.pageIndex--
                    this.getList()
                }
            },
            nextPage() {
                if (this.canNext) {
                    this.tableData.pageIndex++
                    this.getList()
                }
            },
            handleFilter() {
                this.tableData.pageIndex = 0
                this.getList()
            },
            resetSearchForm() {
                this.options.name = ''
                this.options.description = ''
                this.options.service = ''
                this.getList()
            },
            deleteConfirmClose(index) {
                this.$refs[`delete-popover-${index}`].doClose()
            },
            deleteConfirmSubmit(index, row) {
                this.deleteConfirmClose(index)
                this.handlerEditConfirm('DELETE', row)
            },
            handlerEditConfirm (type, userInfo) {
                let promise = null
                if (type === 'ADD') {
                    promise = addRole(userInfo)
                }else if (type === 'UPDATE') {
                    promise = updateRole(userInfo)
                }else if (type === 'DELETE') {
                    promise = deleteRole(userInfo)
                }else if (type === 'SET_PERMISSION'){
                    promise = setPermissions(userInfo)
                }
                if (promise) {
                    this.cardLoading = true
                    this.cardLoadingText = '正在提交，请稍候'
                    promise.then(res => {
                        this.getList()
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
    .pagination-wrapper{
        float: right;
        .pagination-container{
            padding: 0px 16px 20px 16px;
        }
    }
    .permission-tree {
        margin-bottom: 30px;
    }
</style>
