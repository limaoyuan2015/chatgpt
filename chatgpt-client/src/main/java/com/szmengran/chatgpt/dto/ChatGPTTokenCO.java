package com.szmengran.chatgpt.dto;

import com.szmengran.cola.dto.DTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author MaoYuan.Li
 * @Date 2023/10/9 20:36
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPTTokenCO extends DTO {
    
    @Schema(description = "token")
    private String accessToken;
    
    @Schema(description = "授权范围")
    private String scope;
    
    @Schema(description = "授权类型")
    private String tokenType;
    
    @Schema(description = "过期时间")
    private Integer expiresIn;
}
