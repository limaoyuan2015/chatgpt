package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.audio.AudioCO;
import com.szmengran.chatgpt.dto.audio.AudioCreateCmd;
import com.szmengran.cola.dto.SingleResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * 音频转换为文本
 * @Author MaoYuan.Li
 * @Date 2023/3/24 18:26
 * @Version 1.0
 */
public interface AudioFacade {

    SingleResponse<AudioCO> transcription(String model, MultipartFile file);
    
    SingleResponse<AudioCO> translate(AudioCreateCmd audioCreateCmd);
}
