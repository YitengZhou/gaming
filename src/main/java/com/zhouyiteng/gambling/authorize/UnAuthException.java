package com.zhouyiteng.gambling.authorize;

public class UnAuthException extends RuntimeException {

    public UnAuthException(String message){
        super(message);
    }

    public UnAuthException(String message, Throwable cause){
        super(message, cause);
    }

}
