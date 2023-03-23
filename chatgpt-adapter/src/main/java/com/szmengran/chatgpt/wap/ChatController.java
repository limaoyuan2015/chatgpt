package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.ChatCompletionFacade;
import com.szmengran.chatgpt.dto.chat.ChatCompletionCO;
import com.szmengran.chatgpt.dto.chat.ChatCompletionCreateCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 11:43
 *
 * @Version 1.0
 */
@Tag(name = "Given a chat conversation, the model will return a chat completion response.")
@RestController
@RequestMapping("/chat")
public class ChatController {
    
    @Resource
    private ChatCompletionFacade chatCompletionFacade;
    
    @Operation(summary = "Creates a completion for the chat message")
    @PostMapping("/completions")
    public SingleResponse<ChatCompletionCO> chatCompletions(@RequestBody ChatCompletionCreateCmd chatCompletionCreateCmd) {
        return chatCompletionFacade.chatCompletion(chatCompletionCreateCmd);
    }
}
