package com.szmengran.chatgpt.domain.assembler;

import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import com.szmengran.chatgpt.domain.entity.ChatDetail;
import com.szmengran.chatgpt.domain.entity.ChatTitle;
import com.szmengran.chatgpt.domain.entity.CompletionDetail;
import com.szmengran.chatgpt.domain.entity.CompletionTitle;
import com.szmengran.chatgpt.domain.utils.ModelType;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.dto.chat.ChatMessageRole;
import com.szmengran.chatgpt.dto.completion.CompletionCO;
import com.szmengran.chatgpt.dto.completion.CompletionCmd;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author MaoYuan.Li
 * @Date 2023/5/4 17:23
 * @Version 1.0
 */
public class Assembler {

    public static ChatCmd converter(ChatCmd chatCmd, ChatGPTProperties chatGPTProperties) {
        if (StringUtils.isBlank(chatCmd.getModel())) {
            chatCmd.setModel(chatGPTProperties.getModel().get(ModelType.CHAT));
        }

        chatCmd.getMessages().forEach(chatMessage -> {
            if (StringUtils.isBlank(chatMessage.getRole())) {
                chatMessage.setRole(ChatMessageRole.USER.value());
            }
        });
        return chatCmd;
    }

    public static CompletionCmd converter(CompletionCmd completionCmd, ChatGPTProperties chatGPTProperties) {
        if (StringUtils.isBlank(completionCmd.getModel())) {
            completionCmd.setModel(chatGPTProperties.getModel().get(ModelType.COMPLETIONS));
        }
        return completionCmd;
    }

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

    public static CompletionDetail toCompletionDetail(CompletionCmd completionCmd, CompletionCO completionCO) {
        return CompletionDetail.builder().completionDetailId(completionCO.getId())
                .completionId(completionCmd.getCompletionId())
                .question(completionCmd.getPrompt())
                .answer(completionCO.getChoices().get(0).getText())
                .promptTokens(completionCO.getUsage().getPromptTokens())
                .completionTokens(completionCO.getUsage().getCompletionTokens())
                .totalTokens(completionCO.getUsage().getTotalTokens())
                .build();
    }
    
    public static ChatTitle toChatTitle(ChatCmd chatCmd, ChatCO chatCO) {
        return ChatTitle.builder().chatId(chatCO.getChatId())
                .username(chatCmd.getUsername())
                .title(chatCO.getTitle())
                .build();
    }

    public static CompletionTitle toCompletionTitle(CompletionCmd completionCmd, CompletionCO completionCO) {
        return CompletionTitle.builder().completionId(completionCmd.getCompletionId())
                .username(completionCmd.getUsername())
                .title(completionCO.getTitle())
                .build();
    }
}
