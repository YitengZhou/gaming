package com.zhouyiteng.gambling.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 数据实体积累
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/2.
 */
@Data
public abstract class BaseEntity {

    /**
     * 唯一Id
     */
    protected String eid;

    /**
     * 入库时间
     */
    protected LocalDateTime eiTime;

    /**
     * 最后修改时间
     */
    protected LocalDateTime euTime;

}
