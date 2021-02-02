package com.zhouyiteng.gambling.controller;

import com.zhouyiteng.gambling.authorize.AuthorizeUtil;
import com.zhouyiteng.gambling.authorize.RequireLogin;
import com.zhouyiteng.gambling.config.ServiceConfig;
import com.zhouyiteng.gambling.model.auth.ModifyPasswordModel;
import com.zhouyiteng.gambling.model.auth.RolePermissionModel;
import com.zhouyiteng.gambling.model.auth.UserModel;
import com.zhouyiteng.gambling.service.RoleService;
import com.zhouyiteng.gambling.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 账户控制
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Slf4j
@RestController
@RequestMapping("/system/account")
public class AccountController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     *
     * @param response
     */
    @PostMapping("logout")
    public boolean logout(HttpServletResponse response){
        int expirySeconds = 10800;
        AuthorizeUtil.setCookieValue(response, ServiceConfig.LOGIN_USER_KEY, "", expirySeconds);
        AuthorizeUtil.setCookieValue(response, ServiceConfig.LOGIN_TOKEN_KEY, "", expirySeconds);
        return true;
    }

    /**
     *
     * @param response
     * @param model
     */
    @PostMapping("login")
    public boolean login(HttpServletResponse response, @RequestBody UserModel model){
        int expirySeconds = 10800;
        String token = userService.login(model);
        AuthorizeUtil.setCookieValue(response, ServiceConfig.LOGIN_TOKEN_KEY, token, expirySeconds);
        AuthorizeUtil.setCookieValue(response, ServiceConfig.LOGIN_USER_KEY, model.userId, expirySeconds);
        return true;
    }

    /**
     *
     * @param request
     * @return
     */
    @RequireLogin
    @PostMapping("login-user")
    public UserModel loginUser(HttpServletRequest request){
        String userId = AuthorizeUtil.getCookieValue(request, ServiceConfig.LOGIN_USER_KEY);
        return userService.getUserById(userId);
    }

    /**
     *
     * @param request
     * @return
     */
    @RequireLogin
    @PostMapping("permission-list")
    public Set<String> permissionList(HttpServletRequest request){
        Set<String> permissionSet = new HashSet<>();
        String userId = AuthorizeUtil.getCookieValue(request, ServiceConfig.LOGIN_USER_KEY);
        List<RolePermissionModel> roleRolePermissionList = roleService.getRolePermissionByUser(userId);
        if(CollectionUtils.isNotEmpty(roleRolePermissionList)){
            roleRolePermissionList.forEach(x->{
                if(CollectionUtils.isNotEmpty(x.permissionList)){
                    x.permissionList.forEach(y->permissionSet.add(y));
                }
            });
        }
        return permissionSet;
    }

    /**
     *
     * @return
     */
    @RequireLogin
    @PostMapping("modify-password")
    public long modifyPassword(HttpServletRequest request, @RequestBody ModifyPasswordModel model){
        String userId = AuthorizeUtil.getCookieValue(request, ServiceConfig.LOGIN_USER_KEY);
        return userService.modifyPassword(userId, model);
    }

}
