package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.FineTuneFacade;
import com.szmengran.chatgpt.dto.finetune.DeleteFineTuneCO;
import com.szmengran.chatgpt.dto.finetune.FineTune;
import com.szmengran.chatgpt.dto.finetune.FineTuneCO;
import com.szmengran.chatgpt.dto.finetune.FineTuneCreateCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 16:10
 * @Version 1.0
 */
@Tag(name = "file tunes")
@RestController
public class FineTuneController {

    @Resource
    private FineTuneFacade fineTuneFacade;
    
    /** 
     * @description: Creates a job that fine-tunes a specified model from a given dataset.
     * @param fineTuneCreateCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.FineTuneCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 16:14
     */
    @PostMapping("/v1/fine-tunes")
    public SingleResponse<FineTune> create(FineTuneCreateCmd fineTuneCreateCmd) {
        return fineTuneFacade.create(fineTuneCreateCmd);
    }
    
    /**
     * @description: List your organization's fine-tuning jobs
     * @param
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.FineTuneCO>
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:23
     */
    @GetMapping("/v1/fine-tunes")
    public SingleResponse<FineTuneCO> list() {
        return fineTuneFacade.list();
    }
    
    /**
     * @description: Gets info about the fine-tune job.
     * @param fineTuneId
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.FineTune>
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:24
     */
    @GetMapping("/v1/fine-tunes/{fine_tune_id}")
    public SingleResponse<FineTune> retrieve(@PathVariable("fineTuneId") String fineTuneId) {
        return fineTuneFacade.retrieve(fineTuneId);
    }
    
    /**
     * @description: Immediately cancel a fine-tune job.
     * @param fineTuneId
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.FineTune>
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:26
     */
    @PostMapping("/v1/fine-tunes/{fine_tune_id}/cancel")
    public SingleResponse<FineTune> cancel(@PathVariable("fineTuneId") String fineTuneId) {
        return fineTuneFacade.cancel(fineTuneId);
    }
    
    /**
     * @description: Get fine-grained status updates for a fine-tune job.
     * @param fineTuneId
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.FineTuneCO>
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:27
     */
    @GetMapping("/v1/fine-tunes/{fine_tune_id}/events")
    public SingleResponse<FineTuneCO> listEvent(@PathVariable("fineTuneId") String fineTuneId) {
        return fineTuneFacade.listEvent(fineTuneId);
    }
    
    /**
     * @description: Delete a fine-tuned model. You must have the Owner role in your organization.
     * @param model
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.DeleteFineTuneCO>
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:29
     */
    @DeleteMapping("/v1/models/{model}")
    public SingleResponse<DeleteFineTuneCO> delete(@PathVariable("model") String model) {
        return fineTuneFacade.delete(model);
    }
}
