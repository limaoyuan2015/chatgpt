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

    /**
     * @description: Transcribes audio into the input language.
     * @param model
     * @param file
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.audio.AudioCO>
     * @author MaoYuan.Li
     * @date: 2023/4/4 14:21
     */
    SingleResponse<AudioCO> transcription(String model, MultipartFile file);
    
    /** 
     * @description: Translates audio into into English.
     * @param model
     * @param file
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.audio.AudioCO> 
     * @author MaoYuan.Li
     * @date: 2023/4/4 14:21
     */
    SingleResponse<AudioCO> translate(String model, MultipartFile file);
}
