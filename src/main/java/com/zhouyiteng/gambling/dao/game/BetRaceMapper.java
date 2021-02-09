package com.zhouyiteng.gambling.dao.game;

import com.zhouyiteng.gambling.model.game.BetRaceModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 竞猜投注表
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/9.
 */
@Mapper
@Repository
public interface BetRaceMapper {
    /**
     * 创建竞猜
     * @param model
     * @return
     */
    long addBetRace(@Param("model") BetRaceModel model);

    /**
     * 更新竞猜结果
     * @param model
     * @return
     */
    long updateBetRace(@Param("model") BetRaceModel model);

    /**
     * 根据比赛Id获得所有投注
     * @param raceId
     * @return
     */
    List<BetRaceModel> getTotalRaceBet(@Param("raceId") String raceId);
}
