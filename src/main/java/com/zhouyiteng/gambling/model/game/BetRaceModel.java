package com.zhouyiteng.gambling.model.game;

import com.zhouyiteng.gambling.model.BaseEntity;
import lombok.Data;

/**
 * 竞猜比赛模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/9.
 */
@Data
public class BetRaceModel extends BaseEntity {
    private String raceId;
    private String userId;
    private Double totalMoney;
    private Double profit;
    private StatusType status = StatusType.WAIT;
    // 两面盘
    private Double topBig = 0.0;
    private Double topSmall = 0.0;
    private Double topOdd = 0.0;
    private Double topEven = 0.0;

    private Double firstBig = 0.0;
    private Double firstSmall = 0.0;
    private Double firstOdd = 0.0;
    private Double firstEven = 0.0;
    private Double firstDragon = 0.0;
    private Double firstTiger = 0.0;

    private Double secondBig = 0.0;
    private Double secondSmall = 0.0;
    private Double secondOdd = 0.0;
    private Double secondEven = 0.0;
    private Double secondDragon = 0.0;
    private Double secondTiger = 0.0;

    private Double thirdBig = 0.0;
    private Double thirdSmall = 0.0;
    private Double thirdOdd = 0.0;
    private Double thirdEven = 0.0;
    private Double thirdDragon = 0.0;
    private Double thirdTiger = 0.0;

    private Double fourthBig = 0.0;
    private Double fourthSmall = 0.0;
    private Double fourthOdd = 0.0;
    private Double fourthEven = 0.0;
    private Double fourthDragon = 0.0;
    private Double fourthTiger = 0.0;

    private Double fifthBig = 0.0;
    private Double fifthSmall = 0.0;
    private Double fifthOdd = 0.0;
    private Double fifthEven = 0.0;
    private Double fifthDragon = 0.0;
    private Double fifthTiger = 0.0;

    private Double sixthBig = 0.0;
    private Double sixthSmall = 0.0;
    private Double sixthOdd = 0.0;
    private Double sixthEven = 0.0;

    private Double seventhBig = 0.0;
    private Double seventhSmall = 0.0;
    private Double seventhOdd = 0.0;
    private Double seventhEven = 0.0;

    private Double eighthBig = 0.0;
    private Double eighthSmall = 0.0;
    private Double eighthOdd = 0.0;
    private Double eighthEven = 0.0;

    private Double ninthBig = 0.0;
    private Double ninthSmall = 0.0;
    private Double ninthOdd = 0.0;
    private Double ninthEven = 0.0;

    private Double tenthBig = 0.0;
    private Double tenthSmall = 0.0;
    private Double tenthOdd = 0.0;
    private Double tenthEven = 0.0;

    // 冠亚和
    private Double sum3 = 0.0;
    private Double sum4 = 0.0;
    private Double sum5 = 0.0;
    private Double sum6 = 0.0;
    private Double sum7 = 0.0;
    private Double sum8 = 0.0;
    private Double sum9 = 0.0;
    private Double sum10 = 0.0;
    private Double sum11 = 0.0;
    private Double sum12 = 0.0;
    private Double sum13 = 0.0;
    private Double sum14 = 0.0;
    private Double sum15 = 0.0;
    private Double sum16 = 0.0;
    private Double sum17 = 0.0;
    private Double sum18 = 0.0;
    private Double sum19 = 0.0;
    // 选号盘
    private Double firstFirst = 0.0;
    private Double firstSecond = 0.0;
    private Double firstThird = 0.0;
    private Double firstFourth = 0.0;
    private Double firstFifth = 0.0;
    private Double firstSixth = 0.0;
    private Double firstSeventh = 0.0;
    private Double firstEighth = 0.0;
    private Double firstNinth = 0.0;
    private Double firstTenth = 0.0;

    private Double secondFirst = 0.0;
    private Double secondSecond = 0.0;
    private Double secondThird = 0.0;
    private Double secondFourth = 0.0;
    private Double secondFifth = 0.0;
    private Double secondSixth = 0.0;
    private Double secondSeventh = 0.0;
    private Double secondEighth = 0.0;
    private Double secondNinth = 0.0;
    private Double secondTenth = 0.0;

    private Double thirdFirst = 0.0;
    private Double thirdSecond = 0.0;
    private Double thirdThird = 0.0;
    private Double thirdFourth = 0.0;
    private Double thirdFifth = 0.0;
    private Double thirdSixth = 0.0;
    private Double thirdSeventh = 0.0;
    private Double thirdEighth = 0.0;
    private Double thirdNinth = 0.0;
    private Double thirdTenth = 0.0;

    private Double fourthFirst = 0.0;
    private Double fourthSecond = 0.0;
    private Double fourthThird = 0.0;
    private Double fourthFourth = 0.0;
    private Double fourthFifth = 0.0;
    private Double fourthSixth = 0.0;
    private Double fourthSeventh = 0.0;
    private Double fourthEighth = 0.0;
    private Double fourthNinth = 0.0;
    private Double fourthTenth = 0.0;

    private Double fifthFirst = 0.0;
    private Double fifthSecond = 0.0;
    private Double fifthThird = 0.0;
    private Double fifthFourth = 0.0;
    private Double fifthFifth = 0.0;
    private Double fifthSixth = 0.0;
    private Double fifthSeventh = 0.0;
    private Double fifthEighth = 0.0;
    private Double fifthNinth = 0.0;
    private Double fifthTenth = 0.0;

    private Double sixthFirst = 0.0;
    private Double sixthSecond = 0.0;
    private Double sixthThird = 0.0;
    private Double sixthFourth = 0.0;
    private Double sixthFifth = 0.0;
    private Double sixthSixth = 0.0;
    private Double sixthSeventh = 0.0;
    private Double sixthEighth = 0.0;
    private Double sixthNinth = 0.0;
    private Double sixthTenth = 0.0;

    private Double seventhFirst = 0.0;
    private Double seventhSecond = 0.0;
    private Double seventhThird = 0.0;
    private Double seventhFourth = 0.0;
    private Double seventhFifth = 0.0;
    private Double seventhSixth = 0.0;
    private Double seventhSeventh = 0.0;
    private Double seventhEighth = 0.0;
    private Double seventhNinth = 0.0;
    private Double seventhTenth = 0.0;

    private Double eighthFirst = 0.0;
    private Double eighthSecond = 0.0;
    private Double eighthThird = 0.0;
    private Double eighthFourth = 0.0;
    private Double eighthFifth = 0.0;
    private Double eighthSixth = 0.0;
    private Double eighthSeventh = 0.0;
    private Double eighthEighth = 0.0;
    private Double eighthNinth = 0.0;
    private Double eighthTenth = 0.0;

    private Double ninthFirst = 0.0;
    private Double ninthSecond = 0.0;
    private Double ninthThird = 0.0;
    private Double ninthFourth = 0.0;
    private Double ninthFifth = 0.0;
    private Double ninthSixth = 0.0;
    private Double ninthSeventh = 0.0;
    private Double ninthEighth = 0.0;
    private Double ninthNinth = 0.0;
    private Double ninthTenth = 0.0;

    private Double tenthFirst = 0.0;
    private Double tenthSecond = 0.0;
    private Double tenthThird = 0.0;
    private Double tenthFourth = 0.0;
    private Double tenthFifth = 0.0;
    private Double tenthSixth = 0.0;
    private Double tenthSeventh = 0.0;
    private Double tenthEighth = 0.0;
    private Double tenthNinth = 0.0;
    private Double tenthTenth = 0.0;
}
