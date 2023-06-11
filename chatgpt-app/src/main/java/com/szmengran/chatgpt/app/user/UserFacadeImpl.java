package com.szmengran.chatgpt.app.user;

import com.szmengran.chatgpt.api.UserFacade;
import com.szmengran.chatgpt.app.converter.Converter;
import com.szmengran.chatgpt.dto.user.TokenCO;
import com.szmengran.chatgpt.dto.user.TokenQueryCmd;
import com.szmengran.chatgpt.infrastructure.oauth2.client.Oauth2Client;
import com.szmengran.chatgpt.infrastructure.oauth2.client.dto.TokenDTO;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2023/6/12 01:25
 */
@Service
public class UserFacadeImpl implements UserFacade {

	@Resource
	private Oauth2Client oauth2Client;

	@Override
	public TokenCO login(TokenQueryCmd tokenQueryCmd) {
		TokenDTO tokenDTO = oauth2Client.getToken(tokenQueryCmd);
		return Converter.INSTANCE.toTokenCO(tokenDTO);
	}
}
