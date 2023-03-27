package com.szmengran.chatgpt.dto.finetune;

import lombok.Data;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 12:27
 * @Version 1.0
 */
@Data
public class DeleteFineTuneCO {
    private String id;
    private String object;
    private String deleted;
}
