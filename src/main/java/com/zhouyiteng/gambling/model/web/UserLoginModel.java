package com.zhouyiteng.gambling.model.web;

import com.zhouyiteng.gambling.model.system.UserModel;
import lombok.Data;

/**
 * 用户登录模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Data
public class UserLoginModel {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 验证码标识
     */
    private String ticket;

    /**
     * 图形验证码
     */
    private String imageCode;

    /**
     * 登录有效期
     */
    private Integer expirySeconds;

    /**
     *
     * @return
     */
    public Integer getExpirySeconds() {
        if(null==expirySeconds || expirySeconds<=0){
            return 3600;
        }else if(expirySeconds > 86400){
            return 86400;
        }
        return expirySeconds;
    }

    /**
     * 把用户登录模型转换为数据库对应的模型
     * @return
     */
    public UserModel toUserModel(){
        UserModel ret = new UserModel();
        ret.setUserId(userId);
        ret.setPassword(password);
        return ret;
    }

}
