package com.szmengran.chatgpt.infrastructure.oauth2.config;

import java.util.Base64;

import com.szmengran.chatgpt.infrastructure.oauth2.utils.Constants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/21 19:11
 * @Version 1.0
 */
@Configuration
public class Oauth2FeignClientConfiguration implements RequestInterceptor {
    
    @Resource
    private ClientPrincipalProperties clientPrincipalProperties;
    
    @Override
    public void apply(final RequestTemplate requestTemplate) {
        if (!filter(requestTemplate)) {
            return;
        }
        String authorization = "Basic " + Base64.getEncoder().encodeToString((clientPrincipalProperties.getClientId() + ":" + clientPrincipalProperties.getClientSecret()).getBytes());
        requestTemplate.header("Authorization", authorization);
    }

    private boolean filter(final RequestTemplate requestTemplate) {
        return requestTemplate.url().contains(Constants.OAUTH2_URL);
    }

}
