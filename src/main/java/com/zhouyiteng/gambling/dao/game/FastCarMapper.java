package com.zhouyiteng.gambling.dao.game;

import com.zhouyiteng.gambling.model.game.FastCarModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 急速快车表
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/7.
 */
@Mapper
@Repository
public interface FastCarMapper {

    /**
     * 创建比赛
     * @return
     */
    boolean createNewRace();

    /**
     * 获得最新的比赛
     */
    FastCarModel getLastRace();

    /**
     * 获得比赛根据eid
     */
    FastCarModel getRaceByEid(@Param("eid") int eid);

    /**
     * 更新比赛
     */
    long updateLastRace(@Param("model") FastCarModel model);

    /**
     * 满足条件数量
     */
    long getTotalCount();

    /**
     * 满足条件记录
     * @param pageStart
     * @param pageEnd
     * @return
     */
    List<FastCarModel> getPageList(@Param("pageStart") Long pageStart,
                                   @Param("pageEnd") Long pageEnd);
}
