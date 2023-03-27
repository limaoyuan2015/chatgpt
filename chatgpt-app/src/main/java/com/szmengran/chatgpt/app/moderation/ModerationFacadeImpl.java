package com.szmengran.chatgpt.app.moderation;

import com.szmengran.chatgpt.api.ModerationFacade;
import com.szmengran.chatgpt.dto.moderation.ModerationCO;
import com.szmengran.chatgpt.dto.moderation.ModerationQuery;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 17:13
 * @Version 1.0
 */
@Service
public class ModerationFacadeImpl implements ModerationFacade {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public SingleResponse<ModerationCO> moderation(final ModerationQuery moderationQuery) {
        ModerationCO moderationCO = openAiClient.createModeration(moderationQuery);
        return SingleResponse.of(moderationCO);
    }
}
