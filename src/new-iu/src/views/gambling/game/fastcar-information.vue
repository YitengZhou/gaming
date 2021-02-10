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
    <el-table
      ref="detailTable"
      v-loading="tableLoading"
      :data="tableData.dataList"
      stripe
      style="width=100%;"
    >
      <!-- 展开项 -->
      <el-table-column label="比赛场次" prop="raceId" />
      <el-table-column label="冠亚和">
        <el-table-column label="大小" prop="topBig">
          <template slot-scope="{row}">
            <el-tag v-if="row.topBig === 1" type="danger">
              大
            </el-tag>
            <el-tag v-else>
              小
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="单双" prop="topOdd">
          <template slot-scope="{row}">
            <el-tag v-if="row.topOdd === 1" type="danger">
              单
            </el-tag>
            <el-tag v-else>
              双
            </el-tag>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="冠军">
        <el-table-column label="大小" prop="firstBig">
          <template slot-scope="{row}">
            <el-tag v-if="row.firstBig === 1" type="danger">
              大
            </el-tag>
            <el-tag v-else>
              小
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="单双" prop="firstOdd">
          <template slot-scope="{row}">
            <el-tag v-if="row.firstOdd === 1" type="danger">
              单
            </el-tag>
            <el-tag v-else>
              双
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="龙虎">
          <template slot-scope="{row}">
            <el-tag v-if="row.firstDragon === 1" type="danger">
              龙
            </el-tag>
            <el-tag v-else>
              虎
            </el-tag>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="亚军">
        <el-table-column label="大小" prop="secondBig">
          <template slot-scope="{row}">
            <el-tag v-if="row.secondBig === 1" type="danger">
              大
            </el-tag>
            <el-tag v-else>
              小
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="单双" prop="secondOdd">
          <template slot-scope="{row}">
            <el-tag v-if="row.secondOdd === 1" type="danger">
              单
            </el-tag>
            <el-tag v-else>
              双
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="龙虎">
          <template slot-scope="{row}" prop="secondDragon">
            <el-tag v-if="row.secondDragon === 1" type="danger">
              龙
            </el-tag>
            <el-tag v-else>
              虎
            </el-tag>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="第三名">
        <el-table-column label="大小" prop="thirdBig">
          <template slot-scope="{row}">
            <el-tag v-if="row.thirdBig === 1" type="danger">
              大
            </el-tag>
            <el-tag v-else>
              小
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="单双" prop="thirdOdd">
          <template slot-scope="{row}">
            <el-tag v-if="row.thirdOdd === 1" type="danger">
              单
            </el-tag>
            <el-tag v-else>
              双
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="龙虎">
          <template slot-scope="{row}" prop="thirdDragon">
            <el-tag v-if="row.thirdDragon === 1" type="danger">
              龙
            </el-tag>
            <el-tag v-else>
              虎
            </el-tag>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="第四名">
        <el-table-column label="大小" prop="fourthBig">
          <template slot-scope="{row}">
            <el-tag v-if="row.fourthBig === 1" type="danger">
              大
            </el-tag>
            <el-tag v-else>
              小
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="单双" prop="fourthOdd">
          <template slot-scope="{row}">
            <el-tag v-if="row.fourthOdd === 1" type="danger">
              单
            </el-tag>
            <el-tag v-else>
              双
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="龙虎">
          <template slot-scope="{row}" prop="fourthDragon">
            <el-tag v-if="row.fourthDragon === 1" type="danger">
              龙
            </el-tag>
            <el-tag v-else>
              虎
            </el-tag>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="第五名">
        <el-table-column label="大小" prop="fifthBig">
          <template slot-scope="{row}">
            <el-tag v-if="row.fifthBig === 1" type="danger">
              大
            </el-tag>
            <el-tag v-else>
              小
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="单双" prop="fifthOdd">
          <template slot-scope="{row}">
            <el-tag v-if="row.fifthOdd === 1" type="danger">
              单
            </el-tag>
            <el-tag v-else>
              双
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="龙虎">
          <template slot-scope="{row}" prop="fifthDragon">
            <el-tag v-if="row.fifthDragon === 1" type="danger">
              龙
            </el-tag>
            <el-tag v-else>
              虎
            </el-tag>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="第六名">
        <el-table-column label="大小" prop="sixthBig">
          <template slot-scope="{row}">
            <el-tag v-if="row.sixthBig === 1" type="danger">
              大
            </el-tag>
            <el-tag v-else>
              小
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="单双" prop="sixthOdd">
          <template slot-scope="{row}">
            <el-tag v-if="row.sixthOdd === 1" type="danger">
              单
            </el-tag>
            <el-tag v-else>
              双
            </el-tag>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="第七名">
        <el-table-column label="大小" prop="seventhBig">
          <template slot-scope="{row}">
            <el-tag v-if="row.seventhBig === 1" type="danger">
              大
            </el-tag>
            <el-tag v-else>
              小
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="单双" prop="seventhOdd">
          <template slot-scope="{row}">
            <el-tag v-if="row.seventhOdd === 1" type="danger">
              单
            </el-tag>
            <el-tag v-else>
              双
            </el-tag>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="第八名">
        <el-table-column label="大小" prop="eighthBig">
          <template slot-scope="{row}">
            <el-tag v-if="row.eighthBig === 1" type="danger">
              大
            </el-tag>
            <el-tag v-else>
              小
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="单双" prop="eighthOdd">
          <template slot-scope="{row}">
            <el-tag v-if="row.eighthhOdd === 1" type="danger">
              单
            </el-tag>
            <el-tag v-else>
              双
            </el-tag>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="第九名">
        <el-table-column label="大小" prop="ninthBig">
          <template slot-scope="{row}">
            <el-tag v-if="row.ninthBig === 1" type="danger">
              大
            </el-tag>
            <el-tag v-else>
              小
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="单双" prop="ninthOdd">
          <template slot-scope="{row}">
            <el-tag v-if="row.ninthOdd === 1" type="danger">
              单
            </el-tag>
            <el-tag v-else>
              双
            </el-tag>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="第十名">
        <el-table-column label="大小" prop="tenthBig">
          <template slot-scope="{row}">
            <el-tag v-if="row.tenthBig === 1" type="danger">
              大
            </el-tag>
            <el-tag v-else>
              小
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="单双" prop="tenthOdd">
          <template slot-scope="{row}">
            <el-tag v-if="row.tenthOdd === 1" type="danger">
              单
            </el-tag>
            <el-tag v-else>
              双
            </el-tag>
          </template>
        </el-table-column>
      </el-table-column>
    </el-table>
  </el-card>
</template>

<style lang="scss" scoped>
    .box-card {
        width: 300px;
    }
</style>

<script>
    import { raceDoneManual, getFastCarResultList, betRace, getLastLongDragon } from '@/api/game/fastcar'
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
                tableLoading: false,
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
                this.getFastCarResultList()
                this.getLastLongDragon()
            },
            getFastCarResultList(){
                this.tableLoading = true
                getFastCarResultList({
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
                }).finally(() => {
                    this.listLoading = false
                })
            }
        }
    }
</script>
