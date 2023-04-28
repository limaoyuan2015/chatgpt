package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.image.ImageCO;
import com.szmengran.chatgpt.dto.image.ImageCreateCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmdV2;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmdV2;
import com.szmengran.cola.dto.SingleResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/24 18:14
 * @Version 1.0
 */
public interface ImageFacade {
    
    /** 
     * @description: Creates an image given a prompt.
     * @param imageCreateCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/24 18:18
     */
    SingleResponse<ImageCO> create(ImageCreateCmd imageCreateCmd);
    
    /** 
     * @description: Creates an edited or extended image given an original image and a prompt.
     * @param imageCreateEditCmd
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO>
     * @author MaoYuan.Li
     * @date: 2023/3/24 18:20
     */
    SingleResponse<ImageCO> edit(ImageCreateEditCmd imageCreateEditCmd);
    
    /** 
     * @description: Creates an edited or extended image given an original image and a prompt.
     * @param imageCreateEditCmdV2 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/4/24 14:56
     */
    SingleResponse<ImageCO> editV2(ImageCreateEditCmdV2 imageCreateEditCmdV2);
    
    /**
     * @description: Creates a variation of a given image.
     * @param imageCreateVariationCmd
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO>
     * @author MaoYuan.Li
     * @date: 2023/4/4 14:11
     */
    SingleResponse<ImageCO> variation(ImageCreateVariationCmd imageCreateVariationCmd);
    
    /** 
     * @description: Creates a variation of a given image.
     * @param imageCreateVariationCmdV2 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/4/26 19:03
     */
    SingleResponse<ImageCO> variationV2(ImageCreateVariationCmdV2 imageCreateVariationCmdV2);
}
