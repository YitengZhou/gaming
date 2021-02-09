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
    private Double sum3;
}
