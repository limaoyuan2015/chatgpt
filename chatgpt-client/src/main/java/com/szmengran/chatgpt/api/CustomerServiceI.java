package com.szmengran.chatgpt.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.szmengran.chatgpt.dto.CustomerAddCmd;
import com.szmengran.chatgpt.dto.CustomerListByNameQry;
import com.szmengran.chatgpt.dto.data.CustomerDTO;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
