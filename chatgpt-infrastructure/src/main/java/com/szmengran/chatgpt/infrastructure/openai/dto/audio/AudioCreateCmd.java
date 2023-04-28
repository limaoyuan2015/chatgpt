package com.szmengran.chatgpt.infrastructure.openai.dto.audio;

import com.szmengran.cola.dto.Command;
import lombok.Data;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/24 18:41
 * @Version 1.0
 */
@Data
public class AudioCreateCmd extends Command {
    
    private String file;
    private String model;
}
