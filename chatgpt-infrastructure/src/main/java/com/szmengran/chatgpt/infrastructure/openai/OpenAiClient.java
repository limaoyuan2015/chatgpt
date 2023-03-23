package com.szmengran.chatgpt.infrastructure.openai;

import com.szmengran.chatgpt.dto.DeleteCO;
import com.szmengran.chatgpt.dto.OpenAiResponse;
import com.szmengran.chatgpt.dto.chat.ChatCompletionCO;
import com.szmengran.chatgpt.dto.chat.ChatCompletionCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionCO;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.chatgpt.dto.edit.EditCO;
import com.szmengran.chatgpt.dto.edit.EditCreateCmd;
import com.szmengran.chatgpt.dto.embedding.EmbeddingCreateCmd;
import com.szmengran.chatgpt.dto.embedding.EmbeddingResult;
import com.szmengran.chatgpt.dto.engine.Engine;
import com.szmengran.chatgpt.dto.file.File;
import com.szmengran.chatgpt.dto.finetune.FineTuneEvent;
import com.szmengran.chatgpt.dto.finetune.FineTuneRequest;
import com.szmengran.chatgpt.dto.finetune.FineTuneResult;
import com.szmengran.chatgpt.dto.image.CreateImageRequest;
import com.szmengran.chatgpt.dto.image.ImageResult;
import com.szmengran.chatgpt.dto.model.Model;
import com.szmengran.chatgpt.dto.model.ModelCO;
import com.szmengran.chatgpt.dto.moderation.ModerationRequest;
import com.szmengran.chatgpt.dto.moderation.ModerationResult;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name="openai", url="https://api.openai.com/", configuration = FeignClientConfiguration.class)
public interface OpenAiClient {
    
    @GetMapping("v1/models")
    ModelCO listModels();

    @GetMapping("/v1/models/{modelId}")
    Model getModel(@Param("modelId") String modelId);

    @PostMapping("/v1/completions")
    CompletionCO createCompletion(@RequestBody CompletionCreateCmd request);
    
    @PostMapping("/v1/chat/completions")
    ChatCompletionCO createChatCompletion(@RequestBody ChatCompletionCreateCmd request);

    @PostMapping("/v1/edits")
    EditCO createEdit(@RequestBody EditCreateCmd request);

    @PostMapping("/v1/embeddings")
    EmbeddingResult createEmbeddings(@RequestBody EmbeddingCreateCmd request);

    @GetMapping("/v1/files")
    OpenAiResponse<File> listFiles();

    @PostMapping("/v1/files")
    File uploadFile(@Param("purpose") RequestBody purpose, @RequestPart MultipartFile file);

    @DeleteMapping("/v1/files/{fileId}")
    DeleteCO deleteFile(@Param("fileId") String fileId);

    @GetMapping("/v1/files/{fileId}")
    File retrieveFile(@Param("fileId") String fileId);

    @PostMapping("/v1/fine-tunes")
    FineTuneResult createFineTune(@RequestBody FineTuneRequest request);

    @PostMapping("/v1/completions")
    CompletionCO createFineTuneCompletion(@RequestBody CompletionCreateCmd request);

    @GetMapping("/v1/fine-tunes")
    OpenAiResponse<FineTuneResult> listFineTunes();

    @GetMapping("/v1/fine-tunes/{fineTuneId}")
    FineTuneResult retrieveFineTune(@Param("fineTuneId") String fineTuneId);

    @PostMapping("/v1/fine-tunes/{fineTuneId}/cancel")
    FineTuneResult cancelFineTune(@Param("fineTuneId") String fineTuneId);

    @GetMapping("/v1/fine-tunes/{fineTuneId}/events")
    OpenAiResponse<FineTuneEvent> listFineTuneEvents(@Param("fineTuneId") String fineTuneId);

    @DeleteMapping("/v1/models/{fineTuneId}")
    DeleteCO deleteFineTune(@Param("fineTuneId") String fineTuneId);

    @PostMapping("/v1/images/generations")
    ImageResult createImage(@RequestBody CreateImageRequest request);

    @PostMapping("/v1/images/edits")
    ImageResult createImageEdit(@RequestBody RequestBody requestBody);

    @PostMapping("/v1/images/variations")
    ImageResult createImageVariation(@RequestBody RequestBody requestBody);

    @PostMapping("/v1/moderations")
    ModerationResult createModeration(@RequestBody ModerationRequest request);

    @Deprecated
    @GetMapping("v1/engines")
    OpenAiResponse<Engine> getEngines();

    @Deprecated
    @GetMapping("/v1/engines/{engineId}")
    Engine getEngine(@Param("engineId") String engineId);
}
