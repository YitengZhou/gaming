package com.zhouyiteng.gambling.model.game;

/**
 * 状态种类
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/9.
 */
public enum StatusType {
    /**
     * 等待开奖
     */
    WAIT("等待比赛"),

    /**
     * 等待开奖
     */
    DONE("比赛完成");

    private String name;

    StatusType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
