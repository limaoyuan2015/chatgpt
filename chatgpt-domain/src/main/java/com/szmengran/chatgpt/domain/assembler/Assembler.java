package com.szmengran.chatgpt.domain.assembler;

import com.szmengran.chatgpt.domain.entity.ChatDetail;
import com.szmengran.chatgpt.domain.entity.ChatTitle;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;

/**
 * @Author MaoYuan.Li
 * @Date 2023/5/4 17:23
 * @Version 1.0
 */
public class Assembler {
    
    public static ChatDetail toChatDetail(ChatCmd chatCmd, ChatCO chatCO) {
        return ChatDetail.builder().chatDetailId(chatCO.getChatDetailId())
                .chatId(chatCO.getChatId())
                .question(chatCmd.getMessages().get(0).getContent())
                .answer(chatCO.getChoices().get(0).getMessage().getContent())
                .promptTokens(chatCO.getUsage().getPromptTokens())
                .completionTokens(chatCO.getUsage().getCompletionTokens())
                .totalTokens(chatCO.getUsage().getTotalTokens())
                .build();
    }
    
    public static ChatTitle toChatTitle(ChatCmd chatCmd, ChatCO chatCO) {
        return ChatTitle.builder().chatId(chatCO.getChatId())
                .username(chatCmd.getUsername())
                .title(chatCO.getTitle())
                .build();
    }
}