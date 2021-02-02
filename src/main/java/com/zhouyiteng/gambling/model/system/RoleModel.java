package com.zhouyiteng.gambling.model.system;

import com.zhouyiteng.gambling.model.BaseEntity;
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
public class RoleModel extends BaseEntity {

    /**
     * 角色id
     */
    public String roleId;

    /**
     * 角色名称
     */
    public String roleName;

    /**
     * 所属服务
     */
    private String service;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 备注信息
     */
    public String remark;

}
