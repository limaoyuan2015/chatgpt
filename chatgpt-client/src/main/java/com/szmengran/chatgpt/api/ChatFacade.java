package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.cola.dto.SingleResponse;

public interface ChatFacade {

    /** 
     * @description: Creates a completion for the chat message
     * @param chatCmd
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.chat.ChatCompletionCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/23 12:07
     */
    SingleResponse<ChatCO> chat(ChatCmd chatCmd);

}
