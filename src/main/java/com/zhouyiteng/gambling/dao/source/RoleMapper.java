package com.zhouyiteng.gambling.dao.source;

import com.zhouyiteng.gambling.model.auth.RoleModel;
import com.zhouyiteng.gambling.model.auth.RolePermissionModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 角色
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<RoleModel> {

    /**
     *
     * @param roleId
     * @return
     */
    long exist(@Param("roleId") String roleId);

    /**
     *
     * @return
     */
    List<RoleModel> queryAllRole();

    /**
     *
     * @param roleId
     * @return
     */
    long checkUserByRole(@Param("roleId") String roleId);

    /**
     *
     * @param roleId
     * @return
     */
    long deleteRolePermissionByRole(@Param("roleId") String roleId);

    /**
     *
     * @param roleId
     * @param permissionValue
     * @return
     */
    long addRolePermission(@Param("roleId") String roleId,
                           @Param("permissionValue") String permissionValue);

    /**
     *
     * @param userId
     * @return
     */
    List<RolePermissionModel> queryRolePermissionByUser(@Param("userId") String userId);

    /**
     *
     * @param roleId
     * @param roleName
     * @return
     */
    long queryRoleCount(@Param("roleId") String roleId,
                        @Param("roleName") String roleName);

    /**
     *
     * @param roleId
     * @param roleName
     * @param pageStart
     * @param pageEnd
     * @return
     */
    List<RolePermissionModel> queryRolePermissionList(@Param("roleId") String roleId,
                                                      @Param("roleName") String roleName,
                                                      @Param("pageStart") long pageStart,
                                                      @Param("pageEnd") long pageEnd);

}