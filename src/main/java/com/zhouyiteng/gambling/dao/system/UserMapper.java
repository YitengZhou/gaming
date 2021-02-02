package com.zhouyiteng.gambling.dao.system;

import com.zhouyiteng.gambling.model.system.UserModel;
import com.zhouyiteng.gambling.model.system.UserRoleModel;
import com.zhouyiteng.gambling.model.system.PasswordModifyModel;
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
public interface UserMapper {

    /**
     * 是否存在对应Id的用户
     * @param userId
     * @return
     */
    long exist(@Param("userId") String userId);

    /**
     * 插入测试
     * @param model
     */
    void testInsert(@Param("model") UserModel model);

    /**
     * 添加用户
     * @param model
     * @return
     */
    long addUser(@Param("model") UserModel model);

    /**
     * 修改用户
     * @param model
     * @return
     */
    long updateUser(@Param("model") UserModel model);

    /**
     * 删除用户
     * @param model
     * @return
     */
    boolean deleteUser(@Param("model") UserModel model);

    /**
     * 启用用户
     * @param model
     * @return
     */
    long enableUser(@Param("model") UserModel model);

    /**
     * 禁用用户
     * @param model
     * @return
     */
    long disableUser(@Param("model") UserModel model);

    /**
     * 重置密码
     * @param model
     * @return
     */
    long resetPassword(@Param("model") UserModel model);

    /**
     * 修改密码
     * @param model
     * @return
     */
    long modifyPassword(@Param("model") PasswordModifyModel model);

    /**
     * 登录密码校验
     * @param model
     * @return
     */
    long checkPassword(@Param("model") UserModel model);

    /**
     * 满足条件数量
     * @param userId
     * @param username
     * @return
     */
    long getTotalCount(@Param("userId") String userId,
                  @Param("username") String username);

    /**
     * 根据用户ID获得用户
     * @param userId
     * @return
     */
    UserModel getUserByUserId(@Param("userId") String userId);

    /**
     * 满足条件记录
     * @param userId
     * @param username
     * @param pageStart
     * @param pageEnd
     * @return
     */
    List<UserRoleModel> getPageList(@Param("userId") String userId,
                                        @Param("username") String username,
                                        @Param("pageStart") Long pageStart,
                                        @Param("pageEnd") Long pageEnd);

    /**
     * 根据值查询建议的用户
     * @param value
     * @param count
     * @return
     */
    List<UserModel> getUserSuggest(@Param("value") String value, @Param("count") int count);
}
