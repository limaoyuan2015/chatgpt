package com.szmengran.chatgpt.domain.completion;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.szmengran.chatgpt.domain.completion.repository.CompletionRepository;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionDTO;
import feign.Response;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
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
        Future<CompletionDTO> future = executorService.submit(() -> {
            return completionRepository.createCompletion(completionCreateCmd);
        });
        return future.get();
    }
    
    public void completionsStreams(CompletionCreateCmd completionCreateCmd, HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType("text/event-stream");
        httpServletResponse.setCharacterEncoding("UTF-8");
        executorService.submit(() -> {
            try {
                Response response = completionRepository.completionsStream(completionCreateCmd);
                try(InputStream inputStream = response.body().asInputStream(); OutputStream outputStream = httpServletResponse.getOutputStream()) {
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
