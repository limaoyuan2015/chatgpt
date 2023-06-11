package com.szmengran.chatgpt.infrastructure.oauth2.client;

import com.szmengran.chatgpt.dto.user.TokenQueryCmd;
import com.szmengran.chatgpt.infrastructure.oauth2.client.dto.TokenDTO;
import com.szmengran.chatgpt.infrastructure.oauth2.config.Oauth2FeignClientConfiguration;
import com.szmengran.chatgpt.infrastructure.oauth2.utils.Constants;
import feign.QueryMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${oauth2.serverName}")
@Import(Oauth2FeignClientConfiguration.class)
public interface Oauth2Client {

	@PostMapping(value = Constants.OAUTH2_URL, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	TokenDTO getToken(@QueryMap TokenQueryCmd tokenQueryCmd);
}
