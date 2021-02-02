package com.zhouyiteng.gambling.config;

import com.zhouyiteng.gambling.service.RedisService;
import com.zhouyiteng.gambling.authorize.AuthorizeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 注册自定义拦截器
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/2.
 */
@Configuration
@Order(value = Integer.MAX_VALUE)
public class InterceptConfig implements WebMvcConfigurer {

    @Autowired
    private AuthorizeInterceptor authorizeInterceptor;

    @Bean
    public AuthorizeInterceptor initAuthorizeInterceptor(RedisService redisService){
        return new AuthorizeInterceptor(redisService);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 添加自定义权限拦截器
         */
        registry.addInterceptor(authorizeInterceptor);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        /**
         * 添加自定义参数解析
         */
        argumentResolvers.add(authorizeInterceptor);
    }

}