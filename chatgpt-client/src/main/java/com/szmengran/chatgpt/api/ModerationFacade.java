package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.moderation.ModerationCO;
import com.szmengran.chatgpt.dto.moderation.ModerationQuery;
import com.szmengran.cola.dto.SingleResponse;

/**
 * Given a input text, outputs if the model classifies it as violating OpenAI's content policy.
 * @Author MaoYuan.Li
 * @Date 2023/3/27 14:26
 * @Version 1.0
 */
public interface ModerationFacade {
    
    /** 
     * @description: Classifies if text violates OpenAI's Content Policy
     * @param moderationQuery 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.moderation.ModerationCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 14:27
     */
    SingleResponse<ModerationCO> moderation(ModerationQuery moderationQuery);
}
