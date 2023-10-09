package com.szmengran.chatgpt.api;

import com.szmengran.authorization.dto.TokenCO;
import com.szmengran.authorization.dto.cqe.MiniProgramTokenQueryCmd;
import com.szmengran.authorization.dto.cqe.TokenQueryCmd;
import com.szmengran.cola.dto.Command;
import com.szmengran.cola.dto.Response;

/**
 * @Author MaoYuan.Li
 * @Date 2023/7/24 20:59
 * @Version 1.0
 */
public interface UserService {
    
    /** 
     * @description: 用户登录
     * @param tokenQueryCmd
     * @return: com.szmengran.chatgpt.dto.user.TokenCO 
     * @author MaoYuan.Li
     * @date: 2023/7/24 21:04
     */
    TokenCO login(TokenQueryCmd tokenQueryCmd);
    
    /** 
     * @description: 小程序登录
     * @param tokenQueryCmd 
     * @return: com.szmengran.chatgpt.dto.user.TokenCO 
     * @author MaoYuan.Li
     * @date: 2023/8/1 19:21
     */
    TokenCO miniProgramLogin(MiniProgramTokenQueryCmd tokenQueryCmd);
    
    /** 
     * @description: 用户注册
     * @param command
     * @return: com.szmengran.cola.dto.Response 
     * @author MaoYuan.Li
     * @date: 2023/7/24 21:02
     */
    Response register(Command command);
}
