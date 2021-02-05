package com.zhouyiteng.gambling.model.web;

import lombok.Data;

/**
 * 用户信息模型
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Data
public class UserInfoModel {

    private String name;

    private String avatar;

    private String introduction;

    private Double money;

    private Double profit;

    private String[] permissions;

}
