package com.szmengran.chatgpt.app.converter;

import com.szmengran.chatgpt.dto.image.ImageCreateEditCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmdV2;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmdV2;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author MaoYuan.Li
 * @Date 2023/4/24 14:54
 * @Version 1.0
 */
@Mapper
public interface Converter {
    
    Converter INSTANCE = Mappers.getMapper(Converter.class);
    
    ImageCreateEditCmd converter(ImageCreateEditCmdV2 imageCreateEditCmdV2);
    ImageCreateVariationCmd converter(ImageCreateVariationCmdV2 imageCreateVariationCmdV2);
}
