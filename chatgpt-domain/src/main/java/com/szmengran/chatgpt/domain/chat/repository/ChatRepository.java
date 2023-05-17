package com.szmengran.chatgpt.domain.chat.repository;

import com.szmengran.chatgpt.domain.entity.ChatDetail;
import com.szmengran.chatgpt.domain.entity.ChatTitle;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import feign.Response;

import java.util.List;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 14:07
 * @Version 1.0
 */
public interface ChatRepository {
    
    /** 
     * @description: 聊天机器人请求接口
     * @param chatCmd
     * @return: com.szmengran.chatgpt.dto.chat.ChatCO 
     * @author MaoYuan.Li
     * @date: 2023/4/27 17:13
     */
    ChatCO chat(ChatCmd chatCmd);
    
    /** 
     * @description: 聊天机器人请求接口
     * @param chatCmd 
     * @return: feign.Response 
     * @author MaoYuan.Li
     * @date: 2023/5/17 10:54
     */
    Response chatStream(final ChatCmd chatCmd);
    
    void addChatTitle(ChatTitle chatTitle);
    void addChatDetail(ChatDetail chatDetail);
    /**
     * @description: 保存聊天记录
     * @param username
     * @param chatDetail
     * @return: void
     * @author MaoYuan.Li
     * @date: 2023/4/27 16:47
     */
//    void save(String username, ChatDetail chatDetail);
    
    /** 
     * @description: 查找用户聊天标题列表
     * @param username
     * @return: void 
     * @author MaoYuan.Li
     * @date: 2023/4/27 16:49
     */
    List<ChatTitle> getChatListByUsername(String username);
    
    /** 
     * @description: 根据ID查找聊天内容
     * @param chatId 
     * @return: java.util.List<com.szmengran.chatgpt.domain.entity.ChatDetail> 
     * @author MaoYuan.Li
     * @date: 2023/4/27 16:54
     */
    List<ChatDetail> getChatListById(String chatId);
    
}
