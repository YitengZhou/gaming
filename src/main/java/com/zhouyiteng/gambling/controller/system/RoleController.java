package com.zhouyiteng.gambling.controller.system;

import com.zhouyiteng.gambling.authorize.RequirePermission;
import com.zhouyiteng.gambling.controller.BaseController;
import com.zhouyiteng.gambling.model.system.RoleModel;
import com.zhouyiteng.gambling.model.system.RolePermModel;
import com.zhouyiteng.gambling.model.web.PageDataModel;
import com.zhouyiteng.gambling.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Slf4j
@RestController
@RequestMapping("/system/roles")
public class RoleController extends BaseController {
    @Autowired
    RoleService roleService;

    /**
     * 增加角色
     * @param role
     * @return
     */
    @PostMapping("/add")
    @RequirePermission("system:manage-role")
    public boolean addRole(@RequestBody RoleModel role) {
        return roleService.addRole(role);
    }

    /**
     * 更新角色
     * @param authRoleModel
     * @return
     */
    @PostMapping("/update")
    @RequirePermission("system:manage-role")
    public boolean updateRole(@RequestBody RoleModel authRoleModel){
        return roleService.updateRole(authRoleModel);
    }

    /**
     * 删除角色
     * @param authRoleModel
     * @return
     */
    @PostMapping("/delete")
    @RequirePermission("system:manage-role")
    public boolean deleteRole(@RequestBody RoleModel authRoleModel){
        return roleService.deleteRole(authRoleModel);
    }

    /**
     * 设置权限
     * @param authRoleWithPerm
     * @return
     */
    @PostMapping("/set-permissions")
    @RequirePermission("system:manage-role")
    public boolean setPermission(@RequestBody RolePermModel authRoleWithPerm){
        return roleService.setPermission(authRoleWithPerm);
    }

    /**
     * 查询角色含权限
     * @param name
     * @param description
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("get-role-list")
    @RequirePermission("system:search-role")
    public PageDataModel<RolePermModel> getRoleList(@RequestParam(required = false) String name, @RequestParam(required = false) String description,
                                                        @RequestParam(required = false) String service,
                                                        @RequestParam(required = false) Long pageIndex, @RequestParam(required = false) Long pageSize) {
        return roleService.getRoleList(name, description,service, pageIndex, pageSize);
    }

}
