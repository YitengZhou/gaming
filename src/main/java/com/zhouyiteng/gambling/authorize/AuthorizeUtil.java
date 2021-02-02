package com.zhouyiteng.gambling.authorize;

import com.zhouyiteng.gambling.helper.StringHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限验证拦截器
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public class AuthorizeUtil {

    /**
     * 对密码加盐后md5
     * @param value
     * @param salt
     * @return
     */
    public static String passwordSalt(String value, String salt){
        return DigestUtils.md5DigestAsHex((value+"|"+salt).getBytes());
    }

    //private

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
                        return StringHelper.fixedUrlDecode(item.getValue(), "UTF-8");
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
                    StringUtils.isEmpty(cookieValue)?"":StringHelper.fixedUrlDecode(cookieValue, "UTF-8"));
            cookie.setPath("/");
            cookie.setMaxAge(maxAge);
            response.addCookie(cookie);
        }
    }

}
