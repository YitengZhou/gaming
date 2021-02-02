package com.zhouyiteng.gambling.model.system;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 角色模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Data
public class RoleModel {

    /**
     * 角色id
     */
    public String roleId;

    /**
     * 角色名称
     */
    public String roleName;

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
