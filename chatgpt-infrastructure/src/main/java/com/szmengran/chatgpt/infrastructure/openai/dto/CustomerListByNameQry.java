package com.szmengran.chatgpt.infrastructure.openai.dto;

import lombok.Data;

import javax.management.Query;

@Data
public class CustomerListByNameQry extends Query {
   private String name;
}
