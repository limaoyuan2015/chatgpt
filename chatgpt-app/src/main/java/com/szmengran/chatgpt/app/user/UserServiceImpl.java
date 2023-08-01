package com.szmengran.chatgpt.app.user;

import com.szmengran.authorization.api.UserFacade;
import com.szmengran.authorization.dto.cqe.UserRegisterCmd;
import com.szmengran.chatgpt.api.UserService;
import com.szmengran.chatgpt.app.converter.Converter;
import com.szmengran.chatgpt.dto.user.MiniProgramTokenQueryCmd;
import com.szmengran.chatgpt.dto.user.TokenCO;
import com.szmengran.chatgpt.dto.user.TokenQueryCmd;
import com.szmengran.chatgpt.infrastructure.oauth2.client.Oauth2Client;
import com.szmengran.chatgpt.infrastructure.oauth2.client.dto.TokenDTO;
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
	private Oauth2Client oauth2Client;
	
	@Override
	public TokenCO login(final TokenQueryCmd tokenQueryCmd) {
		TokenDTO tokenDTO = oauth2Client.getToken(tokenQueryCmd);
		return Converter.INSTANCE.toTokenCO(tokenDTO);
	}
	
	@Override
	public TokenCO miniProgramLogin(MiniProgramTokenQueryCmd miniProgramTokenQueryCmd) {
		TokenDTO tokenDTO = oauth2Client.getMiniProgramToken(miniProgramTokenQueryCmd);
		return Converter.INSTANCE.toTokenCO(tokenDTO);
	}
	
	@Override
	public Response register(final Command command) {
		UserRegisterCmd userRegisterCmd = (UserRegisterCmd) command;
		return userFacade.register(userRegisterCmd);
	}
}
