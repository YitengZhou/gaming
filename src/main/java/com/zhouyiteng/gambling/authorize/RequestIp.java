package com.zhouyiteng.gambling.authorize;

import java.lang.annotation.*;

/**
 * 自定义ip获取注解
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/2.
 */
@Documented
@Inherited
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestIp {
}
