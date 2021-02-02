package com.zhouyiteng.gambling.authorize;

import com.zhouyiteng.gambling.helper.RequestHelper;
import com.zhouyiteng.gambling.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限验证拦截器
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Slf4j
public class AuthorizeInterceptor implements HandlerInterceptor, HandlerMethodArgumentResolver {

    private static final String LOGIN_TOKEN_KEY="YT_GAMBLING_ADMIN_TOKEN";

    private static final String LOGIN_USER_ID_KEY="YT_GAMBLING_ADMIN_USER_ID";

    private RedisService redisService;

    public AuthorizeInterceptor(RedisService redisService){
        this.redisService = redisService;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if(methodParameter.hasParameterAnnotation(RequestIp.class) &&
                methodParameter.getParameterType().isAssignableFrom(String.class)){
            return true;
        }
        if(methodParameter.hasParameterAnnotation(LoginToken.class) &&
                methodParameter.getParameterType().isAssignableFrom(String.class)){
            return true;
        }
        if(methodParameter.hasParameterAnnotation(LoginUserId.class) &&
                methodParameter.getParameterType().isAssignableFrom(String.class)){
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
        if(methodParameter.hasParameterAnnotation(RequestIp.class)){
            return RequestHelper.getRequestIp(nativeWebRequest.getNativeRequest(HttpServletRequest.class));
        }
        if(methodParameter.hasParameterAnnotation(LoginToken.class)){
            return nativeWebRequest.getAttribute(LOGIN_TOKEN_KEY, RequestAttributes.SCOPE_REQUEST);
        }
        if(methodParameter.hasParameterAnnotation(LoginUserId.class)){
            return nativeWebRequest.getAttribute(LOGIN_USER_ID_KEY, RequestAttributes.SCOPE_REQUEST);
        }
        return null;
    }

    /**
     * 查询 controller 及 method 上定义的 RequireLogin 注解
     * @param handlerMethod
     * @return
     */
    private RequireLogin getRequireLoginList(HandlerMethod handlerMethod){
        RequireLogin methodRequireLogin = handlerMethod.getMethodAnnotation(RequireLogin.class);
        if(methodRequireLogin != null){
            return methodRequireLogin;
        }
        return AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), RequireLogin.class);
    }

    /**
     * 查询 controller 及 method 上定义的 RequirePermissions 注解
     * @param handlerMethod
     * @return
     */
    private RequirePermission getRequirePermissionsList(HandlerMethod handlerMethod){
        RequirePermission methodRequirePermission =handlerMethod.getMethodAnnotation(RequirePermission.class);
        if(methodRequirePermission != null){
            return methodRequirePermission;
        }
        return AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), RequirePermission.class);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            RequireLogin requireLogin = getRequireLoginList(handlerMethod);
            RequirePermission requirePermission = getRequirePermissionsList(handlerMethod);
            if(null!=requireLogin || null!=requirePermission){
                String token = AuthorizeUtil.getCookieValue(request, LOGIN_TOKEN_KEY);
                String userId = AuthorizeUtil.getCookieValue(request, LOGIN_USER_ID_KEY);
                if(null != requirePermission){
                    String permissionValue = requirePermission.value();
                    redisService.checkPermission(userId, token, permissionValue);
                }else{
                    redisService.checkLogin(userId, token);
                }
                request.setAttribute(LOGIN_TOKEN_KEY, token);
                request.setAttribute(LOGIN_USER_ID_KEY, userId);
            }
        }
        return true;
    }

}
