package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.EditFacade;
import com.szmengran.chatgpt.dto.edit.EditCO;
import com.szmengran.chatgpt.dto.edit.EditCreateCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/24 17:59
 * @Version 1.0
 */
@Tag(name = "edit")
@RestController
public class EditController {
    
    @Resource
    private EditFacade editFacade;
    
    @PostMapping("/v1/edits")
    public SingleResponse<EditCO> edit(@RequestBody EditCreateCmd editCreateCmd) {
        return editFacade.edit(editCreateCmd);
    }
}
