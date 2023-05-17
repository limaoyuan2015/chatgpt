package com.szmengran.chatgpt.domain.config;

import feign.Logger;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

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
    private Map<String, String> model = new HashMap<>();
    private String user;
    private String role;
    private Integer maxTokens;
    private Double temperature;
    public Logger.Level level;
    
}
