package com.zhouyiteng.gambling.dao.game;

import com.zhouyiteng.gambling.model.game.LongDragonModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
    long addResult(@Param("model") LongDragonModel model);
}
