package com.zhouyiteng.gambling.model;

import java.util.List;

public class PageModel<T> {

    public long pageNo;

    public long totalCount;

    public List<T> data;

    public PageModel(long pageNo, long totalCount, List<T> data){
        this.data = data;
        this.pageNo = pageNo;
        this.totalCount = totalCount;
    }

}
