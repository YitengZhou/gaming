package com.zhouyiteng.gambling.model.auth;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Data
public class UserModel {

    /**
     * 帐号id
     */
    public String userId;

    /**
     * 帐号名称
     */
    public String userName;

    /**
     * 帐号密码
     */
    public String password;

    /**
     * 帐号状态
     */
    public Boolean status;

    /**
     * 创建时间
     */
    public LocalDateTime createTime;

    /**
     * 更新时间
     */
    public LocalDateTime updateTime;

    /**
     * 备注信息
     */
    public String remark;

}
