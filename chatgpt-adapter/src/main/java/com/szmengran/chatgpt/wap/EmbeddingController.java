package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.EmbeddingFacade;
import com.szmengran.chatgpt.dto.embedding.EmbeddingCO;
import com.szmengran.chatgpt.dto.embedding.EmbeddingCreateCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 15:45
 * @Version 1.0
 */
@Tag(name = "embeddings")
@RestController
public class EmbeddingController {

    @Resource
    private EmbeddingFacade embeddingFacade;
    
    @PostMapping("/v1/embeddings")
    public SingleResponse<EmbeddingCO> create(EmbeddingCreateCmd embeddingCreateCmd) {
        return embeddingFacade.create(embeddingCreateCmd);
    }
}
