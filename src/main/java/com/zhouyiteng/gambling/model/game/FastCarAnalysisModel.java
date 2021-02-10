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
public class FastCarAnalysisModel {

    public static void raceResult(FastCarModel race, BetRaceModel bet){
        double profit = 0.0;
        // 两面盘
        double double_ratio1 = 1.985;
        double double_ratio2 = 2.233;
        double double_ratio3 = 1.786;
        if (race.getFirst()==6||race.getFirst()==7||race.getFirst()==8||race.getFirst()==9||race.getFirst()==10){
            profit += double_ratio1 * bet.getFirstBig();
        } else {
            profit += double_ratio1 * bet.getFirstSmall();
        }
        if (race.getFirst()==1||race.getFirst()==3||race.getFirst()==5||race.getFirst()==7||race.getFirst()==9){
            profit += double_ratio1 * bet.getFirstOdd();
        } else {
            profit += double_ratio1 * bet.getFirstEven();
        }
        if (race.getFirst() > race.getTenth()){
            profit += double_ratio1 * bet.getFirstDragon();
        } else {
            profit += double_ratio1 * bet.getFirstTiger();
        }

        if (race.getSecond()==6||race.getSecond()==7||race.getSecond()==8||race.getSecond()==9||race.getSecond()==10){
            profit += double_ratio1 * bet.getSecondBig();
        } else {
            profit += double_ratio1 * bet.getSecondSmall();
        }
        if (race.getSecond()==1||race.getSecond()==3||race.getSecond()==5||race.getSecond()==7||race.getSecond()==9){
            profit += double_ratio1 * bet.getSecondOdd();
        } else {
            profit += double_ratio1 * bet.getSecondEven();
        }
        if (race.getSecond() > race.getNinth()){
            profit += double_ratio1 * bet.getSecondDragon();
        } else {
            profit += double_ratio1 * bet.getSecondTiger();
        }

        if (race.getThird()==6||race.getThird()==7||race.getThird()==8||race.getThird()==9||race.getThird()==10){
            profit += double_ratio1 * bet.getThirdBig();
        } else {
            profit += double_ratio1 * bet.getThirdSmall();
        }
        if (race.getThird()==1||race.getThird()==3||race.getThird()==5||race.getThird()==7||race.getThird()==9){
            profit += double_ratio1 * bet.getThirdOdd();
        } else {
            profit += double_ratio1 * bet.getThirdEven();
        }
        if (race.getThird() > race.getEighth()){
            profit += double_ratio1 * bet.getThirdDragon();
        } else {
            profit += double_ratio1 * bet.getThirdTiger();
        }

        if (race.getFourth()==6||race.getFourth()==7||race.getFourth()==8||race.getFourth()==9||race.getFourth()==10){
            profit += double_ratio1 * bet.getFourthBig();
        } else {
            profit += double_ratio1 * bet.getFourthSmall();
        }
        if (race.getFourth()==1||race.getFourth()==3||race.getFourth()==5||race.getFourth()==7||race.getFourth()==9){
            profit += double_ratio1 * bet.getFourthOdd();
        } else {
            profit += double_ratio1 * bet.getFourthEven();
        }
        if (race.getFourth() > race.getSeventh()){
            profit += double_ratio1 * bet.getFourthDragon();
        } else {
            profit += double_ratio1 * bet.getFourthTiger();
        }

        if (race.getFifth()==6||race.getFifth()==7||race.getFifth()==8||race.getFifth()==9||race.getFifth()==10){
            profit += double_ratio1 * bet.getFifthBig();
        } else {
            profit += double_ratio1 * bet.getFifthSmall();
        }
        if (race.getFifth()==1||race.getFifth()==3||race.getFifth()==5||race.getFifth()==7||race.getFifth()==9){
            profit += double_ratio1 * bet.getFifthOdd();
        } else {
            profit += double_ratio1 * bet.getFifthEven();
        }
        if (race.getFifth() > race.getSixth()){
            profit += double_ratio1 * bet.getFifthDragon();
        } else {
            profit += double_ratio1 * bet.getFifthTiger();
        }

        if (race.getSixth()==6||race.getSixth()==7||race.getSixth()==8||race.getSixth()==9||race.getSixth()==10){
            profit += double_ratio1 * bet.getSixthBig();
        } else {
            profit += double_ratio1 * bet.getSixthSmall();
        }
        if (race.getSixth()==1||race.getSixth()==3||race.getSixth()==5||race.getSixth()==7||race.getSixth()==9){
            profit += double_ratio1 * bet.getSixthOdd();
        } else {
            profit += double_ratio1 * bet.getSixthEven();
        }

        if (race.getSeventh()==6||race.getSeventh()==7||race.getSeventh()==8||race.getSeventh()==9||race.getSeventh()==10){
            profit += double_ratio1 * bet.getSeventhBig();
        } else {
            profit += double_ratio1 * bet.getSeventhSmall();
        }
        if (race.getSeventh()==1||race.getSeventh()==3||race.getSeventh()==5||race.getSeventh()==7||race.getSeventh()==9){
            profit += double_ratio1 * bet.getSeventhOdd();
        } else {
            profit += double_ratio1 * bet.getSeventhEven();
        }

        if (race.getEighth()==6||race.getEighth()==7||race.getEighth()==8||race.getEighth()==9||race.getEighth()==10){
            profit += double_ratio1 * bet.getEighthBig();
        } else {
            profit += double_ratio1 * bet.getEighthSmall();
        }
        if (race.getEighth()==1||race.getEighth()==3||race.getEighth()==5||race.getEighth()==7||race.getEighth()==9){
            profit += double_ratio1 * bet.getEighthOdd();
        } else {
            profit += double_ratio1 * bet.getEighthEven();
        }

        if (race.getNinth()==6||race.getNinth()==7||race.getNinth()==8||race.getNinth()==9||race.getNinth()==10){
            profit += double_ratio1 * bet.getNinthBig();
        } else {
            profit += double_ratio1 * bet.getNinthSmall();
        }
        if (race.getNinth()==1||race.getNinth()==3||race.getNinth()==5||race.getNinth()==7||race.getNinth()==9){
            profit += double_ratio1 * bet.getNinthOdd();
        } else {
            profit += double_ratio1 * bet.getNinthEven();
        }

        if (race.getTenth()==6||race.getTenth()==7||race.getTenth()==8||race.getTenth()==9||race.getTenth()==10){
            profit += double_ratio1 * bet.getTenthBig();
        } else {
            profit += double_ratio1 * bet.getTenthSmall();
        }
        if (race.getTenth()==1||race.getTenth()==3||race.getTenth()==5||race.getTenth()==7||race.getTenth()==9){
            profit += double_ratio1 * bet.getTenthOdd();
        } else {
            profit += double_ratio1 * bet.getTenthEven();
        }

        if (race.getFirst() + race.getSecond() > 11){
            profit += double_ratio2 * bet.getTopBig();
        } else {
            profit += double_ratio3 * bet.getTopSmall();
        }
        if ((race.getFirst() + race.getSecond())%2 ==0){
            profit += double_ratio2 * bet.getTopEven();
        } else {
            profit += double_ratio3 * bet.getTopOdd();
        }


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

    public static FastCarResultModel LongDragonResult(FastCarModel race){
        FastCarResultModel longDragon = new FastCarResultModel();
        if (race.getFirst()==6||race.getFirst()==7||race.getFirst()==8||race.getFirst()==9||race.getFirst()==10){
            longDragon.setFirstBig(1);
        } else {
            longDragon.setFirstSmall(1);
        }
        if (race.getFirst()==1||race.getFirst()==3||race.getFirst()==5||race.getFirst()==7||race.getFirst()==9){
            longDragon.setFirstOdd(1);
        } else {
            longDragon.setFirstEven(1);
        }
        if (race.getFirst() > race.getTenth()){
            longDragon.setFirstDragon(1);
        } else {
            longDragon.setFirstTiger(1);
        }

        if (race.getSecond()==6||race.getSecond()==7||race.getSecond()==8||race.getSecond()==9||race.getSecond()==10){
            longDragon.setSecondBig(1);
        } else {
            longDragon.setSecondSmall(1);
        }
        if (race.getSecond()==1||race.getSecond()==3||race.getSecond()==5||race.getSecond()==7||race.getSecond()==9){
            longDragon.setSecondOdd(1);
        } else {
            longDragon.setSecondEven(1);
        }
        if (race.getSecond() > race.getNinth()){
            longDragon.setSecondDragon(1);
        } else {
            longDragon.setSecondTiger(1);
        }

        if (race.getThird()==6||race.getThird()==7||race.getThird()==8||race.getThird()==9||race.getThird()==10){
            longDragon.setThirdBig(1);
        } else {
            longDragon.setThirdSmall(1);
        }
        if (race.getThird()==1||race.getThird()==3||race.getThird()==5||race.getThird()==7||race.getThird()==9){
            longDragon.setThirdOdd(1);
        } else {
            longDragon.setThirdEven(1);
        }
        if (race.getThird() > race.getEighth()){
            longDragon.setThirdDragon(1);
        } else {
            longDragon.setThirdTiger(1);
        }

        if (race.getFourth()==6||race.getFourth()==7||race.getFourth()==8||race.getFourth()==9||race.getFourth()==10){
            longDragon.setFourthBig(1);
        } else {
            longDragon.setFourthSmall(1);
        }
        if (race.getFourth()==1||race.getFourth()==3||race.getFourth()==5||race.getFourth()==7||race.getFourth()==9){
            longDragon.setFourthOdd(1);
        } else {
            longDragon.setFourthEven(1);
        }
        if (race.getFourth() > race.getSeventh()){
            longDragon.setFourthDragon(1);
        } else {
            longDragon.setFourthTiger(1);
        }

        if (race.getFifth()==6||race.getFifth()==7||race.getFifth()==8||race.getFifth()==9||race.getFifth()==10){
            longDragon.setFifthBig(1);
        } else {
            longDragon.setFifthSmall(1);
        }
        if (race.getFifth()==1||race.getFifth()==3||race.getFifth()==5||race.getFifth()==7||race.getFifth()==9){
            longDragon.setFifthOdd(1);
        } else {
            longDragon.setFifthEven(1);
        }
        if (race.getFifth() > race.getSixth()){
            longDragon.setFifthDragon(1);
        } else {
            longDragon.setFifthTiger(1);
        }

        if (race.getSixth()==6||race.getSixth()==7||race.getSixth()==8||race.getSixth()==9||race.getSixth()==10){
            longDragon.setSixthBig(1);
        } else {
            longDragon.setSixthSmall(1);
        }
        if (race.getSixth()==1||race.getSixth()==3||race.getSixth()==5||race.getSixth()==7||race.getSixth()==9){
            longDragon.setSixthOdd(1);
        } else {
            longDragon.setSixthEven(1);
        }

        if (race.getSeventh()==6||race.getSeventh()==7||race.getSeventh()==8||race.getSeventh()==9||race.getSeventh()==10){
            longDragon.setSeventhBig(1);
        } else {
            longDragon.setSeventhSmall(1);
        }
        if (race.getSeventh()==1||race.getSeventh()==3||race.getSeventh()==5||race.getSeventh()==7||race.getSeventh()==9){
            longDragon.setSeventhOdd(1);
        } else {
            longDragon.setSeventhEven(1);
        }

        if (race.getEighth()==6||race.getEighth()==7||race.getEighth()==8||race.getEighth()==9||race.getEighth()==10){
            longDragon.setEighthBig(1);
        } else {
            longDragon.setEighthSmall(1);
        }
        if (race.getEighth()==1||race.getEighth()==3||race.getEighth()==5||race.getEighth()==7||race.getEighth()==9){
            longDragon.setEighthOdd(1);
        } else {
            longDragon.setEighthEven(1);
        }

        if (race.getNinth()==6||race.getNinth()==7||race.getNinth()==8||race.getNinth()==9||race.getNinth()==10){
            longDragon.setNinthBig(1);
        } else {
            longDragon.setNinthSmall(1);
        }
        if (race.getNinth()==1||race.getNinth()==3||race.getNinth()==5||race.getNinth()==7||race.getNinth()==9){
            longDragon.setNinthOdd(1);
        } else {
            longDragon.setNinthEven(1);
        }

        if (race.getTenth()==6||race.getTenth()==7||race.getTenth()==8||race.getTenth()==9||race.getTenth()==10){
            longDragon.setTenthBig(1);
        } else {
            longDragon.setTenthSmall(1);
        }
        if (race.getTenth()==1||race.getTenth()==3||race.getTenth()==5||race.getTenth()==7||race.getTenth()==9){
            longDragon.setTenthOdd(1);
        } else {
            longDragon.setTenthEven(1);
        }

        if (race.getFirst() + race.getSecond() > 11){
            longDragon.setTopBig(1);
        } else {
            longDragon.setTopSmall(1);
        }
        if ((race.getFirst() + race.getSecond())%2 ==0){
            longDragon.setTopEven(1);
        } else {
            longDragon.setTopOdd(1);
        }


        // 冠亚和
        if (race.getFirst() + race.getSecond()==3){
            longDragon.setSum3(1);
        }
        if (race.getFirst() + race.getSecond()==4){
            longDragon.setSum4(1);
        }
        if (race.getFirst() + race.getSecond()==18){
            longDragon.setSum18(1);
        }
        if (race.getFirst() + race.getSecond()==19){
            longDragon.setSum19(1);
        }

        if (race.getFirst() + race.getSecond()==5){
            longDragon.setSum5(1);
        }
        if (race.getFirst() + race.getSecond()==6){
            longDragon.setSum6(1);
        }
        if (race.getFirst() + race.getSecond()==16){
            longDragon.setSum16(1);
        }
        if (race.getFirst() + race.getSecond()==17){
            longDragon.setSum17(1);
        }

        if (race.getFirst() + race.getSecond()==7){
            longDragon.setSum7(1);
        }
        if (race.getFirst() + race.getSecond()==8){
            longDragon.setSum8(1);
        }
        if (race.getFirst() + race.getSecond()==14){
            longDragon.setSum14(1);
        }
        if (race.getFirst() + race.getSecond()==15){
            longDragon.setSum15(1);
        }

        if (race.getFirst() + race.getSecond()==9){
            longDragon.setSum9(1);
        }
        if (race.getFirst() + race.getSecond()==10){
            longDragon.setSum10(1);
        }
        if (race.getFirst() + race.getSecond()==12){
            longDragon.setSum12(1);
        }
        if (race.getFirst() + race.getSecond()==13){
            longDragon.setSum13(1);
        }

        if (race.getFirst() + race.getSecond()==11){
            longDragon.setSum11(1);
        }

        // 选号盘
        if (race.getFirst() == 1) {
            longDragon.setFirstFirst(1);
        } else if (race.getFirst() == 2) {
            longDragon.setFirstSecond(1);
        } else if (race.getFirst() == 3) {
            longDragon.setFirstThird(1);
        } else if (race.getFirst() == 4) {
            longDragon.setFirstFourth(1);
        } else if (race.getFirst() == 5) {
            longDragon.setFirstFifth(1);
        } else if (race.getFirst() == 6) {
            longDragon.setFirstSixth(1);
        } else if (race.getFirst() == 7) {
            longDragon.setFirstSeventh(1);
        } else if (race.getFirst() == 8) {
            longDragon.setFirstEighth(1);
        } else if (race.getFirst() == 9) {
            longDragon.setFirstNinth(1);
        } else if (race.getFirst() == 10) {
            longDragon.setFirstTenth(1);
        }

        if (race.getSecond() == 1) {
            longDragon.setSecondFirst(1);
        } else if (race.getSecond() == 2) {
            longDragon.setSecondSecond(1);
        } else if (race.getSecond() == 3) {
            longDragon.setSecondThird(1);
        } else if (race.getSecond() == 4) {
            longDragon.setSecondFourth(1);
        } else if (race.getSecond() == 5) {
            longDragon.setSecondFifth(1);
        } else if (race.getSecond() == 6) {
            longDragon.setSecondSixth(1);
        } else if (race.getSecond() == 7) {
            longDragon.setSecondSeventh(1);
        } else if (race.getSecond() == 8) {
            longDragon.setSecondEighth(1);
        } else if (race.getSecond() == 9) {
            longDragon.setSecondNinth(1);
        } else if (race.getSecond() == 10) {
            longDragon.setSecondTenth(1);
        }

        if (race.getThird() == 1) {
            longDragon.setThirdFirst(1);
        } else if (race.getThird() == 2) {
            longDragon.setThirdSecond(1);
        } else if (race.getThird() == 3) {
            longDragon.setThirdThird(1);
        } else if (race.getThird() == 4) {
            longDragon.setThirdFourth(1);
        } else if (race.getThird() == 5) {
            longDragon.setThirdFifth(1);
        } else if (race.getThird() == 6) {
            longDragon.setThirdSixth(1);
        } else if (race.getThird() == 7) {
            longDragon.setThirdSeventh(1);
        } else if (race.getThird() == 8) {
            longDragon.setThirdEighth(1);
        } else if (race.getThird() == 9) {
            longDragon.setThirdNinth(1);
        } else if (race.getThird() == 10) {
            longDragon.setThirdTenth(1);
        }

        if (race.getFourth() == 1) {
            longDragon.setFourthFirst(1);
        } else if (race.getFourth() == 2) {
            longDragon.setFourthSecond(1);
        } else if (race.getFourth() == 3) {
            longDragon.setFourthThird(1);
        } else if (race.getFourth() == 4) {
            longDragon.setFourthFourth(1);
        } else if (race.getFourth() == 5) {
            longDragon.setFourthFifth(1);
        } else if (race.getFourth() == 6) {
            longDragon.setFourthSixth(1);
        } else if (race.getFourth() == 7) {
            longDragon.setFourthSeventh(1);
        } else if (race.getFourth() == 8) {
            longDragon.setFourthEighth(1);
        } else if (race.getFourth() == 9) {
            longDragon.setFourthNinth(1);
        } else if (race.getFourth() == 10) {
            longDragon.setFourthTenth(1);
        }

        if (race.getFifth() == 1) {
            longDragon.setFifthFirst(1);
        } else if (race.getFifth() == 2) {
            longDragon.setFifthSecond(1);
        } else if (race.getFifth() == 3) {
            longDragon.setFifthThird(1);
        } else if (race.getFifth() == 4) {
            longDragon.setFifthFourth(1);
        } else if (race.getFifth() == 5) {
            longDragon.setFifthFifth(1);
        } else if (race.getFifth() == 6) {
            longDragon.setFifthSixth(1);
        } else if (race.getFifth() == 7) {
            longDragon.setFifthSeventh(1);
        } else if (race.getFifth() == 8) {
            longDragon.setFifthEighth(1);
        } else if (race.getFifth() == 9) {
            longDragon.setFifthNinth(1);
        } else if (race.getFifth() == 10) {
            longDragon.setFifthTenth(1);
        }

        if (race.getSixth() == 1) {
            longDragon.setSixthFirst(1);
        } else if (race.getSixth() == 2) {
            longDragon.setSixthSecond(1);
        } else if (race.getSixth() == 3) {
            longDragon.setSixthThird(1);
        } else if (race.getSixth() == 4) {
            longDragon.setSixthFourth(1);
        } else if (race.getSixth() == 5) {
            longDragon.setSixthFifth(1);
        } else if (race.getSixth() == 6) {
            longDragon.setSixthSixth(1);
        } else if (race.getSixth() == 7) {
            longDragon.setSixthSeventh(1);
        } else if (race.getSixth() == 8) {
            longDragon.setSixthEighth(1);
        } else if (race.getSixth() == 9) {
            longDragon.setSixthNinth(1);
        } else if (race.getSixth() == 10) {
            longDragon.setSixthTenth(1);
        }

        if (race.getSeventh() == 1) {
            longDragon.setSeventhFirst(1);
        } else if (race.getSeventh() == 2) {
            longDragon.setSeventhSecond(1);
        } else if (race.getSeventh() == 3) {
            longDragon.setSeventhThird(1);
        } else if (race.getSeventh() == 4) {
            longDragon.setSeventhFourth(1);
        } else if (race.getSeventh() == 5) {
            longDragon.setSeventhFifth(1);
        } else if (race.getSeventh() == 6) {
            longDragon.setSeventhSixth(1);
        } else if (race.getSeventh() == 7) {
            longDragon.setSeventhSeventh(1);
        } else if (race.getSeventh() == 8) {
            longDragon.setSeventhEighth(1);
        } else if (race.getSeventh() == 9) {
            longDragon.setSeventhNinth(1);
        } else if (race.getSeventh() == 10) {
            longDragon.setSeventhTenth(1);
        }

        if (race.getEighth() == 1) {
            longDragon.setEighthFirst(1);
        } else if (race.getEighth() == 2) {
            longDragon.setEighthSecond(1);
        } else if (race.getEighth() == 3) {
            longDragon.setEighthThird(1);
        } else if (race.getEighth() == 4) {
            longDragon.setEighthFourth(1);
        } else if (race.getEighth() == 5) {
            longDragon.setEighthFifth(1);
        } else if (race.getEighth() == 6) {
            longDragon.setEighthSixth(1);
        } else if (race.getEighth() == 7) {
            longDragon.setEighthSeventh(1);
        } else if (race.getEighth() == 8) {
            longDragon.setEighthEighth(1);
        } else if (race.getEighth() == 9) {
            longDragon.setEighthNinth(1);
        } else if (race.getEighth() == 10) {
            longDragon.setEighthTenth(1);
        }

        if (race.getNinth() == 1) {
            longDragon.setNinthFirst(1);
        } else if (race.getNinth() == 2) {
            longDragon.setNinthSecond(1);
        } else if (race.getNinth() == 3) {
            longDragon.setNinthThird(1);
        } else if (race.getNinth() == 4) {
            longDragon.setNinthFourth(1);
        } else if (race.getNinth() == 5) {
            longDragon.setNinthFifth(1);
        } else if (race.getNinth() == 6) {
            longDragon.setNinthSixth(1);
        } else if (race.getNinth() == 7) {
            longDragon.setNinthSeventh(1);
        } else if (race.getNinth() == 8) {
            longDragon.setNinthEighth(1);
        } else if (race.getNinth() == 9) {
            longDragon.setNinthNinth(1);
        } else if (race.getNinth() == 10) {
            longDragon.setNinthTenth(1);
        }

        if (race.getTenth() == 1) {
            longDragon.setTenthFirst(1);
        } else if (race.getTenth() == 2) {
            longDragon.setTenthSecond(1);
        } else if (race.getTenth() == 3) {
            longDragon.setTenthThird(1);
        } else if (race.getTenth() == 4) {
            longDragon.setTenthFourth(1);
        } else if (race.getTenth() == 5) {
            longDragon.setTenthFifth(1);
        } else if (race.getTenth() == 6) {
            longDragon.setTenthSixth(1);
        } else if (race.getTenth() == 7) {
            longDragon.setTenthSeventh(1);
        } else if (race.getTenth() == 8) {
            longDragon.setTenthEighth(1);
        } else if (race.getTenth() == 9) {
            longDragon.setTenthNinth(1);
        } else if (race.getTenth() == 10) {
            longDragon.setTenthTenth(1);
        }
        return longDragon;
    }

    public static FastCarResultModel compareLongDragon(FastCarResultModel newLongDragon, FastCarResultModel oldLongDragon){
        FastCarResultModel resultLongDragon = new FastCarResultModel();

        if (newLongDragon.getFirstBig() == 1 ){
            resultLongDragon.setFirstBig(oldLongDragon.getFirstBig() + 1);
        }
        if (newLongDragon.getFirstSmall() == 1 ){
            resultLongDragon.setFirstSmall(oldLongDragon.getFirstSmall() + 1);
        }
        if (newLongDragon.getFirstOdd() == 1 ){
            resultLongDragon.setFirstOdd(oldLongDragon.getFirstOdd() + 1);
        }
        if (newLongDragon.getFirstEven() == 1 ){
            resultLongDragon.setFirstEven(oldLongDragon.getFirstEven() + 1);
        }
        if (newLongDragon.getFirstDragon() == 1 ){
            resultLongDragon.setFirstDragon(oldLongDragon.getFirstDragon() + 1);
        }
        if (newLongDragon.getFirstTiger() == 1 ){
            resultLongDragon.setFirstTiger(oldLongDragon.getFirstTiger() + 1);
        }

        if (newLongDragon.getSecondBig() == 1 ){
            resultLongDragon.setSecondBig(oldLongDragon.getSecondBig() + 1);
        }
        if (newLongDragon.getSecondSmall() == 1 ){
            resultLongDragon.setSecondSmall(oldLongDragon.getSecondSmall() + 1);
        }
        if (newLongDragon.getSecondOdd() == 1 ){
            resultLongDragon.setSecondOdd(oldLongDragon.getSecondOdd() + 1);
        }
        if (newLongDragon.getSecondEven() == 1 ){
            resultLongDragon.setSecondEven(oldLongDragon.getSecondEven() + 1);
        }
        if (newLongDragon.getSecondDragon() == 1 ){
            resultLongDragon.setSecondDragon(oldLongDragon.getSecondDragon() + 1);
        }
        if (newLongDragon.getSecondTiger() == 1 ){
            resultLongDragon.setSecondTiger(oldLongDragon.getSecondTiger() + 1);
        }

        if (newLongDragon.getThirdBig() == 1 ){
            resultLongDragon.setThirdBig(oldLongDragon.getThirdBig() + 1);
        }
        if (newLongDragon.getThirdSmall() == 1 ){
            resultLongDragon.setThirdSmall(oldLongDragon.getThirdSmall() + 1);
        }
        if (newLongDragon.getThirdOdd() == 1 ){
            resultLongDragon.setThirdOdd(oldLongDragon.getThirdOdd() + 1);
        }
        if (newLongDragon.getThirdEven() == 1 ){
            resultLongDragon.setThirdEven(oldLongDragon.getThirdEven() + 1);
        }
        if (newLongDragon.getThirdDragon() == 1 ){
            resultLongDragon.setThirdDragon(oldLongDragon.getThirdDragon() + 1);
        }
        if (newLongDragon.getThirdTiger() == 1 ){
            resultLongDragon.setThirdTiger(oldLongDragon.getThirdTiger() + 1);
        }

        if (newLongDragon.getFourthBig() == 1 ){
            resultLongDragon.setFourthBig(oldLongDragon.getFourthBig() + 1);
        }
        if (newLongDragon.getFourthSmall() == 1 ){
            resultLongDragon.setFourthSmall(oldLongDragon.getFourthSmall() + 1);
        }
        if (newLongDragon.getFourthOdd() == 1 ){
            resultLongDragon.setFourthOdd(oldLongDragon.getFourthOdd() + 1);
        }
        if (newLongDragon.getFourthEven() == 1 ){
            resultLongDragon.setFourthEven(oldLongDragon.getFourthEven() + 1);
        }
        if (newLongDragon.getFourthDragon() == 1 ){
            resultLongDragon.setFourthDragon(oldLongDragon.getFourthDragon() + 1);
        }
        if (newLongDragon.getFourthTiger() == 1 ){
            resultLongDragon.setFourthTiger(oldLongDragon.getFourthTiger() + 1);
        }

        if (newLongDragon.getFifthBig() == 1 ){
            resultLongDragon.setFifthBig(oldLongDragon.getFifthBig() + 1);
        }
        if (newLongDragon.getFifthSmall() == 1 ){
            resultLongDragon.setFifthSmall(oldLongDragon.getFifthSmall() + 1);
        }
        if (newLongDragon.getFifthOdd() == 1 ){
            resultLongDragon.setFifthOdd(oldLongDragon.getFifthOdd() + 1);
        }
        if (newLongDragon.getFifthEven() == 1 ){
            resultLongDragon.setFifthEven(oldLongDragon.getFifthEven() + 1);
        }
        if (newLongDragon.getFifthDragon() == 1 ){
            resultLongDragon.setFifthDragon(oldLongDragon.getFifthDragon() + 1);
        }
        if (newLongDragon.getFifthTiger() == 1 ){
            resultLongDragon.setFifthTiger(oldLongDragon.getFifthTiger() + 1);
        }

        if (newLongDragon.getSixthBig() == 1 ){
            resultLongDragon.setSixthBig(oldLongDragon.getSixthBig() + 1);
        }
        if (newLongDragon.getSixthSmall() == 1 ){
            resultLongDragon.setSixthSmall(oldLongDragon.getSixthSmall() + 1);
        }
        if (newLongDragon.getSixthOdd() == 1 ){
            resultLongDragon.setSixthOdd(oldLongDragon.getSixthOdd() + 1);
        }
        if (newLongDragon.getSixthEven() == 1 ){
            resultLongDragon.setSixthEven(oldLongDragon.getSixthEven() + 1);
        }

        if (newLongDragon.getSeventhBig() == 1 ){
            resultLongDragon.setSeventhBig(oldLongDragon.getSeventhBig() + 1);
        }
        if (newLongDragon.getSeventhSmall() == 1 ){
            resultLongDragon.setSeventhSmall(oldLongDragon.getSeventhSmall() + 1);
        }
        if (newLongDragon.getSeventhOdd() == 1 ){
            resultLongDragon.setSeventhOdd(oldLongDragon.getSeventhOdd() + 1);
        }
        if (newLongDragon.getSeventhEven() == 1 ){
            resultLongDragon.setSeventhEven(oldLongDragon.getSeventhEven() + 1);
        }

        if (newLongDragon.getEighthBig() == 1 ){
            resultLongDragon.setEighthBig(oldLongDragon.getEighthBig() + 1);
        }
        if (newLongDragon.getEighthSmall() == 1 ){
            resultLongDragon.setEighthSmall(oldLongDragon.getEighthSmall() + 1);
        }
        if (newLongDragon.getEighthOdd() == 1 ){
            resultLongDragon.setEighthOdd(oldLongDragon.getEighthOdd() + 1);
        }
        if (newLongDragon.getEighthEven() == 1 ){
            resultLongDragon.setEighthEven(oldLongDragon.getEighthEven() + 1);
        }

        if (newLongDragon.getNinthBig() == 1 ){
            resultLongDragon.setNinthBig(oldLongDragon.getNinthBig() + 1);
        }
        if (newLongDragon.getNinthSmall() == 1 ){
            resultLongDragon.setNinthSmall(oldLongDragon.getNinthSmall() + 1);
        }
        if (newLongDragon.getNinthOdd() == 1 ){
            resultLongDragon.setNinthOdd(oldLongDragon.getNinthOdd() + 1);
        }
        if (newLongDragon.getNinthEven() == 1 ){
            resultLongDragon.setNinthEven(oldLongDragon.getNinthEven() + 1);
        }

        if (newLongDragon.getTenthBig() == 1 ){
            resultLongDragon.setTenthBig(oldLongDragon.getTenthBig() + 1);
        }
        if (newLongDragon.getTenthSmall() == 1 ){
            resultLongDragon.setTenthSmall(oldLongDragon.getTenthSmall() + 1);
        }
        if (newLongDragon.getTenthOdd() == 1 ){
            resultLongDragon.setTenthOdd(oldLongDragon.getTenthOdd() + 1);
        }
        if (newLongDragon.getTenthEven() == 1 ){
            resultLongDragon.setTenthEven(oldLongDragon.getTenthEven() + 1);
        }

        if (newLongDragon.getTopBig() == 1 ){
            resultLongDragon.setTopBig(oldLongDragon.getTopBig() + 1);
        }
        if (newLongDragon.getTopSmall() == 1 ){
            resultLongDragon.setTopSmall(oldLongDragon.getTopSmall() + 1);
        }
        if (newLongDragon.getTopOdd() == 1 ){
            resultLongDragon.setTopOdd(oldLongDragon.getTopOdd() + 1);
        }
        if (newLongDragon.getTopEven() == 1 ){
            resultLongDragon.setTopEven(oldLongDragon.getTopEven() + 1);
        }

        // 冠亚和
        if (newLongDragon.getSum3() == 0 ){
            resultLongDragon.setSum3(oldLongDragon.getSum3() + 1);
        }
        if (newLongDragon.getSum4() == 0 ){
            resultLongDragon.setSum4(oldLongDragon.getSum4() + 1);
        }
        if (newLongDragon.getSum5() == 0 ){
            resultLongDragon.setSum5(oldLongDragon.getSum5() + 1);
        }
        if (newLongDragon.getSum6() == 0 ){
            resultLongDragon.setSum6(oldLongDragon.getSum6() + 1);
        }
        if (newLongDragon.getSum7() == 0 ){
            resultLongDragon.setSum7(oldLongDragon.getSum7() + 1);
        }
        if (newLongDragon.getSum8() == 0 ){
            resultLongDragon.setSum8(oldLongDragon.getSum8() + 1);
        }
        if (newLongDragon.getSum9() == 0 ){
            resultLongDragon.setSum9(oldLongDragon.getSum9() + 1);
        }
        if (newLongDragon.getSum10() == 0 ){
            resultLongDragon.setSum10(oldLongDragon.getSum10() + 1);
        }
        if (newLongDragon.getSum11() == 0 ){
            resultLongDragon.setSum11(oldLongDragon.getSum11() + 1);
        }
        if (newLongDragon.getSum12() == 0 ){
            resultLongDragon.setSum12(oldLongDragon.getSum12() + 1);
        }
        if (newLongDragon.getSum13() == 0 ){
            resultLongDragon.setSum13(oldLongDragon.getSum13() + 1);
        }
        if (newLongDragon.getSum14() == 0 ){
            resultLongDragon.setSum14(oldLongDragon.getSum14() + 1);
        }
        if (newLongDragon.getSum15() == 0 ){
            resultLongDragon.setSum15(oldLongDragon.getSum15() + 1);
        }
        if (newLongDragon.getSum16() == 0 ){
            resultLongDragon.setSum16(oldLongDragon.getSum16() + 1);
        }
        if (newLongDragon.getSum17() == 0 ){
            resultLongDragon.setSum17(oldLongDragon.getSum17() + 1);
        }
        if (newLongDragon.getSum18() == 0 ){
            resultLongDragon.setSum18(oldLongDragon.getSum18() + 1);
        }
        if (newLongDragon.getSum19() == 0 ){
            resultLongDragon.setSum19(oldLongDragon.getSum19() + 1);
        }

        // 选号盘
        if (newLongDragon.getFirstFirst() == 0 ){
            resultLongDragon.setFirstFirst(oldLongDragon.getFirstFirst() + 1);
        }
        if (newLongDragon.getFirstSecond() == 0 ){
            resultLongDragon.setFirstSecond(oldLongDragon.getFirstSecond() + 1);
        }
        if (newLongDragon.getFirstThird() == 0 ){
            resultLongDragon.setFirstThird(oldLongDragon.getFirstThird() + 1);
        }
        if (newLongDragon.getFirstFourth() == 0 ){
            resultLongDragon.setFirstFourth(oldLongDragon.getFirstFourth() + 1);
        }
        if (newLongDragon.getFirstFifth() == 0 ){
            resultLongDragon.setFirstFifth(oldLongDragon.getFirstFifth() + 1);
        }
        if (newLongDragon.getFirstSixth() == 0 ){
            resultLongDragon.setFirstSixth(oldLongDragon.getFirstSixth() + 1);
        }
        if (newLongDragon.getFirstSeventh() == 0 ){
            resultLongDragon.setFirstSeventh(oldLongDragon.getFirstSeventh() + 1);
        }
        if (newLongDragon.getFirstEighth() == 0 ){
            resultLongDragon.setFirstEighth(oldLongDragon.getFirstEighth() + 1);
        }
        if (newLongDragon.getFirstNinth() == 0 ){
            resultLongDragon.setFirstNinth(oldLongDragon.getFirstNinth() + 1);
        }
        if (newLongDragon.getFirstTenth() == 0 ){
            resultLongDragon.setFirstTenth(oldLongDragon.getFirstTenth() + 1);
        }

        if (newLongDragon.getSecondFirst() == 0 ){
            resultLongDragon.setSecondFirst(oldLongDragon.getSecondFirst() + 1);
        }
        if (newLongDragon.getSecondSecond() == 0 ){
            resultLongDragon.setSecondSecond(oldLongDragon.getSecondSecond() + 1);
        }
        if (newLongDragon.getSecondThird() == 0 ){
            resultLongDragon.setSecondThird(oldLongDragon.getSecondThird() + 1);
        }
        if (newLongDragon.getSecondFourth() == 0 ){
            resultLongDragon.setSecondFourth(oldLongDragon.getSecondFourth() + 1);
        }
        if (newLongDragon.getSecondFifth() == 0 ){
            resultLongDragon.setSecondFifth(oldLongDragon.getSecondFifth() + 1);
        }
        if (newLongDragon.getSecondSixth() == 0 ){
            resultLongDragon.setSecondSixth(oldLongDragon.getSecondSixth() + 1);
        }
        if (newLongDragon.getSecondSeventh() == 0 ){
            resultLongDragon.setSecondSeventh(oldLongDragon.getSecondSeventh() + 1);
        }
        if (newLongDragon.getSecondEighth() == 0 ){
            resultLongDragon.setSecondEighth(oldLongDragon.getSecondEighth() + 1);
        }
        if (newLongDragon.getSecondNinth() == 0 ){
            resultLongDragon.setSecondNinth(oldLongDragon.getSecondNinth() + 1);
        }
        if (newLongDragon.getSecondTenth() == 0 ){
            resultLongDragon.setSecondTenth(oldLongDragon.getSecondTenth() + 1);
        }

        if (newLongDragon.getThirdFirst() == 0 ){
            resultLongDragon.setThirdFirst(oldLongDragon.getThirdFirst() + 1);
        }
        if (newLongDragon.getThirdSecond() == 0 ){
            resultLongDragon.setThirdSecond(oldLongDragon.getThirdSecond() + 1);
        }
        if (newLongDragon.getThirdThird() == 0 ){
            resultLongDragon.setThirdThird(oldLongDragon.getThirdThird() + 1);
        }
        if (newLongDragon.getThirdFourth() == 0 ){
            resultLongDragon.setThirdFourth(oldLongDragon.getThirdFourth() + 1);
        }
        if (newLongDragon.getThirdFifth() == 0 ){
            resultLongDragon.setThirdFifth(oldLongDragon.getThirdFifth() + 1);
        }
        if (newLongDragon.getThirdSixth() == 0 ){
            resultLongDragon.setThirdSixth(oldLongDragon.getThirdSixth() + 1);
        }
        if (newLongDragon.getThirdSeventh() == 0 ){
            resultLongDragon.setThirdSeventh(oldLongDragon.getThirdSeventh() + 1);
        }
        if (newLongDragon.getThirdEighth() == 0 ){
            resultLongDragon.setThirdEighth(oldLongDragon.getThirdEighth() + 1);
        }
        if (newLongDragon.getThirdNinth() == 0 ){
            resultLongDragon.setThirdNinth(oldLongDragon.getThirdNinth() + 1);
        }
        if (newLongDragon.getThirdTenth() == 0 ){
            resultLongDragon.setThirdTenth(oldLongDragon.getThirdTenth() + 1);
        }

        if (newLongDragon.getFourthFirst() == 0 ){
            resultLongDragon.setFourthFirst(oldLongDragon.getFourthFirst() + 1);
        }
        if (newLongDragon.getFourthSecond() == 0 ){
            resultLongDragon.setFourthSecond(oldLongDragon.getFourthSecond() + 1);
        }
        if (newLongDragon.getFourthThird() == 0 ){
            resultLongDragon.setFourthThird(oldLongDragon.getFourthThird() + 1);
        }
        if (newLongDragon.getFourthFourth() == 0 ){
            resultLongDragon.setFourthFourth(oldLongDragon.getFourthFourth() + 1);
        }
        if (newLongDragon.getFourthFifth() == 0 ){
            resultLongDragon.setFourthFifth(oldLongDragon.getFourthFifth() + 1);
        }
        if (newLongDragon.getFourthSixth() == 0 ){
            resultLongDragon.setFourthSixth(oldLongDragon.getFourthSixth() + 1);
        }
        if (newLongDragon.getFourthSeventh() == 0 ){
            resultLongDragon.setFourthSeventh(oldLongDragon.getFourthSeventh() + 1);
        }
        if (newLongDragon.getFourthEighth() == 0 ){
            resultLongDragon.setFourthEighth(oldLongDragon.getFourthEighth() + 1);
        }
        if (newLongDragon.getFourthNinth() == 0 ){
            resultLongDragon.setFourthNinth(oldLongDragon.getFourthNinth() + 1);
        }
        if (newLongDragon.getFourthTenth() == 0 ){
            resultLongDragon.setFourthTenth(oldLongDragon.getFourthTenth() + 1);
        }

        if (newLongDragon.getFifthFirst() == 0 ){
            resultLongDragon.setFifthFirst(oldLongDragon.getFifthFirst() + 1);
        }
        if (newLongDragon.getFifthSecond() == 0 ){
            resultLongDragon.setFifthSecond(oldLongDragon.getFifthSecond() + 1);
        }
        if (newLongDragon.getFifthThird() == 0 ){
            resultLongDragon.setFifthThird(oldLongDragon.getFifthThird() + 1);
        }
        if (newLongDragon.getFifthFourth() == 0 ){
            resultLongDragon.setFifthFourth(oldLongDragon.getFifthFourth() + 1);
        }
        if (newLongDragon.getFifthFifth() == 0 ){
            resultLongDragon.setFifthFifth(oldLongDragon.getFifthFifth() + 1);
        }
        if (newLongDragon.getFifthSixth() == 0 ){
            resultLongDragon.setFifthSixth(oldLongDragon.getFifthSixth() + 1);
        }
        if (newLongDragon.getFifthSeventh() == 0 ){
            resultLongDragon.setFifthSeventh(oldLongDragon.getFifthSeventh() + 1);
        }
        if (newLongDragon.getFifthEighth() == 0 ){
            resultLongDragon.setFifthEighth(oldLongDragon.getFifthEighth() + 1);
        }
        if (newLongDragon.getFifthNinth() == 0 ){
            resultLongDragon.setFifthNinth(oldLongDragon.getFifthNinth() + 1);
        }
        if (newLongDragon.getFifthTenth() == 0 ){
            resultLongDragon.setFifthTenth(oldLongDragon.getFifthTenth() + 1);
        }

        if (newLongDragon.getSixthFirst() == 0 ){
            resultLongDragon.setSixthFirst(oldLongDragon.getSixthFirst() + 1);
        }
        if (newLongDragon.getSixthSecond() == 0 ){
            resultLongDragon.setSixthSecond(oldLongDragon.getSixthSecond() + 1);
        }
        if (newLongDragon.getSixthThird() == 0 ){
            resultLongDragon.setSixthThird(oldLongDragon.getSixthThird() + 1);
        }
        if (newLongDragon.getSixthFourth() == 0 ){
            resultLongDragon.setSixthFourth(oldLongDragon.getSixthFourth() + 1);
        }
        if (newLongDragon.getSixthFifth() == 0 ){
            resultLongDragon.setSixthFifth(oldLongDragon.getSixthFifth() + 1);
        }
        if (newLongDragon.getSixthSixth() == 0 ){
            resultLongDragon.setSixthSixth(oldLongDragon.getSixthSixth() + 1);
        }
        if (newLongDragon.getSixthSeventh() == 0 ){
            resultLongDragon.setSixthSeventh(oldLongDragon.getSixthSeventh() + 1);
        }
        if (newLongDragon.getSixthEighth() == 0 ){
            resultLongDragon.setSixthEighth(oldLongDragon.getSixthEighth() + 1);
        }
        if (newLongDragon.getSixthNinth() == 0 ){
            resultLongDragon.setSixthNinth(oldLongDragon.getSixthNinth() + 1);
        }
        if (newLongDragon.getSixthTenth() == 0 ){
            resultLongDragon.setSixthTenth(oldLongDragon.getSixthTenth() + 1);
        }

        if (newLongDragon.getSeventhFirst() == 0 ){
            resultLongDragon.setSeventhFirst(oldLongDragon.getSeventhFirst() + 1);
        }
        if (newLongDragon.getSeventhSecond() == 0 ){
            resultLongDragon.setSeventhSecond(oldLongDragon.getSeventhSecond() + 1);
        }
        if (newLongDragon.getSeventhThird() == 0 ){
            resultLongDragon.setSeventhThird(oldLongDragon.getSeventhThird() + 1);
        }
        if (newLongDragon.getSeventhFourth() == 0 ){
            resultLongDragon.setSeventhFourth(oldLongDragon.getSeventhFourth() + 1);
        }
        if (newLongDragon.getSeventhFifth() == 0 ){
            resultLongDragon.setSeventhFifth(oldLongDragon.getSeventhFifth() + 1);
        }
        if (newLongDragon.getSeventhSixth() == 0 ){
            resultLongDragon.setSeventhSixth(oldLongDragon.getSeventhSixth() + 1);
        }
        if (newLongDragon.getSeventhSeventh() == 0 ){
            resultLongDragon.setSeventhSeventh(oldLongDragon.getSeventhSeventh() + 1);
        }
        if (newLongDragon.getSeventhEighth() == 0 ){
            resultLongDragon.setSeventhEighth(oldLongDragon.getSeventhEighth() + 1);
        }
        if (newLongDragon.getSeventhNinth() == 0 ){
            resultLongDragon.setSeventhNinth(oldLongDragon.getSeventhNinth() + 1);
        }
        if (newLongDragon.getSeventhTenth() == 0 ){
            resultLongDragon.setSeventhTenth(oldLongDragon.getSeventhTenth() + 1);
        }

        if (newLongDragon.getEighthFirst() == 0 ){
            resultLongDragon.setEighthFirst(oldLongDragon.getEighthFirst() + 1);
        }
        if (newLongDragon.getEighthSecond() == 0 ){
            resultLongDragon.setEighthSecond(oldLongDragon.getEighthSecond() + 1);
        }
        if (newLongDragon.getEighthThird() == 0 ){
            resultLongDragon.setEighthThird(oldLongDragon.getEighthThird() + 1);
        }
        if (newLongDragon.getEighthFourth() == 0 ){
            resultLongDragon.setEighthFourth(oldLongDragon.getEighthFourth() + 1);
        }
        if (newLongDragon.getEighthFifth() == 0 ){
            resultLongDragon.setEighthFifth(oldLongDragon.getEighthFifth() + 1);
        }
        if (newLongDragon.getEighthSixth() == 0 ){
            resultLongDragon.setEighthSixth(oldLongDragon.getEighthSixth() + 1);
        }
        if (newLongDragon.getEighthSeventh() == 0 ){
            resultLongDragon.setEighthSeventh(oldLongDragon.getEighthSeventh() + 1);
        }
        if (newLongDragon.getEighthEighth() == 0 ){
            resultLongDragon.setEighthEighth(oldLongDragon.getEighthEighth() + 1);
        }
        if (newLongDragon.getEighthNinth() == 0 ){
            resultLongDragon.setEighthNinth(oldLongDragon.getEighthNinth() + 1);
        }
        if (newLongDragon.getEighthTenth() == 0 ){
            resultLongDragon.setEighthTenth(oldLongDragon.getEighthTenth() + 1);
        }

        if (newLongDragon.getNinthFirst() == 0 ){
            resultLongDragon.setNinthFirst(oldLongDragon.getNinthFirst() + 1);
        }
        if (newLongDragon.getNinthSecond() == 0 ){
            resultLongDragon.setNinthSecond(oldLongDragon.getNinthSecond() + 1);
        }
        if (newLongDragon.getNinthThird() == 0 ){
            resultLongDragon.setNinthThird(oldLongDragon.getNinthThird() + 1);
        }
        if (newLongDragon.getNinthFourth() == 0 ){
            resultLongDragon.setNinthFourth(oldLongDragon.getNinthFourth() + 1);
        }
        if (newLongDragon.getNinthFifth() == 0 ){
            resultLongDragon.setNinthFifth(oldLongDragon.getNinthFifth() + 1);
        }
        if (newLongDragon.getNinthSixth() == 0 ){
            resultLongDragon.setNinthSixth(oldLongDragon.getNinthSixth() + 1);
        }
        if (newLongDragon.getNinthSeventh() == 0 ){
            resultLongDragon.setNinthSeventh(oldLongDragon.getNinthSeventh() + 1);
        }
        if (newLongDragon.getNinthEighth() == 0 ){
            resultLongDragon.setNinthEighth(oldLongDragon.getNinthEighth() + 1);
        }
        if (newLongDragon.getNinthNinth() == 0 ){
            resultLongDragon.setNinthNinth(oldLongDragon.getNinthNinth() + 1);
        }
        if (newLongDragon.getNinthTenth() == 0 ){
            resultLongDragon.setNinthTenth(oldLongDragon.getNinthTenth() + 1);
        }

        if (newLongDragon.getTenthFirst() == 0 ){
            resultLongDragon.setTenthFirst(oldLongDragon.getTenthFirst() + 1);
        }
        if (newLongDragon.getTenthSecond() == 0 ){
            resultLongDragon.setTenthSecond(oldLongDragon.getTenthSecond() + 1);
        }
        if (newLongDragon.getTenthThird() == 0 ){
            resultLongDragon.setTenthThird(oldLongDragon.getTenthThird() + 1);
        }
        if (newLongDragon.getTenthFourth() == 0 ){
            resultLongDragon.setTenthFourth(oldLongDragon.getTenthFourth() + 1);
        }
        if (newLongDragon.getTenthFifth() == 0 ){
            resultLongDragon.setTenthFifth(oldLongDragon.getTenthFifth() + 1);
        }
        if (newLongDragon.getTenthSixth() == 0 ){
            resultLongDragon.setTenthSixth(oldLongDragon.getTenthSixth() + 1);
        }
        if (newLongDragon.getTenthSeventh() == 0 ){
            resultLongDragon.setTenthSeventh(oldLongDragon.getTenthSeventh() + 1);
        }
        if (newLongDragon.getTenthEighth() == 0 ){
            resultLongDragon.setTenthEighth(oldLongDragon.getTenthEighth() + 1);
        }
        if (newLongDragon.getTenthNinth() == 0 ){
            resultLongDragon.setTenthNinth(oldLongDragon.getTenthNinth() + 1);
        }
        if (newLongDragon.getTenthTenth() == 0 ){
            resultLongDragon.setTenthTenth(oldLongDragon.getTenthTenth() + 1);
        }

        return resultLongDragon;
    }
}
