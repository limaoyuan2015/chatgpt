package com.szmengran.chatgpt.wap;

import java.io.IOException;
import java.io.InputStream;

import com.szmengran.chatgpt.api.CompletionFacade;
import com.szmengran.chatgpt.domain.completion.CompletionDomainService;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionDTO;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.SingleResponse;
import feign.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 11:43
 *
 * @Version 1.0
 */
@Tag(name = "completions")
@RestController
public class CompletionController {
    
    @Resource
    private CompletionFacade completionFacade;

    @Resource
    private CompletionDomainService completionDomainService;
    
    @Operation(summary = "Creates a completion for the chat message")
    @PostMapping("/v1/completions")
    public Mono<SingleResponse<CompletionDTO>> completions(@RequestBody CompletionCreateCmd completionCreateCmd) {
        return Mono.just(completionFacade.completions(completionCreateCmd));
    }
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Operation(summary = "Creates a completion for the chat message")
    @PostMapping("/v1/completionsStream")
    public void completionsStream(@RequestBody CompletionCreateCmd completionCreateCmd, HttpServletResponse httpServletResponse) {
        Response response = openAiClient.createCompletionStream(completionCreateCmd);
        try(InputStream inputStream = response.body().asInputStream()) {
            StreamUtils.copy(inputStream, httpServletResponse.getOutputStream());
            httpServletResponse.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/data")
    public Mono<SingleResponse<CompletionDTO>> getData(@RequestBody CompletionCreateCmd completionCreateCmd) {
        return Mono.just(completionFacade.completions(completionCreateCmd));
//        return completionCreateCmd.map(data -> openAiClient.createCompletion(data).toString());
    }
}
