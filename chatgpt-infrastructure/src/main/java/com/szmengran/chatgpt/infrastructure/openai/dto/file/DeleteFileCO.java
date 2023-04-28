package com.szmengran.chatgpt.infrastructure.openai.dto.file;

import com.szmengran.cola.dto.DTO;
import lombok.Data;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 11:59
 * @Version 1.0
 */
@Data
public class DeleteFileCO extends DTO {
    private String id;
    private String object;
    private boolean deleted;
}
