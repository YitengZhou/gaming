<template>
  <el-dialog title="急速赛车PK10" :visible.sync="visible">
    <el-form
      ref="dataForm"
      :rules="rules"
      :model="dataInfo"
      label-position="right"
      label-width="70px"
    >
      <el-row>
        <el-col :xs="12" :sm="12" :lg="12">
          <el-form-item label="比赛场次" prop="raceId">
            <el-input
              v-model="raceId"
              :disabled="true"
              placeholder="请输入比赛场次"
            />
          </el-form-item>
        </el-col>
        <el-col :xs="12" :sm="12" :lg="12">
          <el-form-item label="投注金额" prop="money">
            <el-input
              v-model="totalMoney"
              :disabled="true"
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
                <el-input v-model="dataInfo.TopBig" type="number" placeholder="2.233" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="TopSmall">
                <el-input v-model="dataInfo.TopSmall" type="number" placeholder="1.786" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="TopOdd">
                <el-input v-model="dataInfo.ToptOdd" type="number" placeholder="1.786" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="TopEven">
                <el-input v-model="dataInfo.TopEven" type="number" placeholder="2.233" />
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
                <el-input v-model="dataInfo.firstBig" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="firstSmall">
                <el-input v-model="dataInfo.firstSmall" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="firstOdd">
                <el-input v-model="dataInfo.firstOdd" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="firstEven">
                <el-input v-model="dataInfo.firstEven" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="龙" prop="firstDragon">
                <el-input v-model="dataInfo.firstDragon" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="虎" prop="firstTiger">
                <el-input v-model="dataInfo.firstTiger" type="number" placeholder="1.985" />
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
                <el-input v-model="dataInfo.secondBig" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="secondSmall">
                <el-input v-model="dataInfo.secondSmall" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="secondOdd">
                <el-input v-model="dataInfo.secondOdd" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="secondEven">
                <el-input v-model="dataInfo.secondEven" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="龙" prop="secondDragon">
                <el-input v-model="dataInfo.secondDragon" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="虎" prop="secondTiger">
                <el-input v-model="dataInfo.secondTiger" type="number" placeholder="1.985" />
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
                <el-input v-model="dataInfo.thirdBig" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="thirdSmall">
                <el-input v-model="dataInfo.thirdSmall" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="thirdOdd">
                <el-input v-model="dataInfo.thirdOdd" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="thirdEven">
                <el-input v-model="dataInfo.thirdEven" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="龙" prop="thirdDragon">
                <el-input v-model="dataInfo.thirdDragon" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="虎" prop="thirdTiger">
                <el-input v-model="dataInfo.thirdTiger" type="number" placeholder="1.985" />
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
                <el-input v-model="dataInfo.fourthBig" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="fourthSmall">
                <el-input v-model="dataInfo.fourthSmall" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="fourthOdd">
                <el-input v-model="dataInfo.fourthdOdd" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="fourthEven">
                <el-input v-model="dataInfo.fourthEven" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="龙" prop="fourthDragon">
                <el-input v-model="dataInfo.fourthDragon" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="虎" prop="fourthTiger">
                <el-input v-model="dataInfo.fourthTiger" type="number" placeholder="1.985" />
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
                <el-input v-model="dataInfo.fifthBig" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="fifthSmall">
                <el-input v-model="dataInfo.fifthSmall" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="fifthOdd">
                <el-input v-model="dataInfo.fifthdOdd" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="fifthEven">
                <el-input v-model="dataInfo.fifthEven" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="龙" prop="fifthDragon">
                <el-input v-model="dataInfo.fifthDragon" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="虎" prop="fifthTiger">
                <el-input v-model="dataInfo.fifthTiger" type="number" placeholder="1.985" />
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
                <el-input v-model="dataInfo.sixthBig" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="sixthSmall">
                <el-input v-model="dataInfo.sixthSmall" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="sixthOdd">
                <el-input v-model="dataInfo.sixthdOdd" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="sixthEven">
                <el-input v-model="dataInfo.sixthEven" type="number" placeholder="1.985" />
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
                <el-input v-model="dataInfo.seventhBig" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="seventhSmall">
                <el-input v-model="dataInfo.seventhSmall" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="seventhOdd">
                <el-input v-model="dataInfo.seventhdOdd" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="seventhEven">
                <el-input v-model="dataInfo.seventhEven" type="number" placeholder="1.985" />
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
                <el-input v-model="dataInfo.eighthBig" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="eighthSmall">
                <el-input v-model="dataInfo.eighthSmall" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="eighthOdd">
                <el-input v-model="dataInfo.eighthdOdd" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="eighthEven">
                <el-input v-model="dataInfo.eighthEven" type="number" placeholder="1.985" />
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
                <el-input v-model="dataInfo.ninthBig" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="ninthSmall">
                <el-input v-model="dataInfo.ninthSmall" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="ninthOdd">
                <el-input v-model="dataInfo.ninthdOdd" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="ninthEven">
                <el-input v-model="dataInfo.ninthEven" type="number" placeholder="1.985" />
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
                <el-input v-model="dataInfo.tenthBig" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="小" prop="tenthSmall">
                <el-input v-model="dataInfo.tenthSmall" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="单" prop="tenthOdd">
                <el-input v-model="dataInfo.tenthdOdd" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="5">
              <el-form-item label="双" prop="tenthEven">
                <el-input v-model="dataInfo.tenthEven" type="number" placeholder="1.985" />
              </el-form-item>
            </el-col>
          </el-row>
        </el-tab-pane>
        <el-tab-pane name="bet-car">
          <span slot="label"> 选号盘 </span>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="冠军" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="1" prop="firstFirst">
                <el-input v-model="dataInfo.firstFirst" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="2" prop="firstSecond">
                <el-input v-model="dataInfo.firstSecond" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="firstThird">
                <el-input v-model="dataInfo.firstThird" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="firstFourth">
                <el-input v-model="dataInfo.firstFourth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="firstFifth">
                <el-input v-model="dataInfo.firstFifth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="firstSixth">
                <el-input v-model="dataInfo.firstSixth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="firstSeventh">
                <el-input v-model="dataInfo.firstSeventh" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="firstEighth">
                <el-input v-model="dataInfo.firstEighth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="firstNinth">
                <el-input v-model="dataInfo.firstNinth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="firstTenth">
                <el-input v-model="dataInfo.firstTenth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="亚军" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="1" prop="secondFirst">
                <el-input v-model="dataInfo.secondFirst" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="2" prop="secondSecond">
                <el-input v-model="dataInfo.secondSecond" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="secondThird">
                <el-input v-model="dataInfo.secondThird" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="secondFourth">
                <el-input v-model="dataInfo.secondFourth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="secondFifth">
                <el-input v-model="dataInfo.secondFifth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="secondSixth">
                <el-input v-model="dataInfo.secondSixth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="secondSeventh">
                <el-input v-model="dataInfo.secondSeventh" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="secondEighth">
                <el-input v-model="dataInfo.secondEighth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="secondNinth">
                <el-input v-model="dataInfo.secondNinth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="secondTenth">
                <el-input v-model="dataInfo.secondTenth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="亚军" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="1" prop="secondFirst">
                <el-input v-model="dataInfo.secondFirst" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="2" prop="secondSecond">
                <el-input v-model="dataInfo.secondSecond" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="secondThird">
                <el-input v-model="dataInfo.secondThird" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="secondFourth">
                <el-input v-model="dataInfo.secondFourth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="secondFifth">
                <el-input v-model="dataInfo.secondFifth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="secondSixth">
                <el-input v-model="dataInfo.secondSixth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="secondSeventh">
                <el-input v-model="dataInfo.secondSeventh" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="secondEighth">
                <el-input v-model="dataInfo.secondEighth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="secondNinth">
                <el-input v-model="dataInfo.secondNinth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="secondTenth">
                <el-input v-model="dataInfo.secondTenth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第三名" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="1" prop="thirdFirst">
                <el-input v-model="dataInfo.thirdFirst" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="2" prop="thirdSecond">
                <el-input v-model="dataInfo.thirdSecond" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="thirdThird">
                <el-input v-model="dataInfo.thirdThird" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="thirdFourth">
                <el-input v-model="dataInfo.thirdFourth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="thirdFifth">
                <el-input v-model="dataInfo.thirdFifth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="thirdSixth">
                <el-input v-model="dataInfo.thirdSixth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="thirdSeventh">
                <el-input v-model="dataInfo.thirdSeventh" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="thirdEighth">
                <el-input v-model="dataInfo.thirdEighth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="thirdNinth">
                <el-input v-model="dataInfo.thirdNinth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="thirdTenth">
                <el-input v-model="dataInfo.thirdTenth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第四名" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="1" prop="fourthFirst">
                <el-input v-model="dataInfo.fourthFirst" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="2" prop="fourthSecond">
                <el-input v-model="dataInfo.fourthSecond" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="fourthThird">
                <el-input v-model="dataInfo.fourthThird" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="fourthFourth">
                <el-input v-model="dataInfo.fourthFourth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="fourthFifth">
                <el-input v-model="dataInfo.fourthFifth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="fourthSixth">
                <el-input v-model="dataInfo.fourthSixth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="fourthSeventh">
                <el-input v-model="dataInfo.fourthSeventh" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="fourthEighth">
                <el-input v-model="dataInfo.fourthEighth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="fourthNinth">
                <el-input v-model="dataInfo.fourthNinth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="fourthTenth">
                <el-input v-model="dataInfo.fourthTenth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第五名" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="1" prop="fifthFirst">
                <el-input v-model="dataInfo.fifthFirst" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="2" prop="fifthSecond">
                <el-input v-model="dataInfo.fifthSecond" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="fifthThird">
                <el-input v-model="dataInfo.fifthThird" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="fifthFourth">
                <el-input v-model="dataInfo.fifthFourth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="fifthFifth">
                <el-input v-model="dataInfo.fifthFifth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="fifthSixth">
                <el-input v-model="dataInfo.fifthSixth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="fifthSeventh">
                <el-input v-model="dataInfo.fifthSeventh" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="fifthEighth">
                <el-input v-model="dataInfo.fifthEighth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="fifthNinth">
                <el-input v-model="dataInfo.fifthNinth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="fifthTenth">
                <el-input v-model="dataInfo.fifthTenth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第六名" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="1" prop="sixthFirst">
                <el-input v-model="dataInfo.sixthFirst" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="2" prop="sixthSecond">
                <el-input v-model="dataInfo.sixthSecond" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="sixthThird">
                <el-input v-model="dataInfo.sixthThird" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="sixthFourth">
                <el-input v-model="dataInfo.sixthFourth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="sixthFifth">
                <el-input v-model="dataInfo.sixthFifth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="sixthSixth">
                <el-input v-model="dataInfo.sixthSixth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="sixthSeventh">
                <el-input v-model="dataInfo.sixthSeventh" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="sixthEighth">
                <el-input v-model="dataInfo.sixthEighth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="sixthNinth">
                <el-input v-model="dataInfo.sixthNinth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="sixthTenth">
                <el-input v-model="dataInfo.sixthTenth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第七名" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="1" prop="seventhFirst">
                <el-input v-model="dataInfo.seventhFirst" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="2" prop="seventhSecond">
                <el-input v-model="dataInfo.seventhSecond" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="seventhThird">
                <el-input v-model="dataInfo.seventhThird" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="seventhFourth">
                <el-input v-model="dataInfo.seventhFourth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="seventhFifth">
                <el-input v-model="dataInfo.seventhFifth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="seventhSixth">
                <el-input v-model="dataInfo.seventhSixth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="seventhSeventh">
                <el-input v-model="dataInfo.seventhSeventh" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="seventhEighth">
                <el-input v-model="dataInfo.seventhEighth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="seventhNinth">
                <el-input v-model="dataInfo.seventhNinth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="seventhTenth">
                <el-input v-model="dataInfo.seventhTenth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第八名" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="1" prop="eighthFirst">
                <el-input v-model="dataInfo.eighthFirst" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="2" prop="eighthSecond">
                <el-input v-model="dataInfo.eighthSecond" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="eighthThird">
                <el-input v-model="dataInfo.eighthThird" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="eighthFourth">
                <el-input v-model="dataInfo.eighthFourth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="eighthFifth">
                <el-input v-model="dataInfo.eighthFifth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="eighthSixth">
                <el-input v-model="dataInfo.eighthSixth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="eighthSeventh">
                <el-input v-model="dataInfo.eighthSeventh" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="eighthEighth">
                <el-input v-model="dataInfo.eighthEighth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="eighthNinth">
                <el-input v-model="dataInfo.eighthNinth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="eighthTenth">
                <el-input v-model="dataInfo.eighthTenth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第九名" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="1" prop="nighthFirst">
                <el-input v-model="dataInfo.nighthFirst" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="2" prop="nighthSecond">
                <el-input v-model="dataInfo.nighthSecond" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="nighthThird">
                <el-input v-model="dataInfo.nighthThird" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="nighthFourth">
                <el-input v-model="dataInfo.nighthFourth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="nighthFifth">
                <el-input v-model="dataInfo.nighthFifth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="nighthSixth">
                <el-input v-model="dataInfo.nighthSixth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="nighthSeventh">
                <el-input v-model="dataInfo.nighthSeventh" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="nighthEighth">
                <el-input v-model="dataInfo.nighthEighth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="nighthNinth">
                <el-input v-model="dataInfo.nighthNinth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="nighthTenth">
                <el-input v-model="dataInfo.nighthTenth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item label="第十名" />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="1" prop="tenthFirst">
                <el-input v-model="dataInfo.tenthFirst" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="2" prop="tenthSecond">
                <el-input v-model="dataInfo.tenthSecond" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="tenthThird">
                <el-input v-model="dataInfo.tenthThird" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="tenthFourth">
                <el-input v-model="dataInfo.tenthFourth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="tenthFifth">
                <el-input v-model="dataInfo.tenthFifth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="2">
              <el-form-item />
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="tenthSixth">
                <el-input v-model="dataInfo.tenthSixth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="tenthSeventh">
                <el-input v-model="dataInfo.tenthSeventh" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="tenthEighth">
                <el-input v-model="dataInfo.tenthEighth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="tenthNinth">
                <el-input v-model="dataInfo.tenthNinth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="tenthTenth">
                <el-input v-model="dataInfo.tenthTenth" type="number" placeholder="9.85" />
              </el-form-item>
            </el-col>
          </el-row>
        </el-tab-pane>
        <el-tab-pane name="bet-sum">
          <span slot="label"> 冠亚和 </span>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="3" prop="sum3">
                <el-input v-model="dataInfo.sum3" type="number" placeholder="42" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="4" prop="sum4">
                <el-input v-model="dataInfo.sum4" type="number" placeholder="42" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="5" prop="sum5">
                <el-input v-model="dataInfo.sum5" type="number" placeholder="20.8" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="6" prop="sum6">
                <el-input v-model="dataInfo.sum6" type="number" placeholder="20.8" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="7" prop="sum7">
                <el-input v-model="dataInfo.sum7" type="number" placeholder="13.2" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="8" prop="sum8">
                <el-input v-model="dataInfo.sum8" type="number" placeholder="13.2" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="9" prop="sum9">
                <el-input v-model="dataInfo.sum9" type="number" placeholder="10.22" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="10" prop="sum10">
                <el-input v-model="dataInfo.sum10" type="number" placeholder="10.22" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="11" prop="sum11">
                <el-input v-model="dataInfo.sum11" type="number" placeholder="8.02" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="12" prop="sum12">
                <el-input v-model="dataInfo.sum12" type="number" placeholder="10.22" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="13" prop="sum13">
                <el-input v-model="dataInfo.sum13" type="number" placeholder="10.22" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="14" prop="sum14">
                <el-input v-model="dataInfo.sum14" type="number" placeholder="13.2" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="15" prop="sum15">
                <el-input v-model="dataInfo.sum15" type="number" placeholder="13.2" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="16" prop="sum16">
                <el-input v-model="dataInfo.sum16" type="number" placeholder="20.08" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="17" prop="sum17">
                <el-input v-model="dataInfo.sum17" type="number" placeholder="20.08" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="18" prop="sum18">
                <el-input v-model="dataInfo.sum18" type="number" placeholder="42" />
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12" :lg="4">
              <el-form-item label="19" prop="sum19">
                <el-input v-model="dataInfo.sum19" type="number" placeholder="42" />
              </el-form-item>
            </el-col>
          </el-row>

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
        raceId: 0,
        money: 0,
        dataInfo: {},
        activeName: 'bet-double',
        rules: {}
    }
},
computed:{
    totalMoney: function(){
        let total = 0
        for(const key in this.dataInfo){
            if (this.dataInfo[key] && (this.dataInfo[key] !=='')){
                total = total + parseFloat(this.dataInfo[key])
            }
        }
        return total
    }
},
methods: {
    bet(last) {
        this.raceId = parseInt(last.eid)
        this.money = 0
        this.dataInfo = {}
        this.visible = true
    },
    handlerProcess() {
        this.$refs.dataForm.validate(valid => {
            if(valid){
                this.visible = false
                this.dataInfo.totalMoney = this.totalMoney
                this.dataInfo.raceId = this.raceId
                this.$emit('confirm', this.dataInfo)
            }else{
                return false
            }
        })
        }
    }
}
</script>