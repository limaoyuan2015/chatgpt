package com.szmengran.chatgpt.domain.chat;

import com.szmengran.chatgpt.domain.assembler.Assembler;
import com.szmengran.chatgpt.domain.chat.repository.ChatRepository;
import com.szmengran.chatgpt.domain.entity.ChatDetail;
import com.szmengran.chatgpt.domain.entity.ChatTitle;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 12:27
 * @Version 1.0
 */
@Service
public class ChatDomainService {

    @Resource
    private ChatRepository chatRepository;

    public ChatCO chat(ChatCmd chatCmd) {
        ChatCO chatCO = chatRepository.chat(chatCmd);
        ChatDetail chatDetail = Assembler.toChatDetail(chatCmd, chatCO);
        chatRepository.addChatDetail(chatDetail);
        if (StringUtils.isBlank(chatCmd.getChatId())) {
            ChatTitle chatTitle = Assembler.toChatTitle(chatCmd, chatCO);
            chatRepository.addChatTitle(chatTitle);
        }
        return chatCO;
    }
}
