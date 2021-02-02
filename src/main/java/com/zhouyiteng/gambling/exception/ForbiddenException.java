package com.zhouyiteng.gambling.exception;

/**
 * 权限验证拦截器
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public class ForbiddenException extends RuntimeException {

    public ForbiddenException(String message){
        super(message);
    }

    public ForbiddenException(String message, Throwable cause){
        super(message, cause);
    }

}
