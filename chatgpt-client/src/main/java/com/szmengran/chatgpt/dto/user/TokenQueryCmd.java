package com.szmengran.chatgpt.dto.user;

import java.io.Serializable;

import com.szmengran.cola.dto.Query;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class TokenQueryCmd extends Query {

	@Schema(description = "授权类型")
	private String grant_type;

	@Schema(description = "用户名")
	private String username;

	@Schema(description = "密码")
	private String password;

	@Hidden
	@Schema(description = "授权范围")
	private String scope;

}
