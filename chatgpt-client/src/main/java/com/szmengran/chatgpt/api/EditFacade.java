package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.edit.EditCO;
import com.szmengran.chatgpt.dto.edit.EditCreateCmd;
import com.szmengran.cola.dto.SingleResponse;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/24 18:02
 * @Version 1.0
 */
public interface EditFacade {
    
    /** 
     * @description:
     * @param editCreateCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.edit.EditCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/24 18:26
     */
    SingleResponse<EditCO> edit(EditCreateCmd editCreateCmd);
}
