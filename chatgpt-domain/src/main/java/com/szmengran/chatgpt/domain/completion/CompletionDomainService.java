package com.szmengran.chatgpt.domain.completion;

import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.szmengran.chatgpt.domain.assembler.Assembler;
import com.szmengran.chatgpt.domain.completion.repository.CompletionRepository;
import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import com.szmengran.chatgpt.domain.entity.CompletionDetail;
import com.szmengran.chatgpt.domain.entity.CompletionTitle;
import com.szmengran.chatgpt.dto.completion.CompletionCO;
import com.szmengran.chatgpt.dto.completion.CompletionCmd;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StreamUtils;

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

    @Resource
    private ChatGPTProperties chatGPTProperties;
    
    @SneakyThrows
    public CompletionCO completions(CompletionCmd completionCmd) {
        Assembler.converter(completionCmd, chatGPTProperties);
        String question = completionCmd.getPrompt();
        setChatContext(completionCmd);
        CompletionCO completionCO = completionRepository.createCompletion(completionCmd);
        completionCmd.setPrompt(question);
        CompletionDetail completionDetail = Assembler.toCompletionDetail(completionCmd, completionCO);
        completionRepository.addCompletionDetail(completionDetail);
        if (StringUtils.isBlank(completionCmd.getCompletionId())) {
            CompletionTitle completionTitle = Assembler.toCompletionTitle(completionCmd, completionCO);
            completionRepository.addCompletionTitle(completionTitle);
        }
        return completionRepository.createCompletion(completionCmd);
    }

    private void setChatContext(CompletionCmd completionCmd) {
        if (StringUtils.isBlank(completionCmd.getCompletionId())) {
            return ;
        }
        List<CompletionDetail> list = completionRepository.getCompletionListById(completionCmd.getCompletionId());
        Stack<CompletionDetail> stack = new Stack<>();
        list.forEach(item -> {
            stack.push(item);
        });
        StringBuffer stringBuffer = new StringBuffer();
        stack.forEach(item -> {
            stringBuffer.append(item.getQuestion()).append("\n").append(item.getAnswer()).append("\n");
        });
        String question = completionCmd.getPrompt();
        Assert.notNull(question, "question can't be null");
        completionCmd.setPrompt(stringBuffer.append(question).toString());
    }

    public void completionsStreams(CompletionCreateCmd completionCreateCmd, HttpServletResponse httpServletResponse) {
        Mono.fromSupplier(() -> {
            try {
                return completionRepository.completionsStream(completionCreateCmd).body().asInputStream();
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
