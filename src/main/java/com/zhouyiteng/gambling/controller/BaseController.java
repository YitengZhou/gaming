package com.zhouyiteng.gambling.controller;

import com.zhouyiteng.gambling.authorize.ForbiddenException;
import com.zhouyiteng.gambling.authorize.UnAuthException;
import com.zhouyiteng.gambling.exception.ShowErrorTipsException;
import com.zhouyiteng.gambling.model.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 账户控制
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Slf4j
public class BaseController {

    /**
     * 异常捕捉
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler
    protected ResponseEntity<ResponseModel> exceptionHandler(Throwable ex, HttpServletRequest request) {
        try{
            if(!(ex instanceof IllegalArgumentException) && !(ex instanceof ShowErrorTipsException)){
                log.error(ex.getMessage(), ex);
            }
        }catch (Throwable e1){ }

        if(ex instanceof UnAuthException){
            return new ResponseEntity<>(ResponseModel.getFailedEntity(ex.getMessage()), HttpStatus.UNAUTHORIZED);
        }else if(ex instanceof ForbiddenException){
            return new ResponseEntity<>(ResponseModel.getFailedEntity(ex.getMessage()), HttpStatus.FORBIDDEN);
        }else if(ex instanceof IllegalArgumentException){
            return new ResponseEntity<>(ResponseModel.getFailedEntity(ex.getMessage()), HttpStatus.NOT_ACCEPTABLE);
        }else{
            return new ResponseEntity<>(ResponseModel.getFailedEntity(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
