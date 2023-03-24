package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.audio.AudioCO;
import com.szmengran.chatgpt.dto.audio.AudioCreateCmd;
import com.szmengran.cola.dto.SingleResponse;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/24 18:26
 * @Version 1.0
 */
public interface AudioFacade {

    SingleResponse<AudioCO> translation(AudioCreateCmd audioCreateCmd);
}
