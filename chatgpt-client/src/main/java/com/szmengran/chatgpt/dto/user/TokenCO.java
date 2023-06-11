package com.szmengran.chatgpt.dto.user;

import com.szmengran.cola.dto.DTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2023/6/12 01:14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenCO extends DTO {

	@Schema(description = "token")
	private String accessToken;

	@Schema(description = "授权范围")
	private String scope;

	@Schema(description = "授权类型")
	private String tokenType;

	@Schema(description = "过期时间")
	private Integer expiresIn;
}
