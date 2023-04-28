package com.szmengran.chatgpt.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.szmengran.base.utils.IDUtils;
import com.szmengran.chatgpt.domain.chat.repository.ChatRepository;
import com.szmengran.chatgpt.domain.entity.ChatDetail;
import com.szmengran.chatgpt.domain.entity.ChatTitle;
import com.szmengran.chatgpt.domain.utils.IDTypes;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.dto.chat.ChatDTO;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.chatgpt.infrastructure.openai.dto.Usage;
import com.szmengran.chatgpt.infrastructure.openai.dto.chat.ChatCO;
import com.szmengran.chatgpt.infrastructure.openai.dto.chat.ChatChoice;
import com.szmengran.chatgpt.infrastructure.repository.mapper.ChatDetailMapper;
import com.szmengran.chatgpt.infrastructure.repository.mapper.ChatTitleMapper;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    
    @Override
    public ChatDTO chat(final ChatCmd chatCmd) {
        ChatCO chatCO = openAiClient.createChat(chatCmd);
        List<ChatChoice> list = Optional.of(chatCO).get().getChoices();
        ChatChoice chatChoice = Optional.of(list).get().get(0);
        Usage usage = Optional.of(chatCO).get().getUsage();

        String chatDetailId = IDUtils.getSnowId(IDTypes.CHAT_DETAIL);
        ChatDTO chatDTO = ChatDTO.builder().chatDetailId(chatDetailId).answer(chatChoice.getMessage().getContent()).promptTokens(usage.getPromptTokens()).completionTokens(usage.getCompletionTokens()).totalTokens(usage.getTotalTokens()).build();
        if (StringUtils.isBlank(chatCmd.getChatId())) {
            String chatId = IDUtils.getSnowId(IDTypes.CHAT_TITLE);
            String question = chatCmd.getQuestion();
            String title = question.length() > 20 ? question.substring(0, 20) : question;
            chatDTO.setChatId(chatId);
            chatDTO.setTitle(title);
        }

        return chatDTO;
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
        return chatDetailMapper.selectList(queryWrapper);
    }
}
