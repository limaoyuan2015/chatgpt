package com.szmengran.chatgpt.app.finetune;

import com.szmengran.chatgpt.api.FineTuneFacade;
import com.szmengran.chatgpt.dto.finetune.DeleteFineTuneCO;
import com.szmengran.chatgpt.dto.finetune.FineTune;
import com.szmengran.chatgpt.dto.finetune.FineTuneCO;
import com.szmengran.chatgpt.dto.finetune.FineTuneCreateCmd;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
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
    public SingleResponse<FineTuneCO> list() {
        FineTuneCO fineTuneCO = openAiClient.listFineTunes();
        return SingleResponse.of(fineTuneCO);
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
    public SingleResponse<FineTuneCO> listEvent(final String fineTuneId) {
        FineTuneCO fineTuneCO = openAiClient.listFineTuneEvents(fineTuneId);
        return SingleResponse.of(fineTuneCO);
    }
    
    @Override
    public SingleResponse<DeleteFineTuneCO> delete(final String model) {
        DeleteFineTuneCO deleteFineTuneCO = openAiClient.deleteFineTune(model);
        return SingleResponse.of(deleteFineTuneCO);
    }
}
