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
import org.springframework.transaction.annotation.Transactional;

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
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 添加用户
     * @param model
     * @return
     */
    public long addUser(UserModel model){
        if (userMapper.exist(model.getUserId()) > 0) {
            throw new IllegalArgumentException("数据库中已存在该用户");
        }
        return userMapper.addUser(model);
    }

    /**
     * 修改用户
     * @param model
     * @return
     */
    public long updateUser(UserModel model){
        if (userMapper.exist(model.getUserId()) <= 0) {
            throw new IllegalArgumentException("数据库中没有该用户");
        }
        return userMapper.updateUser(model);
    }

    /**
     * 删除用户
     * @param model
     * @return
     */
    @Transactional
    public boolean deleteUser(UserModel model) {
        if (userMapper.exist(model.getUserId()) <= 0) {
            throw new IllegalArgumentException("数据库中没有该用户");
        }
        userRoleMapper.deleteRolesForUser(model.getUserId());
        userMapper.deleteUser(model);
        return true;
    }

    /**
     * 启用用户
     * @param model
     * @return
     */
    public long enableUser(UserModel model){
        if (userMapper.exist(model.getUserId()) <= 0) {
            throw new IllegalArgumentException("数据库中没有该用户");
        }
        return userMapper.enableUser(model);
    }

    /**
     * 禁用用户
     * @param model
     * @return
     */
    public long disableUser(UserModel model){
        if (userMapper.exist(model.getUserId()) <= 0) {
            throw new IllegalArgumentException("数据库中没有该用户");
        }
        return userMapper.disableUser(model);
    }

    /**
     * 重置密码
     * @param model
     * @return
     */
    public long resetPassword(UserModel model){
        if (userMapper.exist(model.getUserId()) <= 0) {
            throw new IllegalArgumentException("数据库中没有该用户");
        }
        return userMapper.resetPassword(model);
    }

    /**
     * 修改密码
     * @param model
     * @return
     */
    public long modifyPassword(PasswordModifyModel model){
        if(userMapper.checkPassword(model)<=0){
            throw new ErrorTipsException("原密码不正确");
        }
        return userMapper.modifyPassword(model);
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
        if(userMapper.checkPassword(model)<=0){
            throw new ErrorTipsException("用户名或密码错误");
        }else{
            Set<String> permissionSet = getPermSetByUserId(model.getUserId());
            UserModel UserModel = userMapper.getUserByUserId(model.getUserId());
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
                RolePermModel RolePermModel = roleService.getRolePermByRoleId(role.getRoleId());
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
        if (userMapper.exist(userId) <= 0) {
            throw new IllegalArgumentException("数据库中没有该用户");
        }
        return roleMapper.getRoleListByUserId(userId);
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
                if (roleMapper.getRoleByRoleId(role.getRoleId())==null){
                    throw new IllegalArgumentException("数据库中没有该角色");
                }
            }
        }
        String userId = UserRole.getUserId();
        if (userMapper.exist(userId) <= 0) {
            throw new IllegalArgumentException("数据库中没有该用户");
        } else{
            // 全删后逐一添加
            userRoleMapper.deleteRolesForUser(userId);
            if (CollectionUtils.isNotEmpty(UserRole.getRoleList())){
                userRoleMapper.insertRolesForUser(userId, UserRole.getRoleList());
            }
        }
        return true;
    }

    /**
     * 用户列表分页查询
     * @param userId
     * @param userName
     * @param pageSize
     * @param pageIndex
     * @return
     */
    public PageDataModel<UserRoleModel> getUserList(String userId, String userName, Long pageSize, Long pageIndex) {
        PageDataModel<UserRoleModel> ret = new PageDataModel<>(pageSize, pageIndex);
        ret.setTotalCount(userMapper.getTotalCount(userId, userName));
        ret.setDataList(userMapper.getPageList(userId, userName, ret.getPageStart(), ret.getPageEnd()));
        return ret;
    }
}
