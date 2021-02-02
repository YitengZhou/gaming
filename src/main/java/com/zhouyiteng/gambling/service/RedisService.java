package com.zhouyiteng.gambling.service;

import com.zhouyiteng.gambling.exception.UnAuthException;
import com.zhouyiteng.gambling.exception.UnLoginException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Redis相关操作方法
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/2.
 */
@Slf4j
@Service
public class RedisService {

    private static final String EXPIRY_DELIMITER = ":";

    private static final String PERMISSION_MAP_USER_ID_KEY="PERMISSION_MAP_USER_ID_KEY";

    private static final String PERMISSION_MAP_USER_NAME_KEY="PERMISSION_MAP_USER_NAME_KEY";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 添加系统Redis前缀
     * @param value
     * @return
     */
    private String getSystemRedisKey(String value){
        return "YT-GAMBLING-ADMIN:" + value;
    }

    /**
     * 图片验证码key
     * @param ticket
     * @return
     */
    private String getImageCodeRedisKey(String ticket){
        return getSystemRedisKey("IMAGE-CODE:") + ticket;
    }

    /**
     * 保存图片验证码
     * @param ticket
     * @param imageCode
     */
    public void saveImageCode(String ticket, String imageCode){
        if(StringUtils.isNotEmpty(ticket) && StringUtils.isNotEmpty(imageCode)) {
            ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(getImageCodeRedisKey(ticket), imageCode.toUpperCase(), Duration.ofMinutes(3));
        }
    }

    /**
     * 校验图片验证码
     * @param ticket
     * @param imageCode
     * @return
     */
    public boolean checkImageCode(String ticket, String imageCode){
        if(StringUtils.isNotEmpty(ticket) && StringUtils.isNotEmpty(imageCode)) {
            ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
            return imageCode.toUpperCase().equals(valueOperations.get(getImageCodeRedisKey(ticket)));
        }
        return false;
    }

    /**
     * 获取username
     * @param token
     * @return
     */
    public String getUsername(String token){
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        return hashOperations.get(getSystemRedisKey(token),PERMISSION_MAP_USER_NAME_KEY);
    }

    /**
     * 获取权限信息
     * @param token
     * @return
     */
    public String[] getPermission(String token){
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        Set<String> keys = hashOperations.keys(getSystemRedisKey(token));
        keys.remove(PERMISSION_MAP_USER_ID_KEY);
        keys.remove(PERMISSION_MAP_USER_NAME_KEY);
        return keys.toArray(new String[keys.size()]);
    }

    /**
     * 退出登录清除用户token
     * @param token
     */
    public boolean logoutDeleteToken(String token){
        return redisTemplate.delete(getSystemRedisKey(token));
    }

    /**
     * 延长token有效期
     * @param token
     */
    private void updateTokenExpiry(String token){
        String[] splitArray = token.split(EXPIRY_DELIMITER);
        if(null!=splitArray && splitArray.length>1){
            int expirySeconds = Integer.parseInt(splitArray[1], 16);
            redisTemplate.expire(getSystemRedisKey(token), expirySeconds, TimeUnit.SECONDS);
        }
    }

    /**
     * 检查是否登录
     * @param userId
     * @param token
     */
    public void checkLogin(String userId, String token){
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(token)){
            throw new UnLoginException();
        }else{
            HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
            String value = hashOperations.get(getSystemRedisKey(token), PERMISSION_MAP_USER_ID_KEY);
            if(userId.equals(value)){
                updateTokenExpiry(token);
            }else{
                throw new UnLoginException();
            }
        }
    }

    /**
     * 检查是否具有权限
     * @param userId
     * @param token
     * @param permission
     */
    public void checkPermission(String userId, String token, String permission){
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(token)){
            throw new UnLoginException();
        }else{
            if(StringUtils.isEmpty(permission)){
                checkLogin(userId, token);
            }else{
                HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
                String value = hashOperations.get(getSystemRedisKey(token), permission);
                if(userId.equals(value)){
                    updateTokenExpiry(token);
                }else{
                    /**
                     * 没有权限的时候要验证下登录状态,判断是否由登录超时引起的
                     */
                    checkLogin(userId, token);
                    throw new UnAuthException();
                }
            }
        }
    }

    /**
     * 保存权限信息
     * @param userId
     * @param userName
     * @param permissionSet
     * @param expirySeconds
     * @return
     */
    public String savePermission(String userId, String userName, Set<String> permissionSet, int expirySeconds){
        if(StringUtils.isNotEmpty(userId)) {
            Map<String, String> permissionMap = new HashMap<>();
            permissionMap.put(PERMISSION_MAP_USER_ID_KEY, userId);
            permissionMap.put(PERMISSION_MAP_USER_NAME_KEY, userName);
            if (CollectionUtils.isNotEmpty(permissionSet)) {
                permissionSet.forEach(x -> permissionMap.put(x, userId));
            }
            String token = UUID.randomUUID().toString() + EXPIRY_DELIMITER + Integer.toHexString(expirySeconds);
            String redisTokenKey = getSystemRedisKey(token);
            try {
                redisTemplate.opsForHash().putAll(redisTokenKey, permissionMap);
                redisTemplate.expire(redisTokenKey, expirySeconds, TimeUnit.SECONDS);
            }catch (Throwable ex){
                redisTemplate.delete(redisTokenKey);
                throw ex;
            }
            return token;
        }
        return null;
    }

}
