package com.zhouyiteng.gambling.model.web;

import lombok.Data;

/**
 * 结果模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/9.
 */
@Data
public class RaceResult {
    private Double money;

    private Double profit;

    public RaceResult(Double money, Double profit){
        this.money = money;
        this.profit = profit;
    }
}
