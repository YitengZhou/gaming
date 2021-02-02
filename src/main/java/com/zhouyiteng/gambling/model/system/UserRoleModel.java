package com.zhouyiteng.gambling.model.system;

import lombok.Data;

import java.util.List;

/**
 * 用户角色模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Data
public class UserRoleModel extends UserModel {

    public List<RoleModel> roleList;

}
