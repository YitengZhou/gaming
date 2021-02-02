package com.zhouyiteng.gambling.dao.system;

import com.zhouyiteng.gambling.model.system.PermModel;
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
@Repository
public interface RolePermMapper {

    /**
     * 删除角色的所有权限
     * @param roleEid
     */
    void deletePermissionsForRole(@Param("roleEid") String roleEid);

    /**
     * 用户插入所有权限
     * @param roleEid
     * @param permissions
     */
    void insertPermissionsForRole(@Param("roleEid") String roleEid, @Param("permissions") List<PermModel> permissions);

    /**
     * 根据角色名获得权限
     * @param eid
     * @return
     */
    List<PermModel> getPermissionsByRoleEid(@Param("eid") String eid);

}
