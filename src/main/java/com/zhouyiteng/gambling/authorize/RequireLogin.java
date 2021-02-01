package com.zhouyiteng.gambling.authorize;

import java.lang.annotation.*;

/**
 * 标识需要登录的注解
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireLogin {
}