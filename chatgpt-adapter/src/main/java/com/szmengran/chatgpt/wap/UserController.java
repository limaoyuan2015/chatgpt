package com.szmengran.chatgpt.wap;

import com.szmengran.authorization.dto.TokenCO;
import com.szmengran.authorization.dto.cqe.MiniProgramTokenQueryCmd;
import com.szmengran.authorization.dto.cqe.TokenQueryCmd;
import com.szmengran.authorization.dto.cqe.UserRegisterCmd;
import com.szmengran.chatgpt.app.user.UserServiceImpl;
import com.szmengran.chatgpt.dto.ChatGPTTokenCO;
import com.szmengran.chatgpt.infrastructure.oauth2.config.ClientPrincipalProperties;
import com.szmengran.cola.dto.Response;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ChatGPT登录服务
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2023/6/8 23:01
 */
@Tag(name = "ChatGPT用户服务API")
@RestController
public class UserController {

	@Resource
	private UserServiceImpl userService;

	@Resource
	private ClientPrincipalProperties clientPrincipalProperties;
	
	@Operation(summary = "用户登录")
	@PostMapping("/login")
	public SingleResponse<TokenCO> passwordLogin(@RequestBody TokenQueryCmd tokenQueryCmd) {
		tokenQueryCmd.setScope(clientPrincipalProperties.getScope());
		TokenCO tokenCO = userService.login(tokenQueryCmd);
		return SingleResponse.of(tokenCO);
	}
	
	@Operation(summary = "小程序用户登录")
	@PostMapping("/login/{code}")
	public SingleResponse<TokenCO> miniProgramLogin(@PathVariable("code") String code, @RequestBody MiniProgramTokenQueryCmd miniProgramTokenQueryCmd) {
		miniProgramTokenQueryCmd.setScope(clientPrincipalProperties.getScope());
		miniProgramTokenQueryCmd.setCode(code);
		TokenCO tokenCO = userService.miniProgramLogin(miniProgramTokenQueryCmd);
		return SingleResponse.of(tokenCO);
	}

	@Operation(summary = "用户注册")
	@PostMapping("/register")
	public Response register(@RequestBody UserRegisterCmd userRegisterCmd) {
		return userService.register(userRegisterCmd);
	}
}
