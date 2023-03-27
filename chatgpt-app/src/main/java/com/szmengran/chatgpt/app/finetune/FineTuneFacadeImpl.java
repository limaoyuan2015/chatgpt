package com.szmengran.chatgpt.app.finetune;

import com.szmengran.chatgpt.api.FineTuneFacade;
import com.szmengran.chatgpt.dto.OpenAiResponse;
import com.szmengran.chatgpt.dto.finetune.DeleteFineTuneCO;
import com.szmengran.chatgpt.dto.finetune.FineTune;
import com.szmengran.chatgpt.dto.finetune.FineTuneCreateCmd;
import com.szmengran.chatgpt.dto.finetune.FineTuneEvent;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.MultiResponse;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 16:51
 * @Version 1.0
 */
@Tag(name = "fine tune")
@RestController
public class FineTuneFacadeImpl implements FineTuneFacade {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public SingleResponse<FineTune> create(final FineTuneCreateCmd fineTuneCreateCmd) {
        FineTune fineTune = openAiClient.createFineTune(fineTuneCreateCmd);
        return SingleResponse.of(fineTune);
    }
    
    @Override
    public MultiResponse<FineTune> list() {
        OpenAiResponse<FineTune> response = openAiClient.listFineTunes();
        return MultiResponse.of(response.getData());
    }
    
    @Override
    public SingleResponse<FineTune> retrieve(final String fineTuneId) {
        FineTune fineTune = openAiClient.retrieveFineTune(fineTuneId);
        return SingleResponse.of(fineTune);
    }
    
    @Override
    public SingleResponse<FineTune> cancel(final String fineTuneId) {
        FineTune fineTune = openAiClient.cancelFineTune(fineTuneId);
        return SingleResponse.of(fineTune);
    }
    
    @Override
    public MultiResponse<FineTuneEvent> listEvent(final String fineTuneId) {
        OpenAiResponse<FineTuneEvent> response = openAiClient.listFineTuneEvents(fineTuneId);
        return MultiResponse.of(response.getData());
    }
    
    @Override
    public SingleResponse<DeleteFineTuneCO> delete(final String model) {
        DeleteFineTuneCO deleteFineTuneCO = openAiClient.deleteFineTune(model);
        return SingleResponse.of(deleteFineTuneCO);
    }
}
