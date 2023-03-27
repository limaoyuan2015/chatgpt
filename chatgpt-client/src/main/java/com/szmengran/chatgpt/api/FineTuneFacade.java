package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.finetune.DeleteFineTuneCO;
import com.szmengran.chatgpt.dto.finetune.FineTune;
import com.szmengran.chatgpt.dto.finetune.FineTuneCreateCmd;
import com.szmengran.chatgpt.dto.finetune.FineTuneEvent;
import com.szmengran.cola.dto.MultiResponse;
import com.szmengran.cola.dto.SingleResponse;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 12:18
 * @Version 1.0
 */
public interface FineTuneFacade {

    /** 
     * @description: Creates a job that fine-tunes a specified model from a given dataset.
     * @param fineTuneCreateCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.FineTuneCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:20
     */
    SingleResponse<FineTune> create(FineTuneCreateCmd fineTuneCreateCmd);
    
    /**
     * @param
     * @description: List your organization's fine-tuning jobs
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.FineTuneCO>
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:23
     */
    MultiResponse<FineTune> list();
    
    /** 
     * @description: Gets info about the fine-tune job.
     * @param fineTuneId 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.FineTune> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:24
     */
    SingleResponse<FineTune> retrieve(String fineTuneId);
    
    /** 
     * @description: Immediately cancel a fine-tune job.
     * @param fineTuneId 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.FineTune> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:26
     */
    SingleResponse<FineTune> cancel(String fineTuneId);
    
    /**
     * @param fineTuneId
     * @description: Get fine-grained status updates for a fine-tune job.
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.FineTuneCO>
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:27
     */
    MultiResponse<FineTuneEvent> listEvent(String fineTuneId);
    
    /** 
     * @description: Delete a fine-tuned model. You must have the Owner role in your organization.
     * @param model 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.finetune.DeleteFineTuneCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:29
     */
    SingleResponse<DeleteFineTuneCO> delete(String model);
    
}
