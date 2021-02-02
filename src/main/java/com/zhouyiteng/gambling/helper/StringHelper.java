package com.zhouyiteng.gambling.helper;

import org.apache.commons.lang3.StringUtils;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 字符串工具类
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public class StringHelper {

    /**
     * URLEncoder.encode 的时候会把 空格 号转换为 + 所以这里在 encode 之后需要把空格替换成 %20
     * @param value
     * @param charsetName
     * @return
     */
    public static String fixedUrlEncode(String value, String charsetName){
        if(StringUtils.isNotEmpty(value)) {
            try {
                return URLEncoder.encode(value, charsetName).replace("+", "%20");
            }catch (Exception e){}
        }
        return value;
    }

    /**
     *
     * @param value
     * @param charsetName
     * @return
     */
    public static String fixedUrlDecode(String value, String charsetName){
        if(StringUtils.isNotEmpty(value)) {
            try {
                return URLDecoder.decode(value.replace("+", "%2B"), charsetName);
            }catch (Exception e){}
        }
        return value;
    }

}
