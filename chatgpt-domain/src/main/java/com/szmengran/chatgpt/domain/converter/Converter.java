package com.szmengran.chatgpt.domain.converter;

import com.szmengran.chatgpt.domain.entity.ChatDetail;
import com.szmengran.chatgpt.domain.entity.ChatTitle;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.dto.chat.ChatCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionCmd;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author MaoYuan.Li
 * @Date 2023/4/28 14:18
 * @Version 1.0
 */
@Mapper
public interface Converter {
    
    Converter INSTANCE = Mappers.getMapper(Converter.class);
    
    ChatDetail toChatDetail(ChatCO chatCO);
    
    ChatTitle toChatTitle(ChatCO chatCO);
    
    ChatCreateCmd toChatCreateCmd(ChatCmd chatCmd);

    CompletionCreateCmd toCompletionCreateCmd(CompletionCmd completionCmd);
}
