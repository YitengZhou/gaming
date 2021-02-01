package com.zhouyiteng.gambling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfig {

//    public static final String LOGIN_USER_KEY="EM_DISPATCH_USER";
//
//    public static final String LOGIN_TOKEN_KEY="EM_DISPATCH_TOKEN";

    public static final String LOGIN_USER_KEY="YT_GAMBLING_USER";

    public static final String LOGIN_TOKEN_KEY="YT_GAMBLING_TOKEN";

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(6 * 1000);
        clientHttpRequestFactory.setReadTimeout(6 * 1000);
        return new RestTemplate(clientHttpRequestFactory);
    }

}
