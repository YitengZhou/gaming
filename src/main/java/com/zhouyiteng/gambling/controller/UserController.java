package com.zhouyiteng.gambling.controller;

import com.zhouyiteng.gambling.authorize.RequirePermission;
import com.zhouyiteng.gambling.model.PageModel;
import com.zhouyiteng.gambling.model.auth.UserModel;
import com.zhouyiteng.gambling.model.auth.UserRoleModel;
import com.zhouyiteng.gambling.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Slf4j
@RestController
@RequestMapping("/service/user")
@RequirePermission("system:user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     *
     * @param model
     * @return
     */
    @PostMapping("add")
    @RequirePermission("system:user")
    public long add(@RequestBody UserModel model){
        return userService.add(model);
    }

    /**
     *
     * @param model
     * @return
     */
    @PostMapping("edit")
    @RequirePermission("system:user")
    public long edit(@RequestBody UserModel model){
        return userService.edit(model);
    }

    /**
     *
     * @param model
     * @return
     */
    @PostMapping("delete")
    @RequirePermission("system:user")
    public long delete(@RequestBody UserModel model){
        return userService.delete(model);
    }

    /**
     *
     * @param model
     * @return
     */
    @PostMapping("auth-role")
    @RequirePermission("system:user")
    public boolean authRole(@RequestBody UserRoleModel model){
        return userService.authRole(model);
    }

    /**
     *
     * @param model
     * @return
     */
    @PostMapping("reset-password")
    @RequirePermission("system:user")
    public long resetPassword(@RequestBody UserRoleModel model){
        return userService.resetPassword(model);
    }

    /**
     *
     * @param userId
     * @param userName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("page-list")
    @RequirePermission("system:user")
    public PageModel<UserRoleModel> getPageUserRole(@RequestParam(required = false) String userId,
                                                    @RequestParam(required = false) String userName,
                                                    @RequestParam(required = false) Long pageNo,
                                                    @RequestParam(required = false) Long pageSize){
        return userService.getPageUserRole(userId, userName, pageNo, pageSize);
    }

}
