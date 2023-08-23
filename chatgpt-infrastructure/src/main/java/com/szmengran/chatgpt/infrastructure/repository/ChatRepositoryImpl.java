package com.szmengran.chatgpt.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.szmengran.chatgpt.domain.chat.repository.ChatRepository;
import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import com.szmengran.chatgpt.domain.entity.ChatDetail;
import com.szmengran.chatgpt.domain.entity.ChatTitle;
import com.szmengran.chatgpt.domain.utils.IDTypes;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.dto.chat.ChatCreateCmd;
import com.szmengran.chatgpt.dto.chat.ChatMessage;
import com.szmengran.chatgpt.dto.chat.ChatMessageRole;
import com.szmengran.chatgpt.infrastructure.assembler.Assembler;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.chatgpt.infrastructure.repository.mapper.ChatDetailMapper;
import com.szmengran.chatgpt.infrastructure.repository.mapper.ChatTitleMapper;
import com.szmengran.cola.base.utils.IDUtils;
import feign.Response;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.List;

/**
 * @Author MaoYuan.Li
 * @Date 2023/4/27 14:57
 * @Version 1.0
 */
@Repository
public class ChatRepositoryImpl implements ChatRepository {
    
    @Resource
    private ChatTitleMapper chatTitleMapper;
    
    @Resource
    private ChatDetailMapper chatDetailMapper;
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Resource
    private ChatGPTProperties chatGPTProperties;
    
    @Override
    public ChatCO chat(final ChatCmd chatCmd) {
        ChatCreateCmd chatCreateCmd = Assembler.transform(chatCmd, chatGPTProperties);
        ChatCO chatCO = openAiClient.chat(chatCreateCmd);
        String chatDetailId = IDUtils.getSnowId(IDTypes.CHAT_DETAIL);
        chatCO.setChatDetailId(chatDetailId);
        if (StringUtils.isEmpty(chatCmd.getChatId())) {
            String chatId = IDUtils.getSnowId(IDTypes.CHAT_TITLE);
            List<ChatMessage> list = chatCmd.getMessages();
            list.forEach(chatMessage -> {
                if (ChatMessageRole.USER.value().equals(chatMessage.getRole())) {
                    String question = chatMessage.getContent();
                    String title = question.length() > 20 ? question.substring(0, 20) : question;
                    chatCO.setTitle(title);
                }
            });
            chatCO.setChatId(chatId);
        } else {
            chatCO.setChatId(chatCmd.getChatId());
        }

        return chatCO;
    }
    
    @Override
    public Response chatStream(final ChatCmd chatCmd) {
        ChatCreateCmd chatCreateCmd = Assembler.transform(chatCmd, chatGPTProperties);
        return openAiClient.chatStream(chatCreateCmd);
    }
    
    @Override
    public void addChatTitle(final ChatTitle chatTitle) {
        chatTitleMapper.insert(chatTitle);
    }
    
    @Override
    public void addChatDetail(final ChatDetail chatDetail) {
        chatDetailMapper.insert(chatDetail);
    }
    
//    @Override
//    public void save(final String username, final ChatDetail chatDetail) {
//        if (StringUtils.isBlank(chatDetail.getChatId())) {
//            String chatId = IDUtils.getSnowId(IDTypes.CHAT_TITLE);
//            String question = chatDetail.getQuestion();
//            String title = question.length() > 20 ? question.substring(0, 20) : question;
//            ChatTitle chatTitle = ChatTitle.builder().chatId(chatId).username(username).title(title).build();
//            chatTitleMapper.insert(chatTitle);
//        }
//        chatDetailMapper.insert(chatDetail);
//    }
    
    @Override
    public List<ChatTitle> getChatListByUsername(final String username) {
        LambdaQueryWrapper<ChatTitle> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(ChatTitle::getUsername, username);
        return chatTitleMapper.selectList(queryWrapper);
    }
    
    @Override
    public List<ChatDetail> getChatListById(final String chatId) {
        LambdaQueryWrapper<ChatDetail> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(ChatDetail::getChatId, chatId);
        queryWrapper.last("order by create_time desc limit 5");
        return chatDetailMapper.selectList(queryWrapper);
    }
}
