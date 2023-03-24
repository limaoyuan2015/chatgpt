package com.szmengran.chatgpt.app.assembler;

import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import com.szmengran.chatgpt.dto.chat.ChatCompletionCreateCmd;
import com.szmengran.chatgpt.dto.chat.ChatMessageRole;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/24 12:06
 * @Version 1.0
 */
public class ChatAssembler {
    
    public static ChatCompletionCreateCmd converter(ChatCompletionCreateCmd chatCompletionCreateCmd, ChatGPTProperties chatGPTProperties) {
        if (StringUtils.isBlank(chatCompletionCreateCmd.getModel())) {
            chatCompletionCreateCmd.setModel(chatGPTProperties.getModel());
        }
    
        chatCompletionCreateCmd.getMessages().forEach(chatMessage -> {
            if (StringUtils.isBlank(chatMessage.getRole())) {
                chatMessage.setRole(ChatMessageRole.USER.value());
            }
        });
        return chatCompletionCreateCmd;
    }
}
