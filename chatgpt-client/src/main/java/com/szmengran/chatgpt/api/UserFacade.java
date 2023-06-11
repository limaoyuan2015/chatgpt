package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.user.TokenCO;
import com.szmengran.chatgpt.dto.user.TokenQueryCmd;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2023/6/12 01:19
 */
public interface UserFacade {

	/**
	 * 用户登录
	 * @param tokenQueryCmd
	 * @Return com.szmengran.chatgpt.dto.user.TokenCO
	 * @Date: 2023/6/12 01:25
	 * @Author: <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
	 */ 
	TokenCO login(TokenQueryCmd tokenQueryCmd);
}
