package com.szmengran.chatgpt.infrastructure.openai;

import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import com.szmengran.chatgpt.infrastructure.oauth2.utils.Constants;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/21 19:11
 * @Version 1.0
 */
@Configuration
public class OpenAiClientConfiguration implements RequestInterceptor {
    
    @Resource
    private ChatGPTProperties chatGPTProperties;
    
    @Override
    public void apply(final RequestTemplate requestTemplate) {
        if (filter(requestTemplate)) {
            return;
        }
        requestTemplate.header("Authorization", "Bearer "+chatGPTProperties.getSecretKey());
    }

    private boolean filter(final RequestTemplate requestTemplate) {
        return requestTemplate.url().contains(Constants.OAUTH2_URL);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        //这里记录所有，根据实际情况选择合适的日志level
        return chatGPTProperties.getLevel();
    }
    
}
