package com.szmengran.chatgpt.app.complation;

import com.szmengran.chatgpt.api.CompletionFacade;
import com.szmengran.chatgpt.domain.completion.CompletionDomainService;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionDTO;
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
    private CompletionDomainService completionDomainService;
    
    @Override
    public SingleResponse<CompletionDTO> completions(final CompletionCreateCmd completionCreateCmd) {
        return SingleResponse.of(completionDomainService.completions(completionCreateCmd));
    }
}
