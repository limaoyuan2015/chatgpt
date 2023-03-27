package com.szmengran.chatgpt.dto.file;

import lombok.Data;

import java.util.List;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 11:50
 * @Version 1.0
 */
@Data
public class FileCO {
    private List<File> data;
    private String object;
}
