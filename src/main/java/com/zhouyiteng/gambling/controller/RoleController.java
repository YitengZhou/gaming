package com.zhouyiteng.gambling.controller;

import com.zhouyiteng.gambling.authorize.RequireLogin;
import com.zhouyiteng.gambling.authorize.RequirePermission;
import com.zhouyiteng.gambling.model.PageModel;
import com.zhouyiteng.gambling.model.auth.RoleModel;
import com.zhouyiteng.gambling.model.auth.RolePermissionModel;
import com.zhouyiteng.gambling.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色控制
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Slf4j
@RestController
@RequestMapping("/service/role")
@RequirePermission("system:role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     *
     * @param model
     * @return
     */
    @PostMapping("add")
    @RequirePermission("system:role")
    public long add(@RequestBody RoleModel model){
        return roleService.add(model);
    }

    /**
     *
     * @param model
     * @return
     */
    @PostMapping("edit")
    @RequirePermission("system:role")
    public long edit(@RequestBody RoleModel model){
        return roleService.edit(model);
    }

    /**
     *
     * @param model
     * @return
     */
    @PostMapping("delete")
    @RequirePermission("system:role")
    public long delete(@RequestBody RoleModel model){
        return roleService.delete(model);
    }

    /**
     *
     * @return
     */
    @RequireLogin
    @GetMapping("all-role")
    public List<RoleModel> getAllRole(){
        return roleService.getAllRole();
    }

    /**
     *
     * @param model
     * @return
     */
    @PostMapping("auth-permission")
    @RequirePermission("system:role")
    public boolean authPermission(@RequestBody RolePermissionModel model){
        return roleService.authPermission(model);
    }

    /**
     *
     * @param roleId
     * @param roleName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("page-list")
    @RequirePermission("system:role")
    public PageModel<RolePermissionModel> getPageRolePermission(@RequestParam(required = false) String roleId,
                                                                @RequestParam(required = false) String roleName,
                                                                @RequestParam(required = false) Long pageNo,
                                                                @RequestParam(required = false) Long pageSize){
        return roleService.getPageRolePermission(roleId, roleName, pageNo, pageSize);
    }

}
