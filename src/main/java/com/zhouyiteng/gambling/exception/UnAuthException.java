package com.zhouyiteng.gambling.exception;

/**
 * 用于表示未授权的异常
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public class UnAuthException extends RuntimeException {

    public UnAuthException(){
        super("没有权限");
    }

    public UnAuthException(String message){
        super(message);
    }

    public UnAuthException(String message, Throwable cause){
        super(message, cause);
    }

}