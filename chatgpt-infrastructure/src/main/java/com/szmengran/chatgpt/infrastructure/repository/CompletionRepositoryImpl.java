package com.szmengran.chatgpt.infrastructure.repository;

import com.szmengran.chatgpt.domain.completion.repository.CompletionRepository;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionDTO;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import feign.Response;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * @Author MaoYuan.Li
 * @Date 2023/5/4 16:18
 * @Version 1.0
 */
@Repository
public class CompletionRepositoryImpl implements CompletionRepository {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public Response completionsStream(final CompletionCreateCmd completionCreateCmd) {
        return openAiClient.createCompletionStream(completionCreateCmd);
    }
    
    @Override
    public CompletionDTO createCompletion(final CompletionCreateCmd completionCreateCmd) {
        return openAiClient.createCompletion(completionCreateCmd);
    }
}
