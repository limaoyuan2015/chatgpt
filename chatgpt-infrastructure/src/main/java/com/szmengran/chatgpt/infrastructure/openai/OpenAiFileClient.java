package com.szmengran.chatgpt.infrastructure.openai;

import com.szmengran.chatgpt.dto.audio.AudioCO;
import com.szmengran.chatgpt.dto.file.File;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name="openaiFile", url="https://api.openai.com/", configuration = FeignClientFileConfiguration.class)
public interface OpenAiFileClient {
    
    @PostMapping(value = "/v1/audio/transcriptions", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = "Content-Type=multipart/form-data")
    AudioCO createAudioTranscription(@RequestPart("model") String model, @RequestPart("file") MultipartFile file);

    @PostMapping(value = "/v1/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = "Content-Type=multipart/form-data")
    File uploadFile(@RequestPart("Content-Type") String contentType, @RequestPart("purpose") String purpose, @RequestPart MultipartFile file);

}
