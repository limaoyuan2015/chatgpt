package com.szmengran.chatgpt.domain.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.szmengran.chatgpt.domain.assembler.Assembler;
import com.szmengran.chatgpt.domain.chat.repository.ChatRepository;
import com.szmengran.chatgpt.domain.entity.ChatDetail;
import com.szmengran.chatgpt.domain.entity.ChatTitle;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import feign.Response;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 12:27
 * @Version 1.0
 */
@Slf4j
@Service
public class ChatDomainService {

    private final ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newCachedThreadPool());
    
    @Resource
    private ChatRepository chatRepository;

    @SneakyThrows
    public ChatCO chat(ChatCmd chatCmd) {
        Future<ChatCO> future = executorService.submit(() -> {
            ChatCO chatCO = chatRepository.chat(chatCmd);
            ChatDetail chatDetail = Assembler.toChatDetail(chatCmd, chatCO);
            chatRepository.addChatDetail(chatDetail);
            if (StringUtils.isBlank(chatCmd.getChatId())) {
                ChatTitle chatTitle = Assembler.toChatTitle(chatCmd, chatCO);
                chatRepository.addChatTitle(chatTitle);
            }
            return chatCO;
        });
        return future.get();
    }
    
    public void chatStream(ChatCmd chatCmd, HttpServletResponse httpServletResponse) {
        executorService.submit(() -> {
            try {
                Response response = chatRepository.chatStream(chatCmd);
                try (InputStream inputStream = response.body().asInputStream(); OutputStream outputStream = httpServletResponse.getOutputStream()) {
                    StreamUtils.copy(inputStream, outputStream);
                    httpServletResponse.flushBuffer();
                } catch (IOException e) {
                    log.error("io exception:{}", e);
                }
            } catch (Exception e) {
                log.error("chat stream exception:{}", e);
            }
        });
    }
}
