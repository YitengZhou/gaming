package com.zhouyiteng.gambling.dao.source;

import org.apache.ibatis.annotations.Param;

/**
 * mapper基类
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public interface BaseMapper<T> {

    long insert(@Param("model") T value);

    long update(@Param("model") T value);

    long delete(@Param("model") T value);

}
