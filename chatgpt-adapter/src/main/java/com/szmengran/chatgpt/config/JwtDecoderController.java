package com.szmengran.chatgpt.config;

import com.szmengran.cola.dto.SingleResponse;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Author MaoYuan.Li
 * @Date 2023/5/5 9:58
 * @Version 1.0
 */
@RestController
public class JwtDecoderController {
    
    @RequestMapping("/get/principal")
    public SingleResponse<String> get(Principal principal) {
        String name = principal.getName();
        return SingleResponse.of(name);
    }
}
