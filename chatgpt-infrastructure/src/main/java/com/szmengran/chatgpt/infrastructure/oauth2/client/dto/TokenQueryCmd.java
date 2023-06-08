package com.szmengran.chatgpt.infrastructure.oauth2.client.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2023/6/8 23:53
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TokenQueryCmd implements Serializable {

	private String grant_type;
	private String username;
	private String password;
	private String scope;

}
