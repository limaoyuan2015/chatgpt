package com.szmengran.chatgpt.infrastructure.oauth2.client.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2023/6/8 23:47
 */
@Data
public class TokenDTO implements Serializable {

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("token_type")
	private String tokenType;

	@JsonProperty("expires_in")
	private Integer expiresIn;
}
