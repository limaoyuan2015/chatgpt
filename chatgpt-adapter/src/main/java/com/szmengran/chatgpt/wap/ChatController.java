package com.szmengran.chatgpt.wap;

import java.security.Principal;

import com.szmengran.chatgpt.domain.chat.ChatDomainService;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 11:43
 *
 * @Version 1.0
 */
@Tag(name = "chat")
@RestController
public class ChatController {
    
    @Resource
    private ChatDomainService chatDomainService;
    
    @Operation(summary = "Creates a completion for the chat message")
    @PostMapping("/v1/chat/completions")
    public Mono<SingleResponse<ChatCO>> chat(@RequestBody ChatCmd chatCmd, Principal principal) {
        chatCmd.setUsername(principal.getName());
        return Mono.just(SingleResponse.of(chatDomainService.chat(chatCmd)));
    }
    
    @Operation(summary = "Creates a completion for the chat message")
    @PostMapping("/v1/chat/completionStream")
    public void chatStream(@RequestBody ChatCmd chatCmd, HttpServletResponse httpServletResponse, Principal principal) {
        chatCmd.setUsername(principal.getName());
        chatDomainService.chatStream(chatCmd, httpServletResponse);
    }
    
}
