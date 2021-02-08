package com.zhouyiteng.gambling.controller.system;

import com.zhouyiteng.gambling.authorize.LoginToken;
import com.zhouyiteng.gambling.authorize.LoginUserId;
import com.zhouyiteng.gambling.authorize.RequireLogin;
import com.zhouyiteng.gambling.authorize.RequirePermission;
import com.zhouyiteng.gambling.controller.BaseController;
import com.zhouyiteng.gambling.model.system.PasswordModifyModel;
import com.zhouyiteng.gambling.model.system.RoleModel;
import com.zhouyiteng.gambling.model.system.UserModel;
import com.zhouyiteng.gambling.model.system.UserRoleModel;
import com.zhouyiteng.gambling.model.web.PageDataModel;
import com.zhouyiteng.gambling.model.web.UserInfoModel;
import com.zhouyiteng.gambling.model.web.UserLoginModel;
import com.zhouyiteng.gambling.service.system.RedisService;
import com.zhouyiteng.gambling.service.system.RoleService;
import com.zhouyiteng.gambling.service.system.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Slf4j
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisService redisService;

    /**
     * 退出登录
     * @param token
     * @return
     */
    @RequireLogin
    @PostMapping("logout")
    public boolean logout(@LoginToken String token){
        return redisService.logoutDeleteToken(token);
    }

    /**
     * 用户登录
     * @param model
     * @return
     */
    @PostMapping("login")
    public String login(@RequestBody UserLoginModel model){
        if(StringUtils.isEmpty(model.getUserId())){
            throw new IllegalArgumentException("请输入用户编号");
        }
        if(StringUtils.isEmpty(model.getPassword())){
            throw new IllegalArgumentException("请输入登录密码");
        }
        if(StringUtils.isEmpty(model.getTicket())){
            throw new IllegalArgumentException("请输入图形验证码");
        }
        if(StringUtils.isEmpty(model.getImageCode())){
            throw new IllegalArgumentException("请输入图形验证码");
        }
        return userService.doLogin(model.getTicket(), model.getImageCode(),
                model.toUserModel(), model.getExpirySeconds());
    }

    /**
     * 密码修改
     * @param userId
     * @param model
     * @return
     */
    @RequireLogin
    @PostMapping("modify-password")
    public long modifyPassword(@LoginUserId String userId,
                               @RequestBody PasswordModifyModel model){
        if(StringUtils.isEmpty(model.getPassword())){
            throw new IllegalArgumentException("请输入原密码");
        }
        if(StringUtils.isEmpty(model.getNewPassword())){
            throw new IllegalArgumentException("请输入新密码");
        }
        model.setUserId(userId);
        return userService.modifyPassword(model);
    }

    /**
     * 用户信息查询接口
     * @return
     */
    @RequireLogin
    @GetMapping("user-info")
    public UserInfoModel getUserInfo(@LoginToken String token, @LoginUserId String userId){
        UserInfoModel ret = new UserInfoModel();
        UserModel user = userService.getUserByUserId(userId);
        ret.setName(redisService.getUsername(token));
        ret.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        ret.setPermissions(redisService.getPermission(token));
        ret.setMoney(user.getMoney());
        ret.setProfit(user.getProfit());
        return ret;
    }

    /**
     * 添加用户
     * @param model
     * @return
     */
    @PostMapping("add-user")
    @RequirePermission("system:manage-user")
    public long addUser(@RequestBody UserModel model){
        if(StringUtils.isEmpty(model.getUserId())){
            throw new IllegalArgumentException("请输入用户编号");
        }
        if(StringUtils.isEmpty(model.getUserName())){
            throw new IllegalArgumentException("请输入用户名称");
        }
        if(StringUtils.isEmpty(model.getPassword())){
            throw new IllegalArgumentException("请输入初始密码");
        }
        return userService.addUser(model);
    }

    /**
     * 修改用户
     * @param model
     * @return
     */
    @PostMapping("update-user")
    @RequirePermission("system:manage-user")
    public long updateUser(@RequestBody UserModel model){
        if(StringUtils.isEmpty(model.getUserId())){
            throw new IllegalArgumentException("请选择要修改的用户");
        }
        if(StringUtils.isEmpty(model.getUserName())){
            throw new IllegalArgumentException("请输入用户名称");
        }
        return userService.updateUser(model);
    }

    /**
     * 删除用户
     * @param model
     * @return
     */
    @PostMapping("delete-user")
    @RequirePermission("system:manage-user")
    public boolean deleteUser(@RequestBody UserModel model){
        if(StringUtils.isEmpty(model.getUserId())){
            throw new IllegalArgumentException("用户编号不能为空");
        }
        return userService.deleteUser(model);
    }

    /**
     * 启用用户
     * @param model
     * @return
     */
    @PostMapping("enable-user")
    @RequirePermission("system:manage-user")
    public long enableUser(@RequestBody UserModel model){
        if(StringUtils.isEmpty(model.getUserId())){
            throw new IllegalArgumentException("请选择要修改的用户");
        }
        return userService.enableUser(model);
    }

    /**
     * 禁用用户
     * @param model
     * @return
     */
    @PostMapping("disable-user")
    @RequirePermission("system:manage-user")
    public long disableUser(@RequestBody UserModel model){
        if(StringUtils.isEmpty(model.getUserId())){
            throw new IllegalArgumentException("请选择要修改的用户");
        }
        return userService.disableUser(model);
    }

    /**
     * 重置密码
     * @param model
     * @return
     */
    @PostMapping("reset-password")
    @RequirePermission("system:manage-user")
    public long resetPassword(@RequestBody UserModel model){
        if(StringUtils.isEmpty(model.getUserId())){
            throw new IllegalArgumentException("请选择要修改的用户");
        }
        if(StringUtils.isEmpty(model.getUserName())){
            throw new IllegalArgumentException("请输入重置密码");
        }
        return userService.resetPassword(model);
    }

    /**
     * 获取全部角色列表
     * @return
     */
    @GetMapping("role-list")
    @RequirePermission("system:manage-user")
    public List<RoleModel> getTotalRoleList(){
        return roleService.getTotalRoleList();
    }

    /**
     * 根据用户获得用户角色
     * @param model
     * @return
     */
    @PostMapping("user-roles")
    @RequirePermission("system:manage-user")
    public List<RoleModel> getRoleListByUserId(@RequestBody UserModel model){
        return userService.getRoleListByUserId(model.getUserId());
    }

    /**
     * 设置用户角色
     * @param userWithRole
     * @return
     */
    @PostMapping("set-roles")
    @RequirePermission("system:manage-user")
    public boolean setRolesForUser(@RequestBody UserRoleModel userWithRole){
        return userService.setRolesForUser(userWithRole);
    }

    /**
     * 用户列表查询
     * @param userId
     * @param userName
     * @param pageSize
     * @param pageIndex
     * @return
     */
    @GetMapping("get-user-list")
    @RequirePermission("system:search-user")
    public PageDataModel<UserRoleModel> getUserList(@RequestParam(required = false) String userId,
                                                    @RequestParam(required = false) String userName,
                                                    @RequestParam(required = false) Long pageSize,
                                                    @RequestParam(required = false) Long pageIndex){
        return userService.getUserList(userId, userName, pageSize, pageIndex);
    }
}