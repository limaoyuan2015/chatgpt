package com.szmengran.chatgpt.infrastructure.oauth2.client;

import com.szmengran.chatgpt.infrastructure.oauth2.client.dto.TokenDTO;
import com.szmengran.chatgpt.infrastructure.oauth2.client.dto.TokenQueryCmd;
import com.szmengran.chatgpt.infrastructure.oauth2.config.Oauth2FeignClientConfiguration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${oauth2.serverName}", configuration = Oauth2FeignClientConfiguration.class)
public interface Oauth2Client {

	@PostMapping(value = "/oauth2/token", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	TokenDTO getToken(@ModelAttribute TokenQueryCmd tokenQueryCmd);
}
