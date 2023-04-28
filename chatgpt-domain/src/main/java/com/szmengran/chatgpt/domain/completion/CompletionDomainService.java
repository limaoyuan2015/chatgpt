package com.szmengran.chatgpt.domain.completion;

import com.szmengran.chatgpt.domain.chat.dto.ChatCO;
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
    private CompletionDomainService completionDomainService;

    public ChatCO chatCompletion(ChatCmd chatCmd) {
        return null;
    }
}
