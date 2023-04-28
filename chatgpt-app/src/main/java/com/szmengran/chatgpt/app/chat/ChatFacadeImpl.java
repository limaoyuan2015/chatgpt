package com.szmengran.chatgpt.app.chat;

import com.szmengran.chatgpt.api.ChatFacade;
import com.szmengran.chatgpt.app.assembler.ChatAssembler;
import com.szmengran.chatgpt.domain.chat.ChatDomainService;
import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.dto.chat.ChatDTO;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 12:07
 * @Version 1.0
 */
@Service
public class ChatFacadeImpl implements ChatFacade {
    
    @Resource
    private ChatGPTProperties chatGPTProperties;
    
    @Resource
    private ChatDomainService chatDomainService;
    
    @Override
    public SingleResponse<ChatDTO> chat(final ChatCmd chatCmd) {
        ChatAssembler.converter(chatCmd, chatGPTProperties);
        ChatDTO chatDTO = chatDomainService.chat(chatCmd);
        return SingleResponse.of(chatDTO);
    }
}
