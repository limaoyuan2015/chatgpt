package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.chat.ChatCompletionCO;
import com.szmengran.chatgpt.dto.chat.ChatCompletionCreateCmd;
import com.szmengran.cola.dto.SingleResponse;

public interface ChatCompletionFacade {

    /** 
     * @description: Creates a completion for the chat message
     * @param chatCompletionCreateCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.chat.ChatCompletionCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/23 12:07
     */
    SingleResponse<ChatCompletionCO> chatCompletion(ChatCompletionCreateCmd chatCompletionCreateCmd);

}
