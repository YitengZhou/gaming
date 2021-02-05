package com.zhouyiteng.gambling.model.system;

import com.zhouyiteng.gambling.authorize.AuthorizeUtil;
import com.zhouyiteng.gambling.model.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 用户模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Data
public class UserModel extends BaseEntity {

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
    public String status;

    /**
     * 连续登录失败次数
     */
    private Integer loginFail;

    /**
     * 备注信息
     */
    public String remark;

    /**
     * 金额
     */
    private String money;

    /**
     * 返回加盐后的密码
     * @return
     */
    public String getPassword(){
        if(StringUtils.isNotEmpty(password)){
            return AuthorizeUtil.passwordSalt(password, userId);
        }
        return password;
    }

}
