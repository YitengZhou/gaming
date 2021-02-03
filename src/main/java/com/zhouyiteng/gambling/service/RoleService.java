package com.zhouyiteng.gambling.service;

import com.zhouyiteng.gambling.dao.system.RoleMapper;
import com.zhouyiteng.gambling.dao.system.RolePermMapper;
import com.zhouyiteng.gambling.model.system.*;
import com.zhouyiteng.gambling.model.web.PageDataModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户相关操方法
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/2.
 */
@Slf4j
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermMapper rolePermMapper;

    /**
     * 检查角色对象是否符合要求
     * @param item
     */
    private void checkRoleInstance(RoleModel item){
        if (item==null){
            throw new IllegalArgumentException("角色对象不能为空");
        }
        if (StringUtils.isEmpty(item.getRoleName())){
            throw new IllegalArgumentException("角色姓名不能为空");
        }
//        if (StringUtils.isEmpty(item.getDescription())){
//            throw new IllegalArgumentException("角色描述不能为空");
//        }
//        if (StringUtils.isEmpty(item.getService())){
//            throw new IllegalArgumentException("角色所属服务不能为空");
//        }
    }

    /**
     * 获取全部角色列表
     * @return
     */
    public List<RoleModel> getTotalRoleList() {
        return roleMapper.getTotalRoleList();
    }

    /**
     * 根据角色名获得角色
     * @param roleEid
     * @return
     */
    public RoleModel getRoleByRoleId(String roleEid) {
        return roleMapper.getRoleByRoleId(roleEid);
    }

    /**
     * 根据服务和角色名获得角色
     * @param roleName
     * @param service
     * @return
     */
    public RoleModel getRoleByRoleNameAndService(String roleName, String service) {return roleMapper.getRoleByRoleNameAndService(roleName,service);}

    /**
     * 根据角色名获得角色权限
     * @param roleId
     * @return
     */
    public RolePermModel getRolePermByRoleId(String roleId) {
        RolePermModel roleWithPerm = new RolePermModel();
        RoleModel role = roleMapper.getRoleByRoleId(roleId);
        if (role == null) {
            throw new IllegalArgumentException("数据库中没有该角色名");
        }
        roleWithPerm.setRoleName(role.getRoleName());
//        roleWithPerm.setService(role.getService());
//        roleWithPerm.setDescription(role.getDescription());
        roleWithPerm.setPermList(rolePermMapper.getPermissionsByRoleId(role.getRoleId()));
        return roleWithPerm;
    }

    /**
     * 添加角色
     * @param RoleModel
     * @return
     */
    public boolean addRole(RoleModel RoleModel) {
        // 查看Role对象传入是否正确
        checkRoleInstance(RoleModel);
        // 查看表中是否已经存在服务，由于新建角色eid为主键，本处用服务和角色名检查数据库中是否已经存在该角色
        RoleModel exist = roleMapper.getRoleByRoleNameAndService(RoleModel.getRoleName(), RoleModel.getService());
        if (exist!=null) {
            throw new IllegalArgumentException("不能添加相同的角色名");
        } else {
            roleMapper.addRole(RoleModel);
        }
        return true;
    }

    /**
     * 更新角色
     * @param RoleModel
     * @return
     */
    public boolean updateRole(RoleModel RoleModel) {
        checkRoleInstance(RoleModel);
        RoleModel exist = roleMapper.getRoleByRoleId(RoleModel.getRoleId());
        if (exist==null) {
            throw new IllegalArgumentException("数据库中没有该角色名");
        } else {
            roleMapper.updateRole(RoleModel);
        }
        return true;
    }

    /**
     * 删除角色
     * @param RoleModel
     * @return
     */
    public boolean deleteRole(RoleModel RoleModel) {
        if (RoleModel.getEid()==null) {
            throw new IllegalArgumentException("角色eid不能为空");
        }
        RoleModel exist = roleMapper.getRoleByRoleId(RoleModel.getRoleId());
        if (exist==null) {
            throw new IllegalArgumentException("数据库中没有该角色id");
        } else {
            // 删除角色同时删除权限
            roleMapper.deleteRoleByRoleEid(RoleModel.getEid());
            rolePermMapper.deletePermissionsForRole(RoleModel.getEid());
        }
        return true;
    }

    /**
     * 设置权限
     * @param roleWithPerm
     * @return
     */
    public boolean setPermission(RolePermModel roleWithPerm){
        if (roleWithPerm == null) {
            throw new IllegalArgumentException("角色对象不能为空");
        }
        if (CollectionUtils.isNotEmpty(roleWithPerm.getPermList())){
            for(PermModel perm: roleWithPerm.getPermList()){
                if (StringUtils.isEmpty(perm.getPermissionName())){
                    throw new IllegalArgumentException("权限名不能为空");
                }
            }
        }
        RoleModel exist = roleMapper.getRoleByRoleId(roleWithPerm.getRoleId());
        if (exist==null) {
            throw new IllegalArgumentException("数据库中没有该角色EID");
        } else {
            // 全删，逐一添加,需要改
            rolePermMapper.deletePermissionsForRole(roleWithPerm.getEid());
            rolePermMapper.insertPermissionsForRole(roleWithPerm.getEid(),roleWithPerm.getPermList());
        }
        return true;
    }

    /**
     * 查询角色含权限
     * @param name
     * @param description
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageDataModel<RolePermModel> getRoleList(String name, String description,String service, Long pageIndex, Long pageSize) {
        PageDataModel<RolePermModel> ret = new PageDataModel<>(pageSize, pageIndex);
        ret.setTotalCount(roleMapper.getTotalCount(name,description));
        ret.setDataList(roleMapper.getPageList(name, description, service, ret.getPageStart(), ret.getPageEnd()));
        return ret;
    }
}
