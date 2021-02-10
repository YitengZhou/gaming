<template>
  <el-card v-loading="cardLoading" :element-loading-text="cardLoadingText" class="body-card">
    <el-card class="box-card">
      <div slot="header">
        <span>长龙榜</span>
      </div>
      <div v-for="o in 5" :key="o" class="text item">
        {{ '列表内容 ' + o }}
      </div>
      
    </el-card>
  </el-card>
</template>

<style lang="scss" scoped>
    .text {
    font-size: 14px;
    }
    .item {
        margin-bottom: 18px;
    }
    .box-card {
        width: 300px;
    }
</style>

<script>
    import { raceDoneManual, getFastCarList, betRace, getLastLongDragon } from '@/api/game/fastcar'
    export default {
        components: {
        },
        data() {
            return {
                cardLoading: false,
                cardLoadingText: '',
                longDragon: {},
                tableData: {
                    pageSize: 20,
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
                this.getFastCarList()
                this.getLastLongDragon()
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
            getLastLongDragon(){
                getLastLongDragon().then(res => {
                    this.longDragon = res
                })
            }
        }
    }
</script>
