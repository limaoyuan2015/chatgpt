package com.szmengran.chatgpt.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 20:11
 * @Version 1.0
 */
@Data
@Configuration
@ConfigurationProperties("openai")
public class ChatGPTProperties {
    
    private String secretKey;
    private String organizationId;
    private String model;
    private String user;
    
}
