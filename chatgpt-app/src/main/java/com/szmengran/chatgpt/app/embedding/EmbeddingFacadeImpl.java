package com.szmengran.chatgpt.app.embedding;

import com.szmengran.chatgpt.api.EmbeddingFacade;
import com.szmengran.chatgpt.dto.embedding.EmbeddingCO;
import com.szmengran.chatgpt.dto.embedding.EmbeddingCreateCmd;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 16:30
 * @Version 1.0
 */
@Service
public class EmbeddingFacadeImpl implements EmbeddingFacade {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public SingleResponse<EmbeddingCO> create(final EmbeddingCreateCmd embeddingCreateCmd) {
        EmbeddingCO embeddingCO = openAiClient.createEmbeddings(embeddingCreateCmd);
        return SingleResponse.of(embeddingCO);
    }
}
