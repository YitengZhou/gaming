<template>
  <el-dialog title="急速赛车PK10" :visible.sync="visible">
    <el-form
      ref="dataForm"
      :rules="rules"
      :model="dataInfo"
      label-position="right"
      label-width="100px"
    >
      <el-row>
        <el-col :xs="12" :sm="12" :lg="12">
          <el-form-item label="比赛场次" prop="raceEid">
            <el-input
              v-model="raceEid"
              disabled="true"
              placeholder="请输入比赛场次"
            />
          </el-form-item>
        </el-col>
        <el-col :xs="12" :sm="12" :lg="12">
          <el-form-item label="投注总金额" prop="money">
            <el-input
              v-model.number="dataInfo.money"
              disabled="true"
              type="number"
              placeholder="请输入投注金额"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-tabs v-model="activeName">
        <el-tab-pane name="bet-double">
          <span slot="label"> 两面盘 </span>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="冠亚军和" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="大" prop="TopBig">
                <el-input v-model="dataInfo.TopBig" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="TopSmall">
                <el-input v-model="dataInfo.TopSmall" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="TopOdd">
                <el-input v-model="dataInfo.ToptOdd" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="TopEven">
                <el-input v-model="dataInfo.TopEven" type="number" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="冠军">
                <el-tag color="rgb(252,251,101)" effect="dark" class="car">
                  {{ 1 }}
                </el-tag>
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="大" prop="firstBig">
                <el-input v-model="dataInfo.firstBig" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="firstSmall">
                <el-input v-model="dataInfo.firstSmall" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="firstOdd">
                <el-input v-model="dataInfo.firstOdd" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="firstEven">
                <el-input v-model="dataInfo.firstEven" type="number" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="龙" prop="firstDragon">
                <el-input v-model="dataInfo.firstDragon" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="虎" prop="firstTiger">
                <el-input v-model="dataInfo.firstTiger" type="number" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="亚军">
                <el-tag color="rgb(82,137,237)" effect="dark" class="car">
                  {{ 2 }}
                </el-tag>
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="大" prop="secondBig">
                <el-input v-model="dataInfo.secondBig" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="secondSmall">
                <el-input v-model="dataInfo.secondSmall" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="secondOdd">
                <el-input v-model="dataInfo.secondOdd" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="secondEven">
                <el-input v-model="dataInfo.secondEven" type="number" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="龙" prop="secondDragon">
                <el-input v-model="dataInfo.secondDragon" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="虎" prop="secondTiger">
                <el-input v-model="dataInfo.secondTiger" type="number" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第三名">
                <el-tag color="rgb(76,78,77)" effect="dark" class="car">
                  {{ 3 }}
                </el-tag>
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="大" prop="thirdBig">
                <el-input v-model="dataInfo.thirdBig" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="thirdSmall">
                <el-input v-model="dataInfo.thirdSmall" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="thirdOdd">
                <el-input v-model="dataInfo.thirdOdd" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="thirdEven">
                <el-input v-model="dataInfo.thirdEven" type="number" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="龙" prop="thirdDragon">
                <el-input v-model="dataInfo.thirdDragon" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="虎" prop="thirdTiger">
                <el-input v-model="dataInfo.thirdTiger" type="number" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第四名">
                <el-tag color="rgb(233,124,55)" effect="dark" class="car">
                  {{ 4 }}
                </el-tag>
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="大" prop="fourthBig">
                <el-input v-model="dataInfo.fourthBig" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="fourthSmall">
                <el-input v-model="dataInfo.fourthSmall" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="fourthOdd">
                <el-input v-model="dataInfo.fourthdOdd" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="fourthEven">
                <el-input v-model="dataInfo.fourthEven" type="number" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="龙" prop="fourthDragon">
                <el-input v-model="dataInfo.fourthDragon" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="虎" prop="fourthTiger">
                <el-input v-model="dataInfo.fourthTiger" type="number" />
              </el-form-item>
            </el-col>
          </el-row>
        
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第五名">
                <el-tag color="rgb(178,250,246)" effect="dark" class="car">
                  {{ 5 }}
                </el-tag>
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="大" prop="fifthBig">
                <el-input v-model="dataInfo.fifthBig" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="fifthSmall">
                <el-input v-model="dataInfo.fifthSmall" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="fifthOdd">
                <el-input v-model="dataInfo.fifthdOdd" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="fifthEven">
                <el-input v-model="dataInfo.fifthEven" type="number" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="龙" prop="fifthDragon">
                <el-input v-model="dataInfo.fifthDragon" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="虎" prop="fifthTiger">
                <el-input v-model="dataInfo.fifthTiger" type="number" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第六名">
                <el-tag color="rgb(76,36,244)" effect="dark" class="car">
                  {{ 6 }}
                </el-tag>
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="大" prop="sixthBig">
                <el-input v-model="dataInfo.sixthBig" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="sixthSmall">
                <el-input v-model="dataInfo.sixthSmall" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="sixthOdd">
                <el-input v-model="dataInfo.sixthdOdd" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="sixthEven">
                <el-input v-model="dataInfo.sixthEven" type="number" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第七名">
                <el-tag color="rgb(182,183,177)" effect="dark" class="car">
                  {{ 7 }}
                </el-tag>
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="大" prop="seventhBig">
                <el-input v-model="dataInfo.seventhBig" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="seventhSmall">
                <el-input v-model="dataInfo.seventhSmall" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="seventhOdd">
                <el-input v-model="dataInfo.seventhdOdd" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="seventhEven">
                <el-input v-model="dataInfo.seventhEven" type="number" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第八名">
                <el-tag color="rgb(238,69,48)" effect="dark" class="car">
                  {{ 8 }}
                </el-tag>
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="大" prop="eighthBig">
                <el-input v-model="dataInfo.eighthBig" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="eighthSmall">
                <el-input v-model="dataInfo.eighthSmall" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="eighthOdd">
                <el-input v-model="dataInfo.eighthdOdd" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="eighthEven">
                <el-input v-model="dataInfo.eighthEven" type="number" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第九名">
                <el-tag color="rgb(99,26,20)" effect="dark" class="car">
                  {{ 9 }}
                </el-tag>
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="大" prop="ninthBig">
                <el-input v-model="dataInfo.ninthBig" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="ninthSmall">
                <el-input v-model="dataInfo.ninthSmall" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="ninthOdd">
                <el-input v-model="dataInfo.ninthdOdd" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="ninthEven">
                <el-input v-model="dataInfo.ninthEven" type="number" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第十名">
                <el-tag color="rgb(107,181,86)" effect="dark" class="car">
                  {{ 10 }}
                </el-tag>
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="大" prop="tenthBig">
                <el-input v-model="dataInfo.tenthBig" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="tenthSmall">
                <el-input v-model="dataInfo.tenthSmall" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="tenthOdd">
                <el-input v-model="dataInfo.tenthdOdd" type="number" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="tenthEven">
                <el-input v-model="dataInfo.tenthEven" type="number" />
              </el-form-item>
            </el-col>
          </el-row>
        </el-tab-pane>
        <el-tab-pane name="bet-car">
          <span slot="label"> 选号盘 </span>
        </el-tab-pane>
        <el-tab-pane name="bet-sum">
          <span slot="label"> 冠亚和 </span>
          <el-form-item label="比赛场次" prop="raceEid">
            <el-input
              v-model="raceEid"
              disabled="true"
              placeholder="请输入比赛场次"
            />
          </el-form-item>
        </el-tab-pane>
      </el-tabs>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="visible = false"> 取消 </el-button>
      <el-button type="primary" @click="handlerProcess"> 确认 </el-button>
    </div>
  </el-dialog>
</template>

<style lang="scss" scoped>
    .car {
        font-size: 14px;
        border-width: 0;
        margin-right: 2px;
    }
    // 用于去除number类型input后面的三角选项框
    ::v-deep input::-webkit-outer-spin-button,
    ::v-deep input::-webkit-inner-spin-button {
        -webkit-appearance: none;
    }
    ::v-deep input[type="number"] {
        -moz-appearance: textfield;
    }
</style>

<script>
export default {
components: {},
data() {
    return {
        visible: false,
        raceEid: 0,
        dataInfo: {
            money: 0
        },
        activeName: 'bet-double',
        rules: {
            money: [{ required: true, trigger: 'blur', message: '请输入投注金额' }]
        }
    }
},
methods: {
    bet(last) {
        this.raceEid = parseInt(last.eid) + 1
        this.dataInfo = {}
        this.dataInfo.money = 0
        this.visible = true
    },
    handlerProcess() {
            this.visible = false
            this.$emit('confirm', this.dataInfo)
        }
    }
}
</script>