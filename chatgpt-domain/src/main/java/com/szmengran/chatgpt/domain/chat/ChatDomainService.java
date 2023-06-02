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
import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import com.szmengran.chatgpt.domain.entity.ChatDetail;
import com.szmengran.chatgpt.domain.entity.ChatTitle;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import feign.Response;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import reactor.core.publisher.Mono;

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

    @Resource
    private ChatGPTProperties chatGPTProperties;

    @SneakyThrows
    public ChatCO chat(ChatCmd chatCmd) {
        Assembler.converter(chatCmd, chatGPTProperties);
        ChatCO chatCO = chatRepository.chat(chatCmd);
        ChatDetail chatDetail = Assembler.toChatDetail(chatCmd, chatCO);
        chatRepository.addChatDetail(chatDetail);
        if (StringUtils.isBlank(chatCmd.getChatId())) {
            ChatTitle chatTitle = Assembler.toChatTitle(chatCmd, chatCO);
            chatRepository.addChatTitle(chatTitle);
        }
        return chatCO;
    }

    public void chatStream(ChatCmd chatCmd, HttpServletResponse httpServletResponse) {
        Mono.fromSupplier(() -> {
            try {
                return chatRepository.chatStream(chatCmd).body().asInputStream();
            }
            catch (IOException e) {
                log.error("IOException:", e);
                throw new RuntimeException(e);
            }
        }).subscribe(inputStream -> {
            try {
                StreamUtils.copy(inputStream, httpServletResponse.getOutputStream());
                httpServletResponse.flushBuffer();
            }
            catch (IOException e) {
                log.error("IOException:", e);
            }
        });
    }
}
