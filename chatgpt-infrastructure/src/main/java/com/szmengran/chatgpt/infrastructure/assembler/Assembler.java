package com.szmengran.chatgpt.infrastructure.assembler;

import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import com.szmengran.chatgpt.domain.converter.Converter;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.dto.chat.ChatCreateCmd;
import com.szmengran.chatgpt.dto.chat.ChatMessage;
import com.szmengran.cola.exception.Assert;

import java.util.List;
import java.util.Optional;

/**
 * @Author MaoYuan.Li
 * @Date 2023/5/4 15:44
 * @Version 1.0
 */
public class Assembler {
    
    public static ChatCreateCmd transform(ChatCmd chatCmd, ChatGPTProperties chatGPTProperties) {
        Assert.notNull(chatGPTProperties.getTemperature(), "config msg temperature can't be null");
        Assert.notNull(chatGPTProperties.getMaxTokens(), "default config token can't be null");
        Assert.notNull(chatGPTProperties.getModel(), "default config model can't be null");
        Assert.notNull(chatGPTProperties.getRole(), "default config role can't be null");
        List<ChatMessage> list = chatCmd.getMessages();
        Assert.isTrue(list != null && !list.isEmpty(), "question can't be null");
        list.forEach(msg -> {
            msg.setRole(Optional.ofNullable(msg.getRole()).orElse(chatGPTProperties.getRole()));
        });
        chatCmd.setMaxTokens(Optional.ofNullable(chatCmd.getMaxTokens()).orElse(chatGPTProperties.getMaxTokens()));
        chatCmd.setModel(Optional.ofNullable(chatCmd.getModel()).orElse(chatGPTProperties.getModel().get("chat")));
        chatCmd.setTemperature(Optional.ofNullable(chatCmd.getTemperature()).orElse(chatGPTProperties.getTemperature()));
        return Converter.INSTANCE.toChatCreateCmd(chatCmd);
    }
}
