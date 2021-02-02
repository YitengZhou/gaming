package com.zhouyiteng.gambling.dao.system;

import com.zhouyiteng.gambling.model.system.RoleModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户角色表
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/2.
 */
@Mapper
@Repository
public interface UserRoleMapper {

    /**
     * 删除用户的角色
     * @param userId
     */
    void deleteRolesForUser(@Param("userId") String userId);

    /**
     * 设置用户的角色
     * @param userId
     * @param roles
     */
    void insertRolesForUser(@Param("userId") String userId,@Param("roles") List<RoleModel> roles);
}
