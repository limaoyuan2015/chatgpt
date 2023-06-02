package com.szmengran.chatgpt.domain.completion;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.szmengran.chatgpt.domain.completion.repository.CompletionRepository;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionDTO;
import com.szmengran.cola.dto.SingleResponse;
import feign.Response;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 12:27
 * @Version 1.0
 */
@Slf4j
@Service
public class CompletionDomainService {

    private final ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newCachedThreadPool());
    
    @Resource
    private CompletionRepository completionRepository;
    
    @SneakyThrows
    public CompletionDTO completions(CompletionCreateCmd completionCreateCmd) {
        return completionRepository.createCompletion(completionCreateCmd);
    }
    
    public void completionsStreams(CompletionCreateCmd completionCreateCmd, HttpServletResponse httpServletResponse) {
        Mono.fromSupplier(() -> {
            try {
                return completionRepository.completionsStream(completionCreateCmd).body().asInputStream();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).subscribe(inputStream -> {
            try {
                StreamUtils.copy(inputStream, httpServletResponse.getOutputStream());
                httpServletResponse.flushBuffer();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
