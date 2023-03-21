package com.szmengran.chatgpt.dto.data;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Data
public class CustomerDTO{
    private String customerId;
    private String memberId;
    private String customerName;
    private String customerType;
    @NotEmpty
    private String companyName;
    @NotEmpty
    private String source;
}
