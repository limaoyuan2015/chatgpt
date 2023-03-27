package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.ModerationFacade;
import com.szmengran.chatgpt.dto.moderation.ModerationCO;
import com.szmengran.chatgpt.dto.moderation.ModerationQuery;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 16:20
 * @Version 1.0
 */
@Tag(name = "moderations")
@RestController
public class ModerationController {

    @Resource
    private ModerationFacade moderationFacade;
    
    /**
     * @description: Classifies if text violates OpenAI's Content Policy
     * @param moderationQuery
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.moderation.ModerationCO>
     * @author MaoYuan.Li
     * @date: 2023/3/27 14:27
     */
    @PostMapping("/v1/moderations")
    public SingleResponse<ModerationCO> moderation(@RequestBody ModerationQuery moderationQuery) {
        return moderationFacade.moderation(moderationQuery);
    }
    
}
