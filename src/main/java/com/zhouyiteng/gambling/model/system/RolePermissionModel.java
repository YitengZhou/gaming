package com.zhouyiteng.gambling.model.system;

import lombok.Data;

import java.util.List;

/**
 * 角色权限模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Data
public class RolePermissionModel extends RoleModel {

    public List<String> permissionList;

}
