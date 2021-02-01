package com.zhouyiteng.gambling.authorize;

import java.lang.annotation.*;

/**
 * 标识需要权限验证的注解
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequirePermission {
    /**
     * 要验证的权限列表
     * @return
     */
    String value();
}