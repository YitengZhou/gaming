package com.zhouyiteng.gambling.helper;

import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;

/**
 * 请求工具类
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public class RequestHelper {

    /**
     * 获取请求IP
     * @param request
     * @return
     */
    public static String getRequestIp(HttpServletRequest request){
        if(null == request){
            return "";
        }else {
            /**
             * X-Forwarded-For：Squid 服务代理
             */
            String requestIp = request.getHeader("X-Forwarded-For");
            if (StringUtils.isEmpty(requestIp) || "unknown".equalsIgnoreCase(requestIp)){
                /**
                 * Proxy-Client-IP：apache 服务代理
                 */
                requestIp = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(requestIp) || "unknown".equalsIgnoreCase(requestIp)){
                /**
                 * WL-Proxy-Client-IP：weblogic 服务代理
                 */
                requestIp = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(requestIp) || "unknown".equalsIgnoreCase(requestIp)){
                /**
                 * HTTP_CLIENT_IP：有些代理服务器
                 */
                requestIp = request.getHeader("HTTP_CLIENT_IP");
            }
            if (StringUtils.isEmpty(requestIp) || "unknown".equalsIgnoreCase(requestIp)){
                /**
                 * X-Real-IP：nginx服务代理
                 */
                requestIp = request.getHeader("X-Real-IP");
            }
            if (StringUtils.isNotEmpty(requestIp) && requestIp.indexOf(',')>0){
                /**
                 * 有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
                 */
                requestIp = requestIp.split(",")[0];
            }
            if (StringUtils.isEmpty(requestIp) || "unknown".equalsIgnoreCase(requestIp)){
                /**
                 * 获取请求对应的IP
                 */
                requestIp = request.getRemoteAddr();
            }
            return requestIp;
        }
    }

}
