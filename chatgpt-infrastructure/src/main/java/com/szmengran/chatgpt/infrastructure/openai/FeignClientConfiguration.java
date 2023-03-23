package com.szmengran.chatgpt.infrastructure.openai;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Util;
import feign.codec.Decoder;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/21 19:11
 * @Version 1.0
 */
@Configuration
public class FeignClientConfiguration implements RequestInterceptor {
    
    @Resource
    private ChatGPTProperties chatGPTProperties;
    
    @Override
    public void apply(final RequestTemplate requestTemplate) {
        requestTemplate.header("Content-Type", "application/json");
        requestTemplate.header("Authorization", "Bearer "+chatGPTProperties.getSecretKey());
    }
    
    @Bean
    Logger.Level feignLoggerLevel() {
        //这里记录所有，根据实际情况选择合适的日志level
        return Logger.Level.FULL;
    }

}
