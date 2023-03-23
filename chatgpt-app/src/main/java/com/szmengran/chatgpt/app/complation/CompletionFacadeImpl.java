package com.szmengran.chatgpt.app.complation;

import com.szmengran.chatgpt.api.CompletionFacade;
import com.szmengran.chatgpt.dto.completion.CompletionCO;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 14:14
 * @Version 1.0
 */
@Service
public class CompletionFacadeImpl implements CompletionFacade {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public SingleResponse<CompletionCO> completions(final CompletionCreateCmd completionCreateCmd) {
        CompletionCO completionCO = openAiClient.createCompletion(completionCreateCmd);
        return SingleResponse.of(completionCO);
    }
    
}
