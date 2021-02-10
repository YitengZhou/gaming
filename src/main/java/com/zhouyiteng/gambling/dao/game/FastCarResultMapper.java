package com.zhouyiteng.gambling.dao.game;

import com.zhouyiteng.gambling.model.game.FastCarModel;
import com.zhouyiteng.gambling.model.game.FastCarResultModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 急速快车表
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/10.
 */
@Mapper
@Repository
public interface FastCarResultMapper {

    /**
     * 快车结果
     * @param model
     * @return
     */
    long addResult(@Param("model") FastCarResultModel model);

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
    List<FastCarResultModel> getPageList(@Param("pageStart") Long pageStart,
                                   @Param("pageEnd") Long pageEnd);
}
