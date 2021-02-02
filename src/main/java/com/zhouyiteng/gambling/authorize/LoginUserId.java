package com.zhouyiteng.gambling.authorize;

import java.lang.annotation.*;

/**
 * 自定义userId注解
 *
 * 此注解在验证通过后，获取当前用户userId
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/2.
 */
@Documented
@Inherited
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUserId {
}
