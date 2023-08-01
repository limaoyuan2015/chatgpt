package com.szmengran.chatgpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Spring Boot Starter
 *
 * @author Maoyuan.Li
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableFeignClients(basePackages = {"com.szmengran.chatgpt.infrastructure.openai", "com.szmengran.chatgpt.infrastructure.oauth2.client"})
@SpringBootApplication(scanBasePackages = {"com.szmengran.chatgpt", "com.alibaba.cola"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
