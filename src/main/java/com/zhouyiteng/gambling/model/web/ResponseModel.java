package com.zhouyiteng.gambling.model.web;

public class ResponseModel<T> {

    public int status = 0;

    public String message = "";

    public T data;

    public ResponseModel(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseModel<T> getSuccessEntity(T data){
        return new ResponseModel<>(0, "", data);
    }

    public static <T> ResponseModel<T> getFailedEntity(String message) {
        return new ResponseModel<>(-1, message, null);
    }

}