package com.szmengran.chatgpt.dto.completion;

import com.szmengran.cola.dto.DTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * Object containing a response from the chat completions api.
 */
@Data
@ToString
public class CompletionCOExt extends DTO {
    
    @Schema(name = "问题ID")
    private String completionDetailId;
    
    @Schema(name = "会话ID")
    private String completionId;
    
    @Schema(name = "会话标题")
    private String title;
}
