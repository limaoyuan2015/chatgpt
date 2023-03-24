package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.embedding.EmbeddingCO;
import com.szmengran.chatgpt.dto.embedding.EmbeddingCreateCmd;
import com.szmengran.cola.dto.SingleResponse;

/**
 * Get a vector representation of a given input that can be easily consumed by machine learning models and algorithms.
 * @Author MaoYuan.Li
 * @Date 2023/3/24 18:24
 * @Version 1.0
 */
public interface EmbeddingFacade {
    
    /** 
     * @description: Creates an embedding vector representing the input text.
     * @param embeddingCreateCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.embedding.EmbeddingCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/24 18:41
     */
    SingleResponse<EmbeddingCO> createEmbedding(EmbeddingCreateCmd embeddingCreateCmd);
}
