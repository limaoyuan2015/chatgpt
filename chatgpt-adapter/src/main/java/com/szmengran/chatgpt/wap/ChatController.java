package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.ChatFacade;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
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
    private ChatFacade chatFacade;
    
    @Operation(summary = "Creates a completion for the chat message")
    @PostMapping("/v1/chat/completions")
    public SingleResponse<ChatCO> chatCompletions(@RequestBody ChatCmd chatCmd) {
        return chatFacade.chat(chatCmd);
    }
}
