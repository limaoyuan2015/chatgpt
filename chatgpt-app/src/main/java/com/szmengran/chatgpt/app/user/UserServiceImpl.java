package com.szmengran.chatgpt.app.user;

import com.szmengran.authorization.api.UserFacade;
import com.szmengran.authorization.dto.TokenCO;
import com.szmengran.authorization.dto.cqe.MiniProgramTokenQueryCmd;
import com.szmengran.authorization.dto.cqe.TokenQueryCmd;
import com.szmengran.authorization.dto.cqe.UserRegisterCmd;
import com.szmengran.chatgpt.api.UserService;
import com.szmengran.chatgpt.infrastructure.oauth2.config.ClientPrincipalProperties;
import com.szmengran.cola.dto.Command;
import com.szmengran.cola.dto.Response;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboReference;

import org.springframework.stereotype.Service;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2023/6/12 01:25
 */
@Service
public class UserServiceImpl implements UserService {

	@DubboReference
	private UserFacade userFacade;

	@Resource
	private ClientPrincipalProperties properties;

	@Override
	public TokenCO login(final TokenQueryCmd tokenQueryCmd) {
		tokenQueryCmd.setClientId(properties.getClientId());
		tokenQueryCmd.setClientSecret(properties.getClientSecret());
		tokenQueryCmd.setScope(properties.getScope());
		return userFacade.login(tokenQueryCmd);
	}
	
	@Override
	public TokenCO miniProgramLogin(MiniProgramTokenQueryCmd miniProgramTokenQueryCmd) {
		miniProgramTokenQueryCmd.setClientId(properties.getClientId());
		miniProgramTokenQueryCmd.setClientSecret(properties.getClientSecret());
		miniProgramTokenQueryCmd.setScope(properties.getScope());
		return userFacade.miniProgramLogin(miniProgramTokenQueryCmd);
	}
	
	@Override
	public Response register(final Command command) {
		UserRegisterCmd userRegisterCmd = (UserRegisterCmd) command;
		return userFacade.register(userRegisterCmd);
	}
}
