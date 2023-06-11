package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.UserFacade;
import com.szmengran.chatgpt.dto.user.TokenCO;
import com.szmengran.chatgpt.dto.user.TokenQueryCmd;
import com.szmengran.chatgpt.infrastructure.oauth2.config.ClientPrincipalProperties;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ChatGPT登录服务
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2023/6/8 23:01
 */
@Tag(name = "ChatGPT登录服务API")
@RestController
public class LoginController {

	@Resource
	private UserFacade userFacade;

	@Resource
	private ClientPrincipalProperties clientPrincipalProperties;

	@Operation(summary = "用户登录")
	@PostMapping("/login")
	public SingleResponse<TokenCO> login(@RequestBody TokenQueryCmd tokenQueryCmd) {
		tokenQueryCmd.setScope(clientPrincipalProperties.getScope());
		TokenCO tokenDTO = userFacade.login(tokenQueryCmd);
		return SingleResponse.of(tokenDTO);
	}
}
