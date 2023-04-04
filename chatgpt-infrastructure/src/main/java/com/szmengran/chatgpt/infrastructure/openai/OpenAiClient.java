package com.szmengran.chatgpt.infrastructure.openai;

import com.szmengran.chatgpt.dto.OpenAiResponse;
import com.szmengran.chatgpt.dto.audio.AudioCO;
import com.szmengran.chatgpt.dto.audio.AudioCreateCmd;
import com.szmengran.chatgpt.dto.chat.ChatCompletionCO;
import com.szmengran.chatgpt.dto.chat.ChatCompletionCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionCO;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.chatgpt.dto.edit.EditCO;
import com.szmengran.chatgpt.dto.edit.EditCreateCmd;
import com.szmengran.chatgpt.dto.embedding.EmbeddingCO;
import com.szmengran.chatgpt.dto.embedding.EmbeddingCreateCmd;
import com.szmengran.chatgpt.dto.engine.Engine;
import com.szmengran.chatgpt.dto.file.DeleteFileCO;
import com.szmengran.chatgpt.dto.file.File;
import com.szmengran.chatgpt.dto.finetune.DeleteFineTuneCO;
import com.szmengran.chatgpt.dto.finetune.FineTune;
import com.szmengran.chatgpt.dto.finetune.FineTuneCreateCmd;
import com.szmengran.chatgpt.dto.finetune.FineTuneEvent;
import com.szmengran.chatgpt.dto.image.ImageCO;
import com.szmengran.chatgpt.dto.image.ImageCreateCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmd;
import com.szmengran.chatgpt.dto.model.Model;
import com.szmengran.chatgpt.dto.moderation.ModerationCO;
import com.szmengran.chatgpt.dto.moderation.ModerationQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="openai", url="https://api.openai.com/", configuration = FeignClientConfiguration.class)
public interface OpenAiClient {
    
    @GetMapping("/v1/models")
    OpenAiResponse<Model> listModels();
    
    @GetMapping("/v1/models/{model}")
    Model retrieve(@PathVariable("model") String model);

    @GetMapping("/v1/models/{modelId}")
    Model getModel(@PathVariable("modelId") String modelId);

    @PostMapping(value = "/v1/completions", consumes = "application/json", produces = "application/json")
    CompletionCO createCompletion(@RequestBody CompletionCreateCmd request);
    
    @PostMapping(value = "/v1/chat/completions", consumes = "application/json", produces = "application/json")
    ChatCompletionCO createChatCompletion(@RequestBody ChatCompletionCreateCmd request);

    @PostMapping("/v1/edits")
    EditCO createEdit(@RequestBody EditCreateCmd request);

    @PostMapping("/v1/embeddings")
    EmbeddingCO createEmbeddings(@RequestBody EmbeddingCreateCmd request);
    
    @PostMapping("/v1/audio/translations")
    AudioCO createAudioTranslation(@RequestBody AudioCreateCmd audioCreateCmd);
    
    @GetMapping("/v1/files")
    OpenAiResponse<File> listFiles();

    @DeleteMapping("/v1/files/{fileId}")
    DeleteFileCO deleteFile(@PathVariable("fileId") String fileId);

    @GetMapping("/v1/files/{fileId}")
    File retrieveFile(@PathVariable("fileId") String fileId);

    @PostMapping("/v1/fine-tunes")
    FineTune createFineTune(@RequestBody FineTuneCreateCmd request);

    @PostMapping("/v1/completions")
    CompletionCO createFineTuneCompletion(@RequestBody CompletionCreateCmd request);

    @GetMapping("/v1/fine-tunes")
    OpenAiResponse<FineTune> listFineTunes();

    @GetMapping("/v1/fine-tunes/{fineTuneId}")
    FineTune retrieveFineTune(@PathVariable("fineTuneId") String fineTuneId);

    @PostMapping("/v1/fine-tunes/{fineTuneId}/cancel")
    FineTune cancelFineTune(@PathVariable("fineTuneId") String fineTuneId);

    @GetMapping("/v1/fine-tunes/{fineTuneId}/events")
    OpenAiResponse<FineTuneEvent> listFineTuneEvents(@PathVariable("fineTuneId") String fineTuneId);

    @DeleteMapping("/v1/models/{fineTuneId}")
    DeleteFineTuneCO deleteFineTune(@PathVariable("fineTuneId") String fineTuneId);

    @PostMapping("/v1/images/generations")
    ImageCO createImage(@RequestBody ImageCreateCmd imageCreateCmd);

    @PostMapping("/v1/images/edits")
    ImageCO createImageEdit(@RequestBody ImageCreateEditCmd imageCreateEditCmd);

    @PostMapping("/v1/images/variations")
    ImageCO createImageVariation(@RequestBody ImageCreateVariationCmd imageCreateVariationCmd);

    @PostMapping("/v1/moderations")
    ModerationCO createModeration(@RequestBody ModerationQuery request);

    @Deprecated
    @GetMapping("v1/engines")
    OpenAiResponse<Engine> getEngines();

    @Deprecated
    @GetMapping("/v1/engines/{engineId}")
    Engine getEngine(@PathVariable("engineId") String engineId);
}
