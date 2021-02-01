package com.zhouyiteng.gambling.authorize;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 权限验证拦截器
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public class AuthorizeUtil {

    /**
     *
     * @param value
     * @param salt
     * @return
     */
    public static String encryptPassword(String value, String salt){
        return DigestUtils.md5DigestAsHex((value+"|"+salt).getBytes());
    }

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

    /**
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName){
        if(request != null){
            Cookie[] cookieArray = request.getCookies();
            if(cookieArray != null){
                for (Cookie item:cookieArray) {
                    if(item.getName().equals(cookieName)){
                        return fixedUrlDecode(item.getValue(), "UTF-8");
                    }
                }
            }
        }
        return "";
    }

    /**
     *
     * @param response
     * @param cookieName
     */
    public static void setCookieValue(HttpServletResponse response, String cookieName, String cookieValue, int maxAge){
        if(response != null && StringUtils.isNotEmpty(cookieName)){
            Cookie cookie = new Cookie(cookieName,
                   StringUtils.isEmpty(cookieValue)?"":fixedUrlDecode(cookieValue, "UTF-8"));
            cookie.setPath("/");
            cookie.setMaxAge(maxAge);
            response.addCookie(cookie);
        }
    }

}
