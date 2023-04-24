package com.szmengran.chatgpt.app.image;

import com.szmengran.chatgpt.api.ImageFacade;
import com.szmengran.chatgpt.app.assembler.ImageAssembler;
import com.szmengran.chatgpt.dto.image.ImageCO;
import com.szmengran.chatgpt.dto.image.ImageCreateCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmdV2;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmdV2;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 16:25
 * @Version 1.0
 */
@Service
public class ImageFacadeImpl implements ImageFacade {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public SingleResponse<ImageCO> create(final ImageCreateCmd imageCreateCmd) {
        ImageCO imageCO = openAiClient.createImage(imageCreateCmd);
        return SingleResponse.of(imageCO);
    }
    
    @Override
    public SingleResponse<ImageCO> edit(final ImageCreateEditCmd imageCreateEditCmd) {
        ImageCO imageCO = openAiClient.createImageEdit(imageCreateEditCmd);
        return SingleResponse.of(imageCO);
    }
    
    @Override
    public SingleResponse<ImageCO> editV2(final ImageCreateEditCmdV2 imageCreateEditCmdV2) {
        ImageCreateEditCmd imageCreateEditCmd = ImageAssembler.converter(imageCreateEditCmdV2);
        ImageCO imageCO = openAiClient.createImageEdit(imageCreateEditCmd);
        return SingleResponse.of(imageCO);
    }
    
    @Override
    public SingleResponse<ImageCO> variation(final ImageCreateVariationCmd imageCreateVariationCmd) {
        ImageCO imageCO = openAiClient.createImageVariation(imageCreateVariationCmd);
        return SingleResponse.of(imageCO);
    }
    
    @Override
    public SingleResponse<ImageCO> variationV2(final ImageCreateVariationCmdV2 imageCreateVariationCmdV2) {
        ImageCreateVariationCmd imageCreateVariationCmd = ImageAssembler.converter(imageCreateVariationCmdV2);
        ImageCO imageCO = openAiClient.createImageVariation(imageCreateVariationCmd);
        return SingleResponse.of(imageCO);
    }
}
