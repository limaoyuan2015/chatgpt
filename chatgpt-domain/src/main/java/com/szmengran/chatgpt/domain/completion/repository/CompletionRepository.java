package com.szmengran.chatgpt.domain.completion.repository;

import java.util.List;

import com.szmengran.chatgpt.domain.entity.CompletionDetail;
import com.szmengran.chatgpt.domain.entity.CompletionTitle;
import com.szmengran.chatgpt.dto.completion.CompletionCO;
import com.szmengran.chatgpt.dto.completion.CompletionCmd;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import feign.Response;

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
     * @param completionCmd
     * @return: com.szmengran.chatgpt.dto.completion.CompletionDTO 
     * @author MaoYuan.Li
     * @date: 2023/5/17 18:17
     */
    CompletionCO createCompletion(final CompletionCmd completionCmd);

    /**
     * 聊天标题
     * @param completionTitle
     * @Return void
     * @Date: 2023/6/4 16:37
     * @Author: <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
     */ 
    void addCompletionTitle(CompletionTitle completionTitle);

    /**
     * 聊天明细内容
     * @param completionDetail
     * @Return void
     * @Date: 2023/6/3 16:01
     * @Author: <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
     */ 
    void addCompletionDetail(CompletionDetail completionDetail);

    /**
     * 查找用户聊天标题列表
     * @param username
     * @Return java.util.List<com.szmengran.chatgpt.domain.entity.CompletionsTitle>
     * @Date: 2023/6/3 16:01
     * @Author: <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
     */ 
    List<CompletionTitle> getCompletionListByUsername(String username);

    /**
     * 根据ID查找聊天内容
     * @param completionsId
     * @Return java.util.List<com.szmengran.chatgpt.domain.entity.CompletionsDetail>
     * @Date: 2023/6/3 16:01
     * @Author: <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
     */ 
    List<CompletionDetail> getCompletionListById(String completionsId);
}
