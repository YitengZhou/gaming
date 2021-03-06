package com.zhouyiteng.gambling.dao.system;

import com.zhouyiteng.gambling.model.system.PermModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色权限表
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/2.
 */
@Mapper
@Repository
public interface RolePermMapper {

    /**
     * 删除角色的所有权限
     * @param roleId
     */
    void deletePermissionsForRole(@Param("roleId") String roleId);

    /**
     * 用户插入所有权限
     * @param roleId
     * @param permissions
     */
    void insertPermissionsForRole(@Param("roleId") String roleId, @Param("permissions") List<PermModel> permissions);

    /**
     * 根据角色名获得权限
     * @param roleId
     * @return
     */
    List<PermModel> getPermissionsByRoleId(@Param("roleId") String roleId);

}
