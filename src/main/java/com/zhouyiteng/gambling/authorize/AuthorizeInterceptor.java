package com.zhouyiteng.gambling.authorize;

import com.zhouyiteng.gambling.config.ServiceConfig;
import com.zhouyiteng.gambling.model.auth.RolePermissionModel;
import com.zhouyiteng.gambling.service.RoleService;
import com.zhouyiteng.gambling.service.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限验证拦截器
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {

    private UserService userService;

    private RoleService roleService;

    public AuthorizeInterceptor(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    /**
     * 查询 controller 及 method 上定义的 RequireLogin 注解
     * @param handlerMethod
     * @return
     */
    private List<com.eastmoney.trade.dispatch.admin.service.authorize.RequireLogin> getRequireLoginList(HandlerMethod handlerMethod){
        List<com.eastmoney.trade.dispatch.admin.service.authorize.RequireLogin> requireLoginList = new ArrayList<>();
        com.eastmoney.trade.dispatch.admin.service.authorize.RequireLogin methodRequireLogin = handlerMethod.getMethodAnnotation(com.eastmoney.trade.dispatch.admin.service.authorize.RequireLogin.class);
        if(methodRequireLogin != null){
            requireLoginList.add(methodRequireLogin);
        }
        com.eastmoney.trade.dispatch.admin.service.authorize.RequireLogin controllerRequireLogin = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), com.eastmoney.trade.dispatch.admin.service.authorize.RequireLogin.class);
        if(controllerRequireLogin!=null){
            requireLoginList.add(controllerRequireLogin);
        }
        return requireLoginList;
    }

    /**
     * 查询 controller 及 method 上定义的 RequirePermissions 注解
     * @param handlerMethod
     * @return
     */
    private List<RequirePermission> getRequirePermissionsList(HandlerMethod handlerMethod){
        List<RequirePermission> requirePermissionList = new ArrayList<>();
        RequirePermission methodRequirePermission =handlerMethod.getMethodAnnotation(RequirePermission.class);
        if(methodRequirePermission != null){
            requirePermissionList.add(methodRequirePermission);
        }
        RequirePermission controllerRequirePermission = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), RequirePermission.class);
        if(controllerRequirePermission != null){
            requirePermissionList.add(controllerRequirePermission);
        }
        return requirePermissionList;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            List<com.eastmoney.trade.dispatch.admin.service.authorize.RequireLogin> requireLoginList = getRequireLoginList(handlerMethod);
            List<RequirePermission> requirePermissionList = getRequirePermissionsList(handlerMethod);

            if(!CollectionUtils.isEmpty(requireLoginList) || !CollectionUtils.isEmpty(requirePermissionList)){
                String user = com.eastmoney.trade.dispatch.admin.service.authorize.AuthorizeUtil.getCookieValue(request, ServiceConfig.LOGIN_USER_KEY);
                String token = com.eastmoney.trade.dispatch.admin.service.authorize.AuthorizeUtil.getCookieValue(request, ServiceConfig.LOGIN_TOKEN_KEY);
                if(userService.isLogin(user, token)){
                    if(!CollectionUtils.isEmpty(requirePermissionList)){
                        String permissionValue = requirePermissionList.get(0).value();
                        List<RolePermissionModel> rolePermissionList = roleService.getRolePermissionByUser(user);
                        if(CollectionUtils.isNotEmpty(rolePermissionList)){
                            for (RolePermissionModel item : rolePermissionList){
                                if(item.permissionList!=null && item.permissionList.contains(permissionValue)){
                                    return true;
                                }
                            }
                        }
                        throw new com.eastmoney.trade.dispatch.admin.service.authorize.ForbiddenException("没有权限");
                    }
                }else{
                    throw new com.eastmoney.trade.dispatch.admin.service.authorize.UnAuthException("未登录");
                }
            }
        }
        return true;
    }

}