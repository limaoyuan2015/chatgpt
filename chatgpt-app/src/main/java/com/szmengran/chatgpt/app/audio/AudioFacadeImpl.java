package com.szmengran.chatgpt.app.audio;

import com.szmengran.chatgpt.api.AudioFacade;
import com.szmengran.chatgpt.dto.audio.AudioCO;
import com.szmengran.chatgpt.dto.audio.AudioCreateCmd;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 16:32
 * @Version 1.0
 */
@Service
public class AudioFacadeImpl implements AudioFacade {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public SingleResponse<AudioCO> transcription(final AudioCreateCmd audioCreateCmd) {
        AudioCO audioCO = openAiClient.createAudioTranscription(audioCreateCmd);
        return SingleResponse.of(audioCO);
    }
    
    @Override
    public SingleResponse<AudioCO> translate(final AudioCreateCmd audioCreateCmd) {
        AudioCO audioCO = openAiClient.createAudioTranslation(audioCreateCmd);
        return SingleResponse.of(audioCO);
    }
}
