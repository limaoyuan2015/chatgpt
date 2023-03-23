package com.szmengran.chatgpt.app.chat;

import com.szmengran.chatgpt.api.ChatCompletionFacade;
import com.szmengran.chatgpt.dto.chat.ChatCompletionCO;
import com.szmengran.chatgpt.dto.chat.ChatCompletionCreateCmd;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 12:07
 * @Version 1.0
 */
@Service
public class ChatCompletionFacadeImpl implements ChatCompletionFacade {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public SingleResponse<ChatCompletionCO> chatCompletion(final ChatCompletionCreateCmd chatCompletionCreateCmd) {
        ChatCompletionCO completionCO = openAiClient.createChatCompletion(chatCompletionCreateCmd);
        return SingleResponse.of(completionCO);
    }
}
