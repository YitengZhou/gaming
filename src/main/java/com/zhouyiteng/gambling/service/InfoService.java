package com.zhouyiteng.gambling.service;

import com.zhouyiteng.gambling.helper.ImageCodeHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * 登录信息
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
@Slf4j
@Service
public class InfoService {

    @Value("${service.environment:}")
    private String environment;

    @Autowired
    private RedisService redisService;

    private static final char[] IMAGE_CODE_ARRAY=  new char[]{'0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public String getEnvironment() {
        if(StringUtils.isEmpty(environment)){
            return "";
        }
        /**
         * properties 文件中的中文会作为ISO_8859_1编码读入，需要手工转换成UTF-8输出
         */
        return new String(environment.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    /**
     * 图片验证码校验
     * @param ticket
     * @param imageCode
     * @return
     */
    public boolean checkImageCode(String ticket, String imageCode){
        return redisService.checkImageCode(ticket, imageCode);
    }

    /**
     * 生成图片验证码
     * @param ticket
     * @param codeCount
     * @return
     */
    public BufferedImage getImageCode(String ticket, int codeCount){
        if(StringUtils.isNotEmpty(ticket) && codeCount>0){
            Random random = new Random();
            StringBuilder codeBuilder = new StringBuilder();
            for (int i=0; i<codeCount; i++){
                codeBuilder.append(IMAGE_CODE_ARRAY[random.nextInt(62)]);
            }
            String imageCode = codeBuilder.toString();
            redisService.saveImageCode(ticket, imageCode);
            return ImageCodeHelper.getImageCode(150, 50, imageCode, 18);
        }
        return null;
    }

}
