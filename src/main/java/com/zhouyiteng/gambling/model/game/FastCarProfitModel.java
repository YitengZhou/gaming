package com.zhouyiteng.gambling.model.game;

import lombok.Data;

/**
 * 急速赛车利润计算模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/9.
 */
@Data
public class FastCarProfitModel {

    public static void raceResult(FastCarModel race, BetRaceModel bet){
        double profit = 0.0;

        // 冠亚和
        double sum_ratio1 = 42.00;
        double sum_ratio2 = 20.80;
        double sum_ratio3 = 13.20;
        double sum_ratio4 = 10.22;
        double sum_ratio5 = 8.02;
        if (race.getFirst() + race.getSecond()==3){
            profit += sum_ratio1 * bet.getSum3();
        }
        if (race.getFirst() + race.getSecond()==4){
            profit += sum_ratio1 * bet.getSum4();
        }
        if (race.getFirst() + race.getSecond()==18){
            profit += sum_ratio1 * bet.getSum18();
        }
        if (race.getFirst() + race.getSecond()==19){
            profit += sum_ratio1 * bet.getSum19();
        }

        if (race.getFirst() + race.getSecond()==5){
            profit += sum_ratio2 * bet.getSum5();
        }
        if (race.getFirst() + race.getSecond()==6){
            profit += sum_ratio2 * bet.getSum6();
        }
        if (race.getFirst() + race.getSecond()==16){
            profit += sum_ratio2 * bet.getSum16();
        }
        if (race.getFirst() + race.getSecond()==17){
            profit += sum_ratio2 * bet.getSum17();
        }

        if (race.getFirst() + race.getSecond()==7){
            profit += sum_ratio3 * bet.getSum7();
        }
        if (race.getFirst() + race.getSecond()==8){
            profit += sum_ratio3 * bet.getSum8();
        }
        if (race.getFirst() + race.getSecond()==14){
            profit += sum_ratio3 * bet.getSum14();
        }
        if (race.getFirst() + race.getSecond()==15){
            profit += sum_ratio3 * bet.getSum15();
        }

        if (race.getFirst() + race.getSecond()==9){
            profit += sum_ratio4 * bet.getSum9();
        }
        if (race.getFirst() + race.getSecond()==10){
            profit += sum_ratio4 * bet.getSum10();
        }
        if (race.getFirst() + race.getSecond()==12){
            profit += sum_ratio4 * bet.getSum12();
        }
        if (race.getFirst() + race.getSecond()==13){
            profit += sum_ratio4 * bet.getSum13();
        }

        if (race.getFirst() + race.getSecond()==11){
            profit += sum_ratio5 * bet.getSum11();
        }

        bet.setProfit(profit);
        bet.setStatus(StatusType.DONE);
    }
}
