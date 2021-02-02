package com.zhouyiteng.gambling.model.system;

import com.zhouyiteng.gambling.authorize.AuthorizeUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

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

    public String getNewPassword(){
        if(StringUtils.isNotEmpty(newPassword)){
            return AuthorizeUtil.passwordSalt(newPassword, getUserId());
        }
        return newPassword;
    }

}
