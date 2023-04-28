package com.szmengran.chatgpt.domain.chat;

import com.szmengran.base.utils.IDUtils;
import com.szmengran.chatgpt.domain.chat.repository.ChatRepository;
import com.szmengran.chatgpt.domain.converter.Converter;
import com.szmengran.chatgpt.domain.entity.ChatDetail;
import com.szmengran.chatgpt.domain.entity.ChatTitle;
import com.szmengran.chatgpt.domain.utils.IDTypes;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.dto.chat.ChatDTO;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 12:27
 * @Version 1.0
 */
@Service
public class ChatDomainService {

    @Resource
    private ChatRepository chatRepository;

    public ChatDTO chat(ChatCmd chatCmd) {
        ChatDTO chatDTO = chatRepository.chat(chatCmd);
        ChatDetail chatDetail = Converter.INSTANCE.toChatDetail(chatDTO);
        chatRepository.addChatDetail(chatDetail);
        if (StringUtils.isBlank(chatCmd.getChatId())) {
            ChatTitle chatTitle = Converter.INSTANCE.toChatTitle(chatDTO);
            
//            chatTitle.setUsername();
            chatRepository.addChatTitle(chatTitle);
        }
        return chatDTO;
    }
}
