package com.zhouyiteng.gambling.model.game;

/**
 * 模型生成种类
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by liubake on 2021/2/7.
 */
public enum GenerateType {
    /**
     * 自动生成
     */
    AUTO("自动生成"),

    /**
     * 手动生成
     */
    MANUAL("手动生成");

    private String name;

    GenerateType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
