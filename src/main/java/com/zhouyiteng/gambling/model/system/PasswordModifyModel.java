package com.zhouyiteng.gambling.model.system;

import lombok.Data;

/**
 * 修改密码模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Data
public class PasswordModifyModel extends UserModel{

    public String oldPassword;

    public String newPassword;

    public String newPasswordConfirm;

}