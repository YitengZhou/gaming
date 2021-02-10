package com.zhouyiteng.gambling.dao.game;

import com.zhouyiteng.gambling.model.game.FastCarResultModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 比赛长龙表
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/9.
 */
@Mapper
@Repository
public interface LongDragonMapper {

    /**
     * 添加比赛长龙
     * @param model
     * @return
     */
    long addLongDragon(@Param("model") FastCarResultModel model);

    /**
     * 根据raceId获得长龙
     */
    FastCarResultModel getLongDragon(@Param("raceId") Integer raceId);

    /**
     * 获取最新长龙
     */
    FastCarResultModel getLastLongDragon();
}
