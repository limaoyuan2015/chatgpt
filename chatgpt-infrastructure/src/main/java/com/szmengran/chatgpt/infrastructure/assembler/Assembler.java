package com.szmengran.chatgpt.infrastructure.assembler;

import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
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
        Assert.notNull(chatGPTProperties.getTemperature(), "配置信息temperature不能为空");
        Assert.notNull(chatGPTProperties.getMaxTokens(), "配置信息最大token数不能为空");
        Assert.notNull(chatGPTProperties.getModel(), "配置信息模型类型数不能为空");
        Assert.notNull(chatGPTProperties.getRole(), "配置信息角色不能为空");
        List<ChatMessage> list = chatCmd.getMessages();
        Assert.isTrue(list != null && !list.isEmpty(), "问题不能为空");
        list.forEach(msg -> {
            msg.setRole(Optional.ofNullable(msg.getRole()).orElse(chatGPTProperties.getRole()));
        });
        chatCmd.setMaxTokens(Optional.ofNullable(chatCmd.getMaxTokens()).orElse(chatGPTProperties.getMaxTokens()));
        chatCmd.setModel(Optional.ofNullable(chatCmd.getModel()).orElse(chatGPTProperties.getModel()));
        chatCmd.setTemperature(Optional.ofNullable(chatCmd.getTemperature()).orElse(chatGPTProperties.getTemperature()));
        return chatCmd;
    }
}
