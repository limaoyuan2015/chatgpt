package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.completion.CompletionDTO;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.cola.dto.SingleResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import reactor.core.publisher.Mono;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 14:12
 * @Version 1.0
 */
public interface CompletionFacade {
    
    /** 
     * @description: Creates a completion for the provided prompt and parameters
     * @param completionCreateCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.completion.CompletionCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/23 14:14
     */
    Mono<SingleResponse<CompletionDTO>> completions(CompletionCreateCmd completionCreateCmd);
}
