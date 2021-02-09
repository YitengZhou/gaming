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

}
