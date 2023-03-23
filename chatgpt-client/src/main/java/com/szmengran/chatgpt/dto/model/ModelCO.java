package com.szmengran.chatgpt.dto.model;

import lombok.Data;

import java.util.List;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 14:59
 * @Version 1.0
 */
@Data
public class ModelCO {
    
    private List<Model> data;
    private String object;
    
}
