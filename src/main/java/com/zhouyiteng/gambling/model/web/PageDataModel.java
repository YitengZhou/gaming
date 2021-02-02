package com.zhouyiteng.gambling.model.web;

import lombok.Data;

import java.util.List;

/**
 * 分页数据模型定义
 *
 * @author bake@eastmoney.com
 *
 * Created by liubake on 2020/11/25.
 */
@Data
public class PageDataModel<T> {

    /**
     * 每页大小
     */
    private Long pageSize;

    /**
     * 当前页码
     */
    private Long pageIndex;

    /**
     *
     */
    private Long pageStart;

    /**
     *
     */
    private Long pageEnd;

    /**
     * 总数量
     */
    private Long totalCount;

    /**
     * 数据列表
     */
    private List<T> dataList;

    /**
     *
     * @param pageSize
     * @param pageIndex
     */
    public PageDataModel(Long pageSize, Long pageIndex){
        this.pageSize = (null==pageSize||pageSize<=0) ? 10L : pageSize;
        this.pageIndex = (null==pageIndex||pageIndex<=0) ? 1L : pageIndex;
        this.pageStart = this.pageSize * (this.pageIndex-1) + 1;
        this.pageEnd = this.pageSize * this.pageIndex;
    }

}
