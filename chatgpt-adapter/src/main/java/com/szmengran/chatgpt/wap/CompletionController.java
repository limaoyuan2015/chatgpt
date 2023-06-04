package com.szmengran.chatgpt.wap;

import java.security.Principal;

import com.szmengran.chatgpt.domain.completion.CompletionDomainService;
import com.szmengran.chatgpt.dto.completion.CompletionCO;
import com.szmengran.chatgpt.dto.completion.CompletionCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
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
    private CompletionDomainService completionDomainService;
    
    @Operation(summary = "Creates a completion for the chat message")
    @PostMapping("/v1/completions")
    public Mono<SingleResponse<CompletionCO>> completions(@RequestBody CompletionCmd completionCmd, Principal principal) {
        completionCmd.setUsername(principal.getName());
        return Mono.just(SingleResponse.of(completionDomainService.completions(completionCmd)));
    }


    @Operation(summary = "Creates a completion for the chat message")
    @PostMapping(value = "/v1/completionsStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public void completionsStreams(HttpServletResponse httpServletResponse, @RequestBody CompletionCmd completionCmd, Principal principal) {
        completionCmd.setUsername(principal.getName());
        completionDomainService.completionsStreams(completionCmd, httpServletResponse);
    }
}
