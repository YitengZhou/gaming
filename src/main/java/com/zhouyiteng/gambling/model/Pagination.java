package com.zhouyiteng.gambling.model;

public class Pagination {

    public long no;

    public long size;

    public long start;

    public long end;

    public Pagination(Long pageNo, Long pageSize){
        if(null==pageNo || pageNo<=0){
            this.no = 1L;
        }else{
            this.no = pageNo.longValue();
        }
        if(null==pageSize || pageSize<=0){
            this.size = 30L;
        }else{
            this.size = pageSize.longValue();
        }
        this.start = this.size * (this.no - 1);
        this.end = this.size * this.no;
    }

}
