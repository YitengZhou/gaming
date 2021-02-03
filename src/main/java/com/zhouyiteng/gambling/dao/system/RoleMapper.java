package com.zhouyiteng.gambling.dao.system;

import com.zhouyiteng.gambling.model.system.RoleModel;
import com.zhouyiteng.gambling.model.system.RolePermModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 授权用户表
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/2.
 */
@Mapper
@Repository
public interface RoleMapper {

    /**
     * 获得所有角色
     * @return
     */
    List<RoleModel> getTotalRoleList();

    /**
     * 根据角色名获得角色
     * @param roleId
     * @return
     */
    RoleModel getRoleByRoleId(@Param("roleId") String roleId);

    /**
     * 根据服务和角色名获得角色
     * @param roleName
     * @param service
     * @return
     */
    RoleModel getRoleByRoleNameAndService(@Param("roleName") String roleName, @Param("service") String service);

    /**
     * 添加角色
     * @param role
     */
    void addRole(@Param("role") RoleModel role);

    /**
     * 更新角色
     * @param role
     */
    void updateRole(@Param("role") RoleModel role);

    /**
     * 删除角色
     * @param eid
     */
    void deleteRoleByRoleEid(@Param("eid") String eid);

    /**
     * 根据用户名获得角色
     * @param userId
     * @return
     */
    List<RoleModel> getRoleListByUserId(@Param("userId") String userId);

    /**
     * 满足条件角色数量
     * @param name
     * @param description
     * @return
     */
    long getTotalCount(@Param("name") String name, @Param("description") String description);

    /**
     * 获得查询角色
     * @param description
     * @param pageStart
     * @param pageEnd
     * @return
     */
    List<RolePermModel> getPageList(@Param("name") String name, @Param("description") String description,
                                        @Param("service") String service,
                                        @Param("pageStart") Long pageStart, @Param("pageEnd") Long pageEnd);
}
