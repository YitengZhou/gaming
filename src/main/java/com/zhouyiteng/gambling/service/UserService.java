package com.zhouyiteng.gambling.service;

import com.zhouyiteng.gambling.exception.ErrorTipsException;
import com.zhouyiteng.gambling.dao.system.RoleMapper;
import com.zhouyiteng.gambling.dao.system.UserMapper;
import com.zhouyiteng.gambling.dao.system.UserRoleMapper;
import com.zhouyiteng.gambling.model.system.*;
import com.zhouyiteng.gambling.model.web.PageDataModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 账户相关操方法
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/2.
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private InfoService infoService;

    @Autowired
    private UserMapper UserMapper;

    @Autowired
    private RoleMapper RoleMapper;

    @Autowired
    private UserRoleMapper UserRoleMapper;

    /**
     * 添加用户
     * @param model
     * @return
     */
    public long addUser(UserModel model){
        return UserMapper.addUser(model);
    }

    /**
     * 修改用户
     * @param model
     * @return
     */
    public long updateUser(UserModel model){
        return UserMapper.updateUser(model);
    }

    /**
     * 删除用户
     * @param model
     * @return
     */
    public boolean deleteUser(UserModel model) {
        UserMapper.deleteUser(model);
        UserRoleMapper.deleteRolesForUser(model.getUserId());
        return true;
    }

    /**
     * 启用用户
     * @param model
     * @return
     */
    public long enableUser(UserModel model){
        return UserMapper.enableUser(model);
    }

    /**
     * 禁用用户
     * @param model
     * @return
     */
    public long disableUser(UserModel model){
        return UserMapper.disableUser(model);
    }

    /**
     * 重置密码
     * @param model
     * @return
     */
    public long resetPassword(UserModel model){
        return UserMapper.resetPassword(model);
    }

    /**
     * 修改密码
     * @param model
     * @return
     */
    public long modifyPassword(PasswordModifyModel model){
        if(UserMapper.checkPassword(model)<=0){
            throw new ErrorTipsException("原密码不正确");
        }
        return UserMapper.modifyPassword(model);
    }

    /**
     * 登录操作
     * @param ticket
     * @param imageCode
     * @param model
     * @param expirySeconds
     * @return
     */
    public String doLogin(String ticket, String imageCode,
                          UserModel model, int expirySeconds){
        if(!infoService.checkImageCode(ticket, imageCode)){
            throw new ErrorTipsException("验证码错误");
        }
        if(UserMapper.checkPassword(model)<=0){
            throw new ErrorTipsException("用户名或密码错误");
        }else{
            Set<String> permissionSet = getPermSetByUserId(model.getUserId());
            UserModel UserModel = UserMapper.getUserByUserId(model.getUserId());
            return redisService.savePermission(model.getUserId(), UserModel.getUserName(), permissionSet, expirySeconds);
        }
    }

    /**
     * 根据用户ID获得该用户所有角色权限
     * @param userId
     * @return
     */
    public Set<String> getPermSetByUserId(String userId){
        Set<String> permissionSet = new HashSet<>();
        List<RoleModel> RoleModelList = getRoleListByUserId(userId);
        if (CollectionUtils.isNotEmpty(RoleModelList)){
            for (RoleModel role: RoleModelList){
                RolePermModel RolePermModel = roleService.getRolePermByRoleEid(role.getEid());
                List<PermModel> PermModelList = RolePermModel.getPermList();
                if (CollectionUtils.isNotEmpty(PermModelList)){
                    for (PermModel permission: PermModelList){
                        permissionSet.add(permission.getPermissionName());
                    }
                }
            }
        }
        return permissionSet;
    }

    /**
     * 根据用户名获得角色
     * @param userId
     * @return
     */
    public List<RoleModel> getRoleListByUserId(String userId) {
        long exist = UserMapper.exist(userId);
        if (exist<=0) throw new IllegalArgumentException("数据库中没有该用户");
        return RoleMapper.getRoleListByUserId(userId);
    }

    /**
     * 设置用户角色
     * @param UserRole
     * @return
     */
    public boolean setRolesForUser(UserRoleModel UserRole){
        if (UserRole == null) {
            throw new IllegalArgumentException("用户对象不能为空");
        }
        if (StringUtils.isEmpty(UserRole.getUserId())) {
            throw new IllegalArgumentException("用户ID不能为空");
        }
        if (CollectionUtils.isNotEmpty(UserRole.getRoleList())){
            for (RoleModel role:UserRole.getRoleList()){
                if (RoleMapper.getRoleByRoleEid(role.getEid())==null){
                    throw new IllegalArgumentException("数据库中没有该角色");
                }
            }
        }
        String userId = UserRole.getUserId();
        if (UserMapper.exist(userId) <= 0) {
            throw new IllegalArgumentException("数据库中没有该用户");
        } else{
            // 全删后逐一添加,本处的UserRole中role只有eid属性
            UserRoleMapper.deleteRolesForUser(userId);
            UserRoleMapper.insertRolesForUser(userId,UserRole.getRoleList());
        }
        return true;
    }

    /**
     * 用户列表分页查询
     * @param userId
     * @param username
     * @param pageSize
     * @param pageIndex
     * @return
     */
    public PageDataModel<UserRoleModel> getUserList(String userId, String username, Long pageSize, Long pageIndex){
        PageDataModel<UserRoleModel> ret = new PageDataModel<>(pageSize, pageIndex);
        ret.setTotalCount(UserMapper.getTotalCount(userId, username));
        ret.setDataList(UserMapper.getPageList(userId, username, ret.getPageStart(), ret.getPageEnd()));
        return ret;
    }

    /**
     * 用户搜索建议
     * @param value
     * @return
     */
    public List<UserModel> getUserSuggest(String value){
        return UserMapper.getUserSuggest(value, 15);
    }

}
