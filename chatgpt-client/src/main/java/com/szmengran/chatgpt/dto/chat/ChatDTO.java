package com.szmengran.chatgpt.dto.chat;

import com.szmengran.cola.dto.DTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Object containing a response from the chat completions api.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ChatDTO extends DTO {
    
    @Schema(name = "问题ID")
    private String chatDetailId;
    
    @Schema(name = "会话ID")
    private String chatId;
    
    @Schema(name = "会话标题")
    private String title;
    
    @Schema(name = "应答内容")
    private String answer;
    
    @Schema(name = "提问消耗的token")
    Integer promptTokens;
    
    @Schema(name = "应答消耗的token")
    Integer completionTokens;
    
    @Schema(name = "总共消耗的token")
    Integer totalTokens;
}
