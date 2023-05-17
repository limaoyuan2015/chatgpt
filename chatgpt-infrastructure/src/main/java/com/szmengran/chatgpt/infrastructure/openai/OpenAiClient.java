package com.szmengran.chatgpt.infrastructure.openai;

import com.szmengran.chatgpt.dto.OpenAiResponse;
import com.szmengran.chatgpt.dto.audio.AudioCO;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionDTO;
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
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import reactor.core.publisher.Flux;

@FeignClient(name="openai", url="${openai.url}", configuration = FeignClientConfiguration.class)
public interface OpenAiClient {
    
    @GetMapping("/v1/models")
    OpenAiResponse<Model> listModels();
    
    @GetMapping("/v1/models/{model}")
    Model retrieve(@PathVariable("model") String model);

    @GetMapping("/v1/models/{modelId}")
    Model getModel(@PathVariable("modelId") String modelId);

    @PostMapping(value = "/v1/completions", consumes = "application/json", produces = "application/json")
    CompletionDTO createCompletion(@RequestBody CompletionCreateCmd request);
    
    @PostMapping(value = "/v1/completions", consumes = "application/json", produces = "application/json")
    Response createCompletionStream(@RequestBody CompletionCreateCmd request);
    
    @PostMapping(value = "/v1/chat/completions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ChatCO chat(@RequestBody ChatCreateCmd request);

    @PostMapping(value = "/v1/chat/completions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Response chatStream(@RequestBody ChatCreateCmd request);

    @PostMapping("/v1/edits")
    EditCO createEdit(@RequestBody EditCreateCmd request);

    @PostMapping("/v1/embeddings")
    EmbeddingCO createEmbeddings(@RequestBody EmbeddingCreateCmd request);
    
    @PostMapping(value = "/v1/audio/translations", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = "Content-Type=multipart/form-data")
    AudioCO createAudioTranslation(@RequestPart("model") String model, @RequestPart("file") MultipartFile file);
    
    @PostMapping(value = "/v1/audio/transcriptions", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = "Content-Type=multipart/form-data")
    AudioCO createAudioTranscription(@RequestPart("model") String model, @RequestPart("file") MultipartFile file);
    
    @PostMapping(value = "/v1/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = "Content-Type=multipart/form-data")
    File uploadFile(@RequestPart("purpose") String purpose, @RequestPart("file") MultipartFile file);
    
    @GetMapping("/v1/files")
    OpenAiResponse<File> listFiles();

    @DeleteMapping("/v1/files/{fileId}")
    DeleteFileCO deleteFile(@PathVariable("fileId") String fileId);

    @GetMapping("/v1/files/{fileId}")
    File retrieveFile(@PathVariable("fileId") String fileId);

    @PostMapping("/v1/fine-tunes")
    FineTune createFineTune(@RequestBody FineTuneCreateCmd request);

    @PostMapping("/v1/completions")
    CompletionDTO createFineTuneCompletion(@RequestBody CompletionCreateCmd request);

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

    @PostMapping(value = "/v1/images/edits", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = "Content-Type=multipart/form-data")
    ImageCO createImageEdit(@ModelAttribute ImageCreateEditCmd imageCreateEditCmd);

    @PostMapping(value = "/v1/images/variations", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = "Content-Type=multipart/form-data")
    ImageCO createImageVariation(@ModelAttribute ImageCreateVariationCmd imageCreateVariationCmd);

    @PostMapping("/v1/moderations")
    ModerationCO createModeration(@RequestBody ModerationQuery request);

    @Deprecated
    @GetMapping("v1/engines")
    OpenAiResponse<Engine> getEngines();

    @Deprecated
    @GetMapping("/v1/engines/{engineId}")
    Engine getEngine(@PathVariable("engineId") String engineId);
}
