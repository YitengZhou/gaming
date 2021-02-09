<template>
  <el-card v-loading="cardLoading" :element-loading-text="cardLoadingText" class="body-card">
    <div class="table-search-wrapper">
      <el-form>
        <!-- <el-row :gutter="48">
          <el-col :md="8" :sm="24">
            <el-form-item>
              <div class="serach-item">
                <span class="item-lable">分组id:</span>
                <el-input v-model="options.groupId" :clearable="true" size="small" placeholder="请输入分组id" />
              </div>
            </el-form-item>
          </el-col>
          <el-col :md="8" :sm="24">
            <el-form-item>
              <div class="serach-item">
                <span class="item-lable">启用状态:</span>
                <el-select v-model="options.isenable" placeholder="请选择状态" style="width: 100%" size="small" clearable>
                  <el-option v-for="item in isEnableList" :key="item.value" :label="item.label" :value="item.value" />
                </el-select>
              </div>
            </el-form-item>
          </el-col>
          <el-col :md="8" :sm="24" class="table-search-buttons">
            <span>
              <el-button size="small" type="primary" icon="el-icon-search" @click="search">查询</el-button>
              <el-button size="small" icon="el-icon-refresh" @click="resetSearch">重置</el-button>
            </span>
          </el-col>
        </el-row> -->
        <el-row :gutter="48">
          <el-col class="table-operator">
            <el-button type="primary" @click="handleSubmit">公布比赛结果</el-button>
          </el-col>
        </el-row>
        <el-row :gutter="48">
          <el-col class="table-operator">
            <el-button type="primary" @click="$refs.editForm.bet(tableData.dataList[0])">投注</el-button>
          </el-col>
        </el-row>
      </el-form>

      <el-table v-loading="tableLoading" :data="tableData.dataList" stripe class="min-350-height-table">
        <el-table-column prop="eid" min-width="0px" label="比赛场次" />
        <el-table-column prop="createTime" min-width="100px" label="生成时间" />
        <el-table-column prop="updateTime" min-width="100px" label="开奖时间" />
        <el-table-column prop="result" min-width="350px" label="比赛结果">
          <!-- <template slot-scope="{row}"> -->
          <!-- <el-tag :color="row.first | getFastCarColor" effect="dark" class="car">
              {{ row.first }}
            </el-tag>
            <el-tag :color="row.second | getFastCarColor" effect="dark" class="car">
              {{ row.second }}
            </el-tag>
            <el-tag :color="row.third | getFastCarColor" effect="dark" class="car">
              {{ row.third }}
            </el-tag>
            <el-tag :color="row.fourth | getFastCarColor" effect="dark" class="car">
              {{ row.fourth }}
            </el-tag>
            <el-tag :color="row.fifth | getFastCarColor" effect="dark" class="car">
              {{ row.fifth }}
            </el-tag>
            <el-tag :color="row.sixth | getFastCarColor" effect="dark" class="car">
              {{ row.sixth }}
            </el-tag>
            <el-tag :color="row.seventh | getFastCarColor" effect="dark" class="car">
              {{ row.seventh }}
            </el-tag>
            <el-tag :color="row.eighth | getFastCarColor" effect="dark" class="car">
              {{ row.eighth }}
            </el-tag>
            <el-tag :color="row.ninth | getFastCarColor" effect="dark" class="car">
              {{ row.ninth }}
            </el-tag>
            <el-tag :color="row.tenth | getFastCarColor" effect="dark" class="car">
              {{ row.tenth }}
            </el-tag> -->
          <!-- </template> -->
        </el-table-column>
        <el-table-column prop="generateType" min-width="100px" label="生成方式" />
        <el-table-column prop="remark" min-width="100px" label="备注信息" />
      </el-table>
      <div class="pagination-wrapper">
        <pagination :total="tableData.totalCount" :page.sync="tableData.pageIndex" :limit.sync="tableData.pageSize" @pagination="getFastCarList" />
      </div>
    </div>
    <edit-Form ref="editForm" @confirm="handlerEditConfirm" />
  </el-card>
</template>

<style lang="scss" scoped>
    .car{
        font-size: 14px;
        border-width: 0;
        margin-right: 2px;
    }
</style>

<script>
    import { mapGetters } from 'vuex'
    import Pagination from '@/components/Pagination'
    import EditForm from './modules/fastcar-edit'
    import { getFastCarColor } from '@/constant/game/fastcar'
    import { testCreate, getFastCarList, betRace } from '@/api/game/fastcar'

    export default {
        components: {
            Pagination,
            EditForm
        },
        filters: {
            getFastCarColor(value){
                return getFastCarColor(value)
            }
        },
        data() {
            return {
                cardLoading: false,
                cardLoadingText: '',
                tableLoading: false,
                options: {
                    srcsvrid: '',
                    targetsvrid: ''
                },
                tableData: {
                    pageSize: 10,
                    pageIndex: 0,
                    totalCount: 0,
                    dataList: []
                }
            }
        },
        computed:{
            ...mapGetters([
                'userId',
                'money'
            ])
        },
        mounted() {
            this.search()
        },
        methods: {
            search() {
                this.tableData.pageIndex = 1
                this.getFastCarList()
            },
            resetSearch(){
                // this.options.srcsvrid = ''
                // this.options.targetsvrid = ''
                this.search()
            },
            getFastCarList(){
                this.tableLoading = true
                getFastCarList({
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
            handleSubmit () {
                const promise = testCreate()
                if (promise) {
                    this.cardLoading = true
                    this.cardLoadingText = '正在提交，请稍候'
                    promise.then(res => {
                        this.search()
                        this.$notify({
                          title: 'Success',
                          message: '操作成功',
                          type: 'success',
                          duration: 3000
                        })
                    })
                    .finally(() => {
                        this.cardLoading = false
                        this.cardLoadingText = ''
                    })
                }
            },
            handlerEditConfirm(dataInfo){
                // if (dataInfo.totalMoney > this.money || dataInfo.totalMoney < 0){
                //       this.$notify({
                //         type: 'warning',
                //         duration: 5000,
                //         title: '提示信息',
                //         message: '投注金额大于账户余额,请重新投注'
                //     })
                //     return
                // }
                dataInfo.userId = this.userId
                this.cardLoading = true
                this.cardLoadingText = '正在提交，请稍候'
                betRace(dataInfo).then(res => {
                    this.$store.commit('user/SET_MONEY', res)
                    this.$notify({
                        type: 'success',
                        duration: 5000,
                        title: '提示信息',
                        message: '投注成功,请关注开奖结果'
                    })
                })
                .finally(() => {
                    this.cardLoading = false
                    this.cardLoadingText = ''
                    this.search()
                })
            }
        }
    }
</script>
