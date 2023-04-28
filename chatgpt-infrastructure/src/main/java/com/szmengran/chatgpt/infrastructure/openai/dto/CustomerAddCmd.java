package com.szmengran.chatgpt.infrastructure.openai.dto;

import com.szmengran.chatgpt.infrastructure.openai.dto.data.CustomerDTO;
import lombok.Data;

@Data
public class CustomerAddCmd{

    private CustomerDTO customerDTO;

}
