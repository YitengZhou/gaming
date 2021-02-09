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

        // 选号盘
        double select_ratio = 9.85;
        if (race.getFirst() == 1) {
            profit += select_ratio * bet.getFirstFirst();
        } else if (race.getFirst() == 2) {
            profit += select_ratio * bet.getFirstSecond();
        } else if (race.getFirst() == 3) {
            profit += select_ratio * bet.getFirstThird();
        } else if (race.getFirst() == 4) {
            profit += select_ratio * bet.getFirstFourth();
        } else if (race.getFirst() == 5) {
            profit += select_ratio * bet.getFirstFifth();
        } else if (race.getFirst() == 6) {
            profit += select_ratio * bet.getFirstSixth();
        } else if (race.getFirst() == 7) {
            profit += select_ratio * bet.getFirstSeventh();
        } else if (race.getFirst() == 8) {
            profit += select_ratio * bet.getFirstEighth();
        } else if (race.getFirst() == 9) {
            profit += select_ratio * bet.getFirstNinth();
        } else if (race.getFirst() == 10) {
            profit += select_ratio * bet.getFirstTenth();
        }

        if (race.getSecond() == 1) {
            profit += select_ratio * bet.getSecondFirst();
        } else if (race.getSecond() == 2) {
            profit += select_ratio * bet.getSecondSecond();
        } else if (race.getSecond() == 3) {
            profit += select_ratio * bet.getSecondThird();
        } else if (race.getSecond() == 4) {
            profit += select_ratio * bet.getSecondFourth();
        } else if (race.getSecond() == 5) {
            profit += select_ratio * bet.getSecondFifth();
        } else if (race.getSecond() == 6) {
            profit += select_ratio * bet.getSecondSixth();
        } else if (race.getSecond() == 7) {
            profit += select_ratio * bet.getSecondSeventh();
        } else if (race.getSecond() == 8) {
            profit += select_ratio * bet.getSecondEighth();
        } else if (race.getSecond() == 9) {
            profit += select_ratio * bet.getSecondNinth();
        } else if (race.getSecond() == 10) {
            profit += select_ratio * bet.getSecondTenth();
        }

        if (race.getThird() == 1) {
            profit += select_ratio * bet.getThirdFirst();
        } else if (race.getThird() == 2) {
            profit += select_ratio * bet.getThirdSecond();
        } else if (race.getThird() == 3) {
            profit += select_ratio * bet.getThirdThird();
        } else if (race.getThird() == 4) {
            profit += select_ratio * bet.getThirdFourth();
        } else if (race.getThird() == 5) {
            profit += select_ratio * bet.getThirdFifth();
        } else if (race.getThird() == 6) {
            profit += select_ratio * bet.getThirdSixth();
        } else if (race.getThird() == 7) {
            profit += select_ratio * bet.getThirdSeventh();
        } else if (race.getThird() == 8) {
            profit += select_ratio * bet.getThirdEighth();
        } else if (race.getThird() == 9) {
            profit += select_ratio * bet.getThirdNinth();
        } else if (race.getThird() == 10) {
            profit += select_ratio * bet.getThirdTenth();
        }

        if (race.getFourth() == 1) {
            profit += select_ratio * bet.getFourthFirst();
        } else if (race.getFourth() == 2) {
            profit += select_ratio * bet.getFourthSecond();
        } else if (race.getFourth() == 3) {
            profit += select_ratio * bet.getFourthThird();
        } else if (race.getFourth() == 4) {
            profit += select_ratio * bet.getFourthFourth();
        } else if (race.getFourth() == 5) {
            profit += select_ratio * bet.getFourthFifth();
        } else if (race.getFourth() == 6) {
            profit += select_ratio * bet.getFourthSixth();
        } else if (race.getFourth() == 7) {
            profit += select_ratio * bet.getFourthSeventh();
        } else if (race.getFourth() == 8) {
            profit += select_ratio * bet.getFourthEighth();
        } else if (race.getFourth() == 9) {
            profit += select_ratio * bet.getFourthNinth();
        } else if (race.getFourth() == 10) {
            profit += select_ratio * bet.getFourthTenth();
        }

        if (race.getFifth() == 1) {
            profit += select_ratio * bet.getFifthFirst();
        } else if (race.getFifth() == 2) {
            profit += select_ratio * bet.getFifthSecond();
        } else if (race.getFifth() == 3) {
            profit += select_ratio * bet.getFifthThird();
        } else if (race.getFifth() == 4) {
            profit += select_ratio * bet.getFifthFourth();
        } else if (race.getFifth() == 5) {
            profit += select_ratio * bet.getFifthFifth();
        } else if (race.getFifth() == 6) {
            profit += select_ratio * bet.getFifthSixth();
        } else if (race.getFifth() == 7) {
            profit += select_ratio * bet.getFifthSeventh();
        } else if (race.getFifth() == 8) {
            profit += select_ratio * bet.getFifthEighth();
        } else if (race.getFifth() == 9) {
            profit += select_ratio * bet.getFifthNinth();
        } else if (race.getFifth() == 10) {
            profit += select_ratio * bet.getFifthTenth();
        }

        if (race.getSixth() == 1) {
            profit += select_ratio * bet.getSixthFirst();
        } else if (race.getSixth() == 2) {
            profit += select_ratio * bet.getSixthSecond();
        } else if (race.getSixth() == 3) {
            profit += select_ratio * bet.getSixthThird();
        } else if (race.getSixth() == 4) {
            profit += select_ratio * bet.getSixthFourth();
        } else if (race.getSixth() == 5) {
            profit += select_ratio * bet.getSixthFifth();
        } else if (race.getSixth() == 6) {
            profit += select_ratio * bet.getSixthSixth();
        } else if (race.getSixth() == 7) {
            profit += select_ratio * bet.getSixthSeventh();
        } else if (race.getSixth() == 8) {
            profit += select_ratio * bet.getSixthEighth();
        } else if (race.getSixth() == 9) {
            profit += select_ratio * bet.getSixthNinth();
        } else if (race.getSixth() == 10) {
            profit += select_ratio * bet.getSixthTenth();
        }

        if (race.getSeventh() == 1) {
            profit += select_ratio * bet.getSeventhFirst();
        } else if (race.getSeventh() == 2) {
            profit += select_ratio * bet.getSeventhSecond();
        } else if (race.getSeventh() == 3) {
            profit += select_ratio * bet.getSeventhThird();
        } else if (race.getSeventh() == 4) {
            profit += select_ratio * bet.getSeventhFourth();
        } else if (race.getSeventh() == 5) {
            profit += select_ratio * bet.getSeventhFifth();
        } else if (race.getSeventh() == 6) {
            profit += select_ratio * bet.getSeventhSixth();
        } else if (race.getSeventh() == 7) {
            profit += select_ratio * bet.getSeventhSeventh();
        } else if (race.getSeventh() == 8) {
            profit += select_ratio * bet.getSeventhEighth();
        } else if (race.getSeventh() == 9) {
            profit += select_ratio * bet.getSeventhNinth();
        } else if (race.getSeventh() == 10) {
            profit += select_ratio * bet.getSeventhTenth();
        }

        if (race.getEighth() == 1) {
            profit += select_ratio * bet.getEighthFirst();
        } else if (race.getEighth() == 2) {
            profit += select_ratio * bet.getEighthSecond();
        } else if (race.getEighth() == 3) {
            profit += select_ratio * bet.getEighthThird();
        } else if (race.getEighth() == 4) {
            profit += select_ratio * bet.getEighthFourth();
        } else if (race.getEighth() == 5) {
            profit += select_ratio * bet.getEighthFifth();
        } else if (race.getEighth() == 6) {
            profit += select_ratio * bet.getEighthSixth();
        } else if (race.getEighth() == 7) {
            profit += select_ratio * bet.getEighthSeventh();
        } else if (race.getEighth() == 8) {
            profit += select_ratio * bet.getEighthEighth();
        } else if (race.getEighth() == 9) {
            profit += select_ratio * bet.getEighthNinth();
        } else if (race.getEighth() == 10) {
            profit += select_ratio * bet.getEighthTenth();
        }

        if (race.getNinth() == 1) {
            profit += select_ratio * bet.getNinthFirst();
        } else if (race.getNinth() == 2) {
            profit += select_ratio * bet.getNinthSecond();
        } else if (race.getNinth() == 3) {
            profit += select_ratio * bet.getNinthThird();
        } else if (race.getNinth() == 4) {
            profit += select_ratio * bet.getNinthFourth();
        } else if (race.getNinth() == 5) {
            profit += select_ratio * bet.getNinthFifth();
        } else if (race.getNinth() == 6) {
            profit += select_ratio * bet.getNinthSixth();
        } else if (race.getNinth() == 7) {
            profit += select_ratio * bet.getNinthSeventh();
        } else if (race.getNinth() == 8) {
            profit += select_ratio * bet.getNinthEighth();
        } else if (race.getNinth() == 9) {
            profit += select_ratio * bet.getNinthNinth();
        } else if (race.getNinth() == 10) {
            profit += select_ratio * bet.getNinthTenth();
        }

        if (race.getTenth() == 1) {
            profit += select_ratio * bet.getTenthFirst();
        } else if (race.getTenth() == 2) {
            profit += select_ratio * bet.getTenthSecond();
        } else if (race.getTenth() == 3) {
            profit += select_ratio * bet.getTenthThird();
        } else if (race.getTenth() == 4) {
            profit += select_ratio * bet.getTenthFourth();
        } else if (race.getTenth() == 5) {
            profit += select_ratio * bet.getTenthFifth();
        } else if (race.getTenth() == 6) {
            profit += select_ratio * bet.getTenthSixth();
        } else if (race.getTenth() == 7) {
            profit += select_ratio * bet.getTenthSeventh();
        } else if (race.getTenth() == 8) {
            profit += select_ratio * bet.getTenthEighth();
        } else if (race.getTenth() == 9) {
            profit += select_ratio * bet.getTenthNinth();
        } else if (race.getTenth() == 10) {
            profit += select_ratio * bet.getTenthTenth();
        }

        bet.setProfit(profit);
        bet.setStatus(StatusType.DONE);
    }
}
