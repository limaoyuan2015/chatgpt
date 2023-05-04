package com.szmengran.chatgpt.domain.completion;

import com.szmengran.chatgpt.domain.completion.repository.CompletionRepository;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 12:27
 * @Version 1.0
 */
@Service
public class CompletionDomainService {

    @Resource
    private CompletionRepository completionRepository;
    
    public ChatCO completion(ChatCmd chatCmd) {
        return null;
    }
}
