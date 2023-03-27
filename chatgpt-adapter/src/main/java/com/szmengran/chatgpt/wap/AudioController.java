package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.AudioFacade;
import com.szmengran.chatgpt.dto.audio.AudioCO;
import com.szmengran.chatgpt.dto.audio.AudioCreateCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param audioCreateCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.audio.AudioCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 15:50
     */
    @PostMapping("/v1/audio/transcriptions")
    public SingleResponse<AudioCO> transcription(AudioCreateCmd audioCreateCmd) {
        return audioFacade.transcription(audioCreateCmd);
    }
    
    /** 
     * @description: Translates audio into into English.
     * @param audioCreateCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.audio.AudioCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 16:28
     */
    @PostMapping("/v1/audio/translations")
    public SingleResponse<AudioCO> translate(AudioCreateCmd audioCreateCmd) {
        return audioFacade.translate(audioCreateCmd);
    }
}
