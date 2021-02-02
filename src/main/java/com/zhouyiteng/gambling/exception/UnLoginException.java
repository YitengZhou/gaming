package com.zhouyiteng.gambling.exception;

/**
 * 用于表示未登录的异常
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public class UnLoginException extends RuntimeException {

    public UnLoginException(){
        super("登录超时");
    }

    public UnLoginException(String message){
        super(message);
    }

    public UnLoginException(String message, Throwable cause){
        super(message, cause);
    }

}