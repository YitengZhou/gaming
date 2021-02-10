<template>
  <el-card v-loading="cardLoading" :element-loading-text="cardLoadingText" class="body-card">
    <el-card class="box-card">
      <span>长龙榜</span>
      <el-table
        ref="longDragonTable"
        v-loading="listLoading"
        title="长龙榜"
        :data="longDragon"
        style="width=30%;"
      >
        <el-table-column prop="name">
          <template slot-scope="{row}">
            {{ row.name | getLongDragonLabel }}
          </template>
        </el-table-column>
        <el-table-column prop="number" />
      </el-table>
    </el-card>
  </el-card>
</template>

<style lang="scss" scoped>
    .box-card {
        width: 300px;
    }
</style>

<script>
    import { raceDoneManual, getFastCarList, betRace, getLastLongDragon } from '@/api/game/fastcar'
    import { getLongDragonLabel } from '@/constant/game/longdragon'
    export default {
        components: {
        },
        filters: {
            getLongDragonLabel(value){
                return getLongDragonLabel(value)
            }
        },
        data() {
            return {
                cardLoading: false,
                cardLoadingText: '',
                listLoading: false,
                longDragon: [],
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
                this.listLoading = true
                getLastLongDragon().then(res => {
                    const result = []
                    for (const key of Object.keys(res)) {
                        if (key.indexOf('Even') !== -1 || key.indexOf('Odd') !== -1 ||
                        key.indexOf('Big') !== -1 || key.indexOf('Small') !== -1 ||
                        key.indexOf('Tiger') !== -1 || key.indexOf('Dragon') !== -1){
                            if (res[key] >= 5){
                                result.push({name: key, number: res[key]})
                            }
                        }
                    }
                    this.longDragon = result
                    console.log(this.longDragon)
                }).finally(() => {
                    this.listLoading = false
                })
            }
        }
    }
</script>
