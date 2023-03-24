package com.szmengran.chatgpt.app.edit;

import com.szmengran.chatgpt.api.EditFacade;
import com.szmengran.chatgpt.dto.edit.EditCO;
import com.szmengran.chatgpt.dto.edit.EditCreateCmd;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/24 18:08
 * @Version 1.0
 */
@Service
public class EditFacadeImpl implements EditFacade {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public SingleResponse<EditCO> edit(final EditCreateCmd editCreateCmd) {
        EditCO editCO = openAiClient.createEdit(editCreateCmd);
        return SingleResponse.of(editCO);
    }
}
