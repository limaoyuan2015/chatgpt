package com.szmengran.chatgpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Spring Boot Starter
 *
 * @author Maoyuan.Li
 */
@EnableFeignClients(basePackages = {"com.szmengran.chatgpt.infrastructure.openai", "com.szmengran.chatgpt.infrastructure.oauth2.client"})
@SpringBootApplication(scanBasePackages = {"com.szmengran.chatgpt", "com.alibaba.cola"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
