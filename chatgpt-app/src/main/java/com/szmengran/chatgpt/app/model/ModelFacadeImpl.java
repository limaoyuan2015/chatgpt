package com.szmengran.chatgpt.app.model;

import com.szmengran.chatgpt.api.ModelFacade;
import com.szmengran.chatgpt.dto.OpenAiResponse;
import com.szmengran.chatgpt.dto.model.Model;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.MultiResponse;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 18:35
 * @Version 1.0
 */
@Service
public class ModelFacadeImpl implements ModelFacade {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public MultiResponse<Model> listModels() {
        OpenAiResponse<Model> response = openAiClient.listModels();
        return MultiResponse.of(response.getData());
    }
    
    @Override
    public SingleResponse<Model> retrieve(final String model) {
        Model modelData = openAiClient.retrieve(model);
        return SingleResponse.of(modelData);
    }
}
