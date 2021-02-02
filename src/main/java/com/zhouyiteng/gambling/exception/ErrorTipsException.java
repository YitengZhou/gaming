package com.zhouyiteng.gambling.exception;

/**
 * 用于仅抛出错误提示信息的异常
 * 该种异常用于明确抛出自定义错误信息，通常无需记录错误日志
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public class ErrorTipsException extends RuntimeException {

    public ErrorTipsException(String message){
        super(message);
    }

    public ErrorTipsException(String message, Throwable cause){
        super(message, cause);
    }

}
