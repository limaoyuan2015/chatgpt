package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.CustomerAddCmd;
import com.szmengran.chatgpt.dto.CustomerListByNameQry;
import com.szmengran.chatgpt.dto.data.CustomerDTO;
import com.szmengran.cola.dto.MultiResponse;
import com.szmengran.cola.dto.Response;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
