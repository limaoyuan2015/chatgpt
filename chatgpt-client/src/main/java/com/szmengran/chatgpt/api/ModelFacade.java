package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.model.Model;
import com.szmengran.cola.dto.MultiResponse;
import com.szmengran.cola.dto.SingleResponse;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 18:26
 * @Version 1.0
 */
public interface ModelFacade {
    
    /** 
     * @description: Lists the currently available models, and provides basic information about each one such as the owner and availability.
     * @param  
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.model.Model> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 18:33
     */
    MultiResponse<Model> listModels();
    
    /** 
     * @description: Retrieves a model instance, providing basic information about the model such as the owner and permissioning.
     * @param model 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.model.Model> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 18:35
     */
    SingleResponse<Model> retrieve(String model);
}
