package com.szmengran.chatgpt.domain.customer.gateway;

import com.szmengran.chatgpt.domain.customer.Credit;

//Assume that the credit info is in another distributed Service
public interface CreditGateway {
    Credit getCredit(String customerId);
}
