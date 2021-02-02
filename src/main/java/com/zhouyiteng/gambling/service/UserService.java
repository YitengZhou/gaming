package com.zhouyiteng.gambling.service;

import com.zhouyiteng.gambling.authorize.AuthorizeUtil;
import com.zhouyiteng.gambling.dao.UserMapper;
import com.zhouyiteng.gambling.model.auth.ModifyPasswordModel;
import com.zhouyiteng.gambling.model.auth.UserModel;
import com.zhouyiteng.gambling.model.auth.UserRoleModel;
import com.zhouyiteng.gambling.exception.ShowErrorTipsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.UUID;

/**
 * Service基类
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Slf4j
@Service
public class UserService extends BaseService<UserModel, UserMapper> {

    @Autowired
    public UserService(UserMapper mapper) {
        super(mapper);
    }

    /**
     *
     * @param model
     * @return
     */
    public boolean exist(UserModel model){
        if(StringUtils.isEmpty(model.userId)){
            throw new IllegalArgumentException("帐号ID不能为空");
        }
        return mapperInstance.exist(model.userId) > 0;
    }

    /**
     *
     * @param userId
     * @param token
     * @return
     */
    public boolean isLogin(String userId, String token){
        if(StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(token)){
            return mapperInstance.checkLogin(userId, token)>0;
        }
        return false;
    }

    /**
     *
     * @param model
     */
    private void checkProperty(UserModel model, boolean isAdd){
        if(StringUtils.isEmpty(model.userId)){
            throw new IllegalArgumentException("帐号ID不能为空");
        }
        if(StringUtils.isEmpty(model.userName)){
            throw new IllegalArgumentException("帐号名称不能为空");
        }
        if(isAdd && StringUtils.isEmpty(model.password)){
            throw new IllegalArgumentException("帐号密码不能为空");
        }
    }

    /**
     *
     * @param model
     * @return
     */
    public long add(UserModel model){
        checkProperty(model, true);
        if(exist(model)){
            throw new IllegalArgumentException("已存在对应ID的帐号信息");
        }
        model.password = AuthorizeUtil.encryptPassword(model.password, model.userId);
        return super.insert(model);
    }

    /**
     *
     * @param model
     * @return
     */
    public long edit(UserModel model){
        checkProperty(model, false);
        if(!exist(model)){
            throw new IllegalArgumentException("不存在对应ID的帐号信息");
        }
        return super.update(model);
    }

    /**
     *
     * @param model
     * @return
     */
    @Override
    public long delete(UserModel model){
        if(!exist(model)){
            throw new IllegalArgumentException("不存在对应ID的帐号信息");
        }
        DefaultTransactionDefinition definition = getDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            mapperInstance.deleteUserRoleByUser(model.userId);
            mapperInstance.deleteUserLoginByUser(model.userId);
            long result = super.delete(model);
            transactionManager.commit(status);
            return result;
        }catch (Throwable ex) {
            transactionManager.rollback(status);
            throw ex;
        }
    }

    /**
     *
     * @param model
     * @return
     */
    public String login(UserModel model){
        if(StringUtils.isEmpty(model.userId)){
            throw new IllegalArgumentException("帐号ID不能为空");
        }
        if(StringUtils.isEmpty(model.password)){
            throw new IllegalArgumentException("密码不能为空");
        }
        model.password = AuthorizeUtil.encryptPassword(model.password, model.userId);
        if(mapperInstance.checkPassword(model.userId, model.password) <= 0){
            throw new IllegalArgumentException("用户名或密码不对");
        }else{
            String token = UUID.randomUUID().toString();
            mapperInstance.addLoginToken(model.userId, token);
            return token;
        }
    }

    /**
     *
     * @param model
     * @return
     */
    public boolean authRole(UserRoleModel model){
        if(!exist(model)){
            throw new IllegalArgumentException("不存在对应ID的帐号信息");
        }
        DefaultTransactionDefinition definition = getDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            mapperInstance.deleteUserRoleByUser(model.userId);
            if(CollectionUtils.isNotEmpty(model.roleList)){
                model.roleList.forEach(x->mapperInstance.addUserRole(model.userId, x.roleId));
            }
            transactionManager.commit(status);
            return true;
        } catch (Throwable ex) {
            transactionManager.rollback(status);
            throw ex;
        }
    }

    /**
     *
     * @param userId
     * @return
     */
    public UserModel getUserById(String userId){
        if(StringUtils.isEmpty(userId)){
            throw new IllegalArgumentException("帐号ID不能为空");
        }
        return mapperInstance.queryUserById(userId);
    }

    /**
     *
     * @param model
     * @return
     */
    public long resetPassword(UserRoleModel model){
        if(StringUtils.isEmpty(model.userId)){
            throw new IllegalArgumentException("帐号ID不能为空");
        }
        if(StringUtils.isEmpty(model.password)){
            throw new IllegalArgumentException("密码不能为空");
        }
        model.password = AuthorizeUtil.encryptPassword(model.password, model.userId);
        return mapperInstance.resetPassword(model.userId, model.password);
    }

    /**
     *
     * @param userId
     * @param model
     * @return
     */
    public long modifyPassword(String userId, ModifyPasswordModel model){
        if(StringUtils.isEmpty(model.oldPassword)){
            throw new IllegalArgumentException("原密码不能为空");
        }
        if(StringUtils.isEmpty(model.newPassword)){
            throw new IllegalArgumentException("新密码不能为空");
        }
        UserModel userModel = getUserById(userId);
        String oldPasswordEncrypt = AuthorizeUtil.encryptPassword(model.oldPassword, userId);
        if(!oldPasswordEncrypt.equals(userModel.password)){
            throw new ShowErrorTipsException("原密码不正确");
        }else{
            String newPasswordEncrypt = AuthorizeUtil.encryptPassword(model.newPassword, userId);
            return mapperInstance.resetPassword(userId, newPasswordEncrypt);
        }
    }

    /**
     *
     * @param userId
     * @param userName
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageModel<UserRoleModel> getPageUserRole(String userId, String userName, Long pageNo, Long pageSize){
        Pagination pagination = new Pagination(pageNo, pageSize);
        long totalCount = mapperInstance.queryUserCount(userId, userName);
        List<UserRoleModel> popInfoList = mapperInstance.queryUserRoleList(userId, userName, pagination.start, pagination.end);
        return new PageModel(pagination.no, totalCount, popInfoList);
    }

}
