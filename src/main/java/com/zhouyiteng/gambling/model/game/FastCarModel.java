package com.zhouyiteng.gambling.model.game;

import com.zhouyiteng.gambling.model.BaseEntity;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 急速赛车模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/7.
 */
@Data
public class FastCarModel extends BaseEntity {

    private Integer first;
    private Integer second;
    private Integer third;
    private Integer fourth;
    private Integer fifth;
    private Integer sixth;
    private Integer seventh;
    private Integer eighth;
    private Integer ninth;
    private Integer tenth;
    private GenerateType generateType;
    private String remark;

    public static FastCarModel getRandomRace(FastCarModel ret, GenerateType generateType){
        List<Integer> cars = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collections.shuffle(cars);
        ret.setFirst(cars.get(0));
        ret.setSecond(cars.get(1));
        ret.setThird(cars.get(2));
        ret.setFourth(cars.get(3));
        ret.setFifth(cars.get(4));
        ret.setSixth(cars.get(5));
        ret.setSeventh(cars.get(6));
        ret.setEighth(cars.get(7));
        ret.setNinth(cars.get(8));
        ret.setTenth(cars.get(9));
        ret.setGenerateType(generateType);
        return ret;
    }
}
