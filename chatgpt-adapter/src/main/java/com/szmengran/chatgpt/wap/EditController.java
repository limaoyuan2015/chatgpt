package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.dto.edit.EditCO;
import com.szmengran.chatgpt.dto.edit.EditCreateCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/24 17:59
 * @Version 1.0
 */
@Tag(name = "edit")
public class EditController {
    
    
    @GetMapping("/v1/edits")
    public SingleResponse<EditCO> edit(EditCreateCmd editCreateCmd) {
    
    }
}
