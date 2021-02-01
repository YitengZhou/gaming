package com.zhouyiteng.gambling.service;

import com.zhouyiteng.gambling.dao.RoleMapper;
import com.zhouyiteng.gambling.model.PageModel;
import com.zhouyiteng.gambling.model.Pagination;
import com.zhouyiteng.gambling.model.auth.RoleModel;
import com.zhouyiteng.gambling.model.auth.RolePermissionModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

/**
 *
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Slf4j
@Service
public class RoleService extends BaseService<RoleModel, RoleMapper> {

    @Autowired
    public RoleService(RoleMapper mapper) {
        super(mapper);
    }

    /**
     *
     * @param model
     * @return
     */
    public boolean exist(RoleModel model){
        if(StringUtils.isEmpty(model.roleId)){
            throw new IllegalArgumentException("角色ID不能为空");
        }
        return mapperInstance.exist(model.roleId) > 0;
    }

    /**
     *
     * @param model
     */
    private void checkProperty(RoleModel model){
        if(StringUtils.isEmpty(model.roleId)){
            throw new IllegalArgumentException("角色ID不能为空");
        }
        if(StringUtils.isEmpty(model.roleName)){
            throw new IllegalArgumentException("角色名称不能为空");
        }
    }

    /**
     *
     * @param model
     * @return
     */
    public long add(RoleModel model){
        checkProperty(model);
        if(exist(model)){
            throw new IllegalArgumentException("已存在对应ID的角色信息");
        }
        return super.insert(model);
    }

    /**
     *
     * @param model
     * @return
     */
    public long edit(RoleModel model){
        checkProperty(model);
        if(!exist(model)){
            throw new IllegalArgumentException("不存在对应ID的角色信息");
        }
        return super.update(model);
    }

    /**
     *
     * @param model
     * @return
     */
    @Override
    public long delete(RoleModel model){
        if(!exist(model)){
            throw new IllegalArgumentException("不存在对应ID的角色信息");
        }
        if(mapperInstance.checkUserByRole(model.roleId)>0){
            throw new IllegalArgumentException("该角色下有对应的用户信息，不能删除");
        }
        DefaultTransactionDefinition definition = getDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            mapperInstance.deleteRolePermissionByRole(model.roleId);
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
     * @return
     */
    public List<RoleModel> getAllRole(){
        return mapperInstance.queryAllRole();
    }

    /**
     *
     * @param userId
     * @return
     */
    public List<RolePermissionModel> getRolePermissionByUser(String userId){
        return mapperInstance.queryRolePermissionByUser(userId);
    }

    /**
     *
     * @param model
     * @return
     */
    public boolean authPermission(RolePermissionModel model){
        if(!exist(model)){
            throw new IllegalArgumentException("不存在对应ID的角色信息");
        }
        DefaultTransactionDefinition definition = getDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            mapperInstance.deleteRolePermissionByRole(model.roleId);
            if(CollectionUtils.isNotEmpty(model.permissionList)){
                model.permissionList.forEach(x->mapperInstance.addRolePermission(model.roleId, x));
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
     * @param roleId
     * @param roleName
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageModel<RolePermissionModel> getPageRolePermission(String roleId, String roleName, Long pageNo, Long pageSize){
        Pagination pagination = new Pagination(pageNo, pageSize);
        long totalCount = mapperInstance.queryRoleCount(roleId, roleName);
        List<RolePermissionModel> popInfoList = mapperInstance.queryRolePermissionList(roleId, roleName, pagination.start, pagination.end);
        return new PageModel(pagination.no, totalCount, popInfoList);
    }

}
