package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.audio.AudioCO;
import com.szmengran.chatgpt.dto.audio.AudioCreateCmd;
import com.szmengran.cola.dto.SingleResponse;

/**
 * 音频转换为文本
 * @Author MaoYuan.Li
 * @Date 2023/3/24 18:26
 * @Version 1.0
 */
public interface AudioFacade {

    SingleResponse<AudioCO> transcription(AudioCreateCmd audioCreateCmd);
    
    SingleResponse<AudioCO> translate(AudioCreateCmd audioCreateCmd);
}
