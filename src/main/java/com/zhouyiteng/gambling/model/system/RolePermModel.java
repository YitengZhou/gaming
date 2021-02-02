package com.zhouyiteng.gambling.model.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 含权限的角色模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/2.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class RolePermModel extends RoleModel {

    List<PermModel> PermList;

}
