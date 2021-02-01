package com.zhouyiteng.gambling.dao;

import com.zhouyiteng.gambling.model.auth.UserModel;
import com.zhouyiteng.gambling.model.auth.UserRoleModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 用户
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserModel> {

    /**
     *
     * @param userId
     * @return
     */
    long exist(@Param("userId") String userId);

    /**
     *
     * @param userId
     * @return
     */
    int enable(@Param("userId") String userId);

    /**
     *
     * @param userId
     * @return
     */
    int disable(@Param("userId") String userId);

    /**
     *
     * @param userId
     * @return
     */
    long deleteUserRoleByUser(@Param("userId") String userId);

    /**
     *
     * @param userId
     * @return
     */
    long deleteUserLoginByUser(@Param("userId") String userId);

    /**
     *
     * @param userId
     * @param roleId
     * @return
     */
    long addUserRole(@Param("userId") String userId,
                     @Param("roleId") String roleId);

    /**
     *
     * @param userId
     * @param token
     * @return
     */
    long checkLogin(@Param("userId") String userId,
                    @Param("token") String token);

    /**
     *
     * @param userId
     * @param password
     * @return
     */
    long checkPassword(@Param("userId") String userId,
                       @Param("password") String password);

    /**
     *
     * @param userId
     * @param token
     */
    void addLoginToken(@Param("userId") String userId,
                       @Param("token") String token);

    /**
     *
     * @param userId
     * @return
     */
    UserModel queryUserById(String userId);

    /**
     *
     * @param userId
     * @param password
     */
    long resetPassword(@Param("userId") String userId,
                       @Param("password") String password);

    /**
     *
     * @param userId
     * @param userName
     * @return
     */
    long queryUserCount(@Param("userId") String userId,
                        @Param("userName") String userName);

    /**
     *
     * @param userId
     * @param userName
     * @param pageStart
     * @param pageEnd
     * @return
     */
    List<UserRoleModel> queryUserRoleList(@Param("userId") String userId,
                                          @Param("userName") String userName,
                                          @Param("pageStart") long pageStart,
                                          @Param("pageEnd") long pageEnd);

}
