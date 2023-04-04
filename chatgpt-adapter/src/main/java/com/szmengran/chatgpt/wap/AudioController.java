package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.AudioFacade;
import com.szmengran.chatgpt.dto.audio.AudioCO;
import com.szmengran.chatgpt.dto.audio.AudioCreateCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 15:48
 * @Version 1.0
 */
@Tag(name = "audio")
@RestController
public class AudioController {
    
    @Resource
    private AudioFacade audioFacade;
    
    /** 
     * @description: Transcribes audio into the input language.
     * @param model
     * @param file
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.audio.AudioCO>
     * @author MaoYuan.Li
     * @date: 2023/3/27 15:50
     */
    @PostMapping("/v1/audio/transcriptions")
    public SingleResponse<AudioCO> transcription(@RequestParam("model") String model, @RequestParam("file") MultipartFile file) {
        return audioFacade.transcription(model, file);
    }
    
    /** 
     * @description: Translates audio into into English.
     * @param audioCreateCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.audio.AudioCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 16:28
     */
    @PostMapping("/v1/audio/translations")
    public SingleResponse<AudioCO> translate(@RequestBody AudioCreateCmd audioCreateCmd) {
        return audioFacade.translate(audioCreateCmd);
    }
}
