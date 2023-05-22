package com.szmengran.chatgpt.app.complation;

import com.szmengran.chatgpt.api.CompletionFacade;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionDTO;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 14:14
 * @Version 1.0
 */
@Service
public class CompletionFacadeImpl implements CompletionFacade {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public Mono<SingleResponse<CompletionDTO>> completions(final CompletionCreateCmd completionCreateCmd) {
        return openAiClient.createCompletion2(completionCreateCmd)
                .flatMap(completionDTO -> {
                    return Mono.just(SingleResponse.of(completionDTO));
                });
//        return Mono.create(emitter -> {
//            try {
//                // 调用OpenFeign客户端方法并获取响应结果
//                Mono<CompletionDTO> mono = openAiClient.createCompletion2(completionCreateCmd);
//                mono.subscribe((completionDTO) -> {
//                    // 将结果通过emitter发送给Mono
//                    emitter.success(SingleResponse.of(completionDTO));
//                }, error -> {
//                    emitter.error(error);
//                });
//            } catch (Exception e) {
//                // 发生异常时发送错误信号给Mono
//                emitter.error(e);
//            }
//        });
    }
}
