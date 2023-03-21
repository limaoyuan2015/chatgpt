package com.szmengran.chatgpt.openai;

import com.szmengran.chatgpt.dto.DeleteResult;
import com.szmengran.chatgpt.dto.OpenAiResponse;
import com.szmengran.chatgpt.dto.completion.CompletionRequest;
import com.szmengran.chatgpt.dto.completion.CompletionResult;
import com.szmengran.chatgpt.dto.completion.chat.ChatCompletionRequest;
import com.szmengran.chatgpt.dto.completion.chat.ChatCompletionResult;
import com.szmengran.chatgpt.dto.edit.EditRequest;
import com.szmengran.chatgpt.dto.edit.EditResult;
import com.szmengran.chatgpt.dto.embedding.EmbeddingRequest;
import com.szmengran.chatgpt.dto.embedding.EmbeddingResult;
import com.szmengran.chatgpt.dto.engine.Engine;
import com.szmengran.chatgpt.dto.file.File;
import com.szmengran.chatgpt.dto.finetune.FineTuneEvent;
import com.szmengran.chatgpt.dto.finetune.FineTuneRequest;
import com.szmengran.chatgpt.dto.finetune.FineTuneResult;
import com.szmengran.chatgpt.dto.image.CreateImageRequest;
import com.szmengran.chatgpt.dto.image.ImageResult;
import com.szmengran.chatgpt.dto.model.Model;
import com.szmengran.chatgpt.dto.moderation.ModerationRequest;
import com.szmengran.chatgpt.dto.moderation.ModerationResult;
import com.szmengran.cola.dto.SingleResponse;
import feign.Param;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="openai", url="https://api.openai.com/")
public interface OpenAiApi {
    
    @Bean
    default RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // 添加拦截器逻辑
                System.out.println("。。。");
            }
        };
    }
    
    @GetMapping("v1/models")
    SingleResponse<SingleResponse<Model>> listModels();

    @GetMapping("/v1/models/{model_id}")
    SingleResponse<Model> getModel(@Param("model_id") String modelId);

    @PostMapping("/v1/completions")
    SingleResponse<CompletionResult> createCompletion(@RequestBody CompletionRequest request);
    
    @PostMapping("/v1/chat/completions")
    SingleResponse<ChatCompletionResult> createChatCompletion(@RequestBody ChatCompletionRequest request);

    @Deprecated
    @PostMapping("/v1/engines/{engine_id}/completions")
    SingleResponse<CompletionResult> createCompletion(@Param("engine_id") String engineId, @RequestBody CompletionRequest request);

    @PostMapping("/v1/edits")
    SingleResponse<EditResult> createEdit(@RequestBody EditRequest request);

    @Deprecated
    @PostMapping("/v1/engines/{engine_id}/edits")
    SingleResponse<EditResult> createEdit(@Param("engine_id") String engineId, @RequestBody EditRequest request);

    @PostMapping("/v1/embeddings")
    SingleResponse<EmbeddingResult> createEmbeddings(@RequestBody EmbeddingRequest request);

    @Deprecated
    @PostMapping("/v1/engines/{engine_id}/embeddings")
    SingleResponse<EmbeddingResult> createEmbeddings(@Param("engine_id") String engineId, @RequestBody EmbeddingRequest request);

    @GetMapping("/v1/files")
    SingleResponse<OpenAiResponse<File>> listFiles();

//    @Multipart
//    @PostMapping("/v1/files")
//    SingleResponse<File> uploadFile(@Param("purpose") RequestBody purpose, @Part MultipartBody.Part file);

    @DeleteMapping("/v1/files/{file_id}")
    SingleResponse<DeleteResult> deleteFile(@Param("file_id") String fileId);

    @GetMapping("/v1/files/{file_id}")
    SingleResponse<File> retrieveFile(@Param("file_id") String fileId);

    @PostMapping("/v1/fine-tunes")
    SingleResponse<FineTuneResult> createFineTune(@RequestBody FineTuneRequest request);

    @PostMapping("/v1/completions")
    SingleResponse<CompletionResult> createFineTuneCompletion(@RequestBody CompletionRequest request);

    @GetMapping("/v1/fine-tunes")
    SingleResponse<OpenAiResponse<FineTuneResult>> listFineTunes();

    @GetMapping("/v1/fine-tunes/{fine_tune_id}")
    SingleResponse<FineTuneResult> retrieveFineTune(@Param("fine_tune_id") String fineTuneId);

    @PostMapping("/v1/fine-tunes/{fine_tune_id}/cancel")
    SingleResponse<FineTuneResult> cancelFineTune(@Param("fine_tune_id") String fineTuneId);

    @GetMapping("/v1/fine-tunes/{fine_tune_id}/events")
    SingleResponse<OpenAiResponse<FineTuneEvent>> listFineTuneEvents(@Param("fine_tune_id") String fineTuneId);

    @DeleteMapping("/v1/models/{fine_tune_id}")
    SingleResponse<DeleteResult> deleteFineTune(@Param("fine_tune_id") String fineTuneId);

    @PostMapping("/v1/images/generations")
    SingleResponse<ImageResult> createImage(@RequestBody CreateImageRequest request);

    @PostMapping("/v1/images/edits")
    SingleResponse<ImageResult> createImageEdit(@RequestBody RequestBody requestBody);

    @PostMapping("/v1/images/variations")
    SingleResponse<ImageResult> createImageVariation(@RequestBody RequestBody requestBody);

    @PostMapping("/v1/moderations")
    SingleResponse<ModerationResult> createModeration(@RequestBody ModerationRequest request);

    @Deprecated
    @GetMapping("v1/engines")
    SingleResponse<OpenAiResponse<Engine>> getEngines();

    @Deprecated
    @GetMapping("/v1/engines/{engine_id}")
    SingleResponse<Engine> getEngine(@Param("engine_id") String engineId);
}
