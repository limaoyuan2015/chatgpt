package com.szmengran.chatgpt.infrastructure.oauth2.config;

import feign.Logger;
import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2023/6/9 01:23
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "client.principal")
public class ClientPrincipalProperties {

	private String clientId;
	private String clientSecret;

	private String scope;

}

