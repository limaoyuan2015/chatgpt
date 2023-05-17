package com.szmengran.chatgpt.domain.completion.repository;

import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionDTO;
import feign.Response;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 14:07
 * @Version 1.0
 */
public interface CompletionRepository {
    
    /** 
     * @description: 实现文章写作、翻译、代码自动补全等功能
     * @param completionCreateCmd 
     * @return: feign.Response 
     * @author MaoYuan.Li
     * @date: 2023/5/17 12:14
     */
    Response completionsStream(final CompletionCreateCmd completionCreateCmd);
    
    /** 
     * @description: 实现文章写作、翻译、代码自动补全等功能
     * @param completionCreateCmd
     * @return: com.szmengran.chatgpt.dto.completion.CompletionDTO 
     * @author MaoYuan.Li
     * @date: 2023/5/17 18:17
     */
    CompletionDTO createCompletion(final CompletionCreateCmd completionCreateCmd);
}
