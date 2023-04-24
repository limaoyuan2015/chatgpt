package com.szmengran.chatgpt.app.assembler;

import com.szmengran.chatgpt.app.converter.Converter;
import com.szmengran.chatgpt.domain.utils.FileTransferUtils;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmdV2;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmdV2;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/24 12:06
 * @Version 1.0
 */
public class ImageAssembler {
    
    public static ImageCreateEditCmd converter(ImageCreateEditCmdV2 imageCreateEditCmdV2) {
        ImageCreateEditCmd imageCreateEditCmd = Converter.INSTANCE.converter(imageCreateEditCmdV2);
        if (StringUtils.isNotBlank(imageCreateEditCmdV2.getMaskUrl())) {
            imageCreateEditCmd.setMask(FileTransferUtils.transferToMultipartFile(imageCreateEditCmdV2.getMaskUrl()));
        }
        imageCreateEditCmd.setImage(FileTransferUtils.transferToMultipartFile(imageCreateEditCmdV2.getImageUrl()));
        return imageCreateEditCmd;
    }
    
    public static ImageCreateVariationCmd converter(ImageCreateVariationCmdV2 imageCreateVariationCmdV2) {
        ImageCreateVariationCmd imageCreateVariationCmd = Converter.INSTANCE.converter(imageCreateVariationCmdV2);
        imageCreateVariationCmd.setImage(FileTransferUtils.transferToMultipartFile(imageCreateVariationCmdV2.getImageUrl()));
        return imageCreateVariationCmd;
    }
    
}
