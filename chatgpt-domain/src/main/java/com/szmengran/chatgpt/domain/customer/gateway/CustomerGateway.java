package com.szmengran.chatgpt.domain.customer.gateway;

import com.szmengran.chatgpt.domain.customer.Customer;

public interface CustomerGateway {
    Customer getByById(String customerId);
}
