package com.szmengran.chatgpt.infrastructure.openai;

import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import feign.Headers;
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
public class FeignClientFileConfiguration implements RequestInterceptor {
    
    @Resource
    private ChatGPTProperties chatGPTProperties;
    
    @Override
    public void apply(final RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "Bearer "+chatGPTProperties.getSecretKey());
    }
    
}
