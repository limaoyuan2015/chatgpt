package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.CompletionFacade;
import com.szmengran.chatgpt.dto.completion.CompletionDTO;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 11:43
 *
 * @Version 1.0
 */
@Tag(name = "completions")
@RestController
public class CompletionController {
    
    @Resource
    private CompletionFacade completionFacade;
    
    @Operation(summary = "Creates a completion for the chat message")
    @PostMapping("/v1/completions")
    public SingleResponse<CompletionDTO> completions(@RequestBody CompletionCreateCmd completionCreateCmd) {
        return completionFacade.completions(completionCreateCmd);
    }
}
