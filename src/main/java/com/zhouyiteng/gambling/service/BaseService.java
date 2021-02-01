package com.zhouyiteng.gambling.service;

import com.zhouyiteng.gambling.dao.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Service基类
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public abstract class BaseService<T, V extends BaseMapper<T>> {

    protected final V mapperInstance;

    @Autowired
    protected DataSourceTransactionManager transactionManager;

    /**
     *
     * @return
     */
    protected DefaultTransactionDefinition getDefinition(){
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        return definition;
    }

    public BaseService(V mapperValue){
        this.mapperInstance = mapperValue;
    }

    public long insert(T value){
        return mapperInstance.insert(value);
    }

    public long update(T value){
        return mapperInstance.update(value);
    }

    public long delete(T value){
        return mapperInstance.delete(value);
    }

}
