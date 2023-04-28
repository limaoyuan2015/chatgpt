package com.szmengran.chatgpt.app.assembler;

import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/24 12:06
 * @Version 1.0
 */
public class ChatAssembler {
    
    public static ChatCmd converter(ChatCmd chatCmd, ChatGPTProperties chatGPTProperties) {
//        if (StringUtils.isBlank(chatCmd.getModel())) {
//            chatCmd.setModel(chatGPTProperties.getModel());
//        }
//
//        chatCmd.getMessages().forEach(chatMessage -> {
//            if (StringUtils.isBlank(chatMessage.getRole())) {
//                chatMessage.setRole(ChatMessageRole.USER.value());
//            }
//        });
        return chatCmd;
    }
}
