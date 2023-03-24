package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.image.ImageCO;
import com.szmengran.chatgpt.dto.image.ImageCreateCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmd;
import com.szmengran.cola.dto.SingleResponse;

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
    SingleResponse<ImageCO> createImage(ImageCreateCmd imageCreateCmd);
    
    /** 
     * @description: Creates an edited or extended image given an original image and a prompt.
     * @param imageCreateEditCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/24 18:20
     */
    SingleResponse<ImageCO> createImageEdit(ImageCreateEditCmd imageCreateEditCmd);
    
    /** 
     * @description: Creates a variation of a given image.
     * @param imageCreateVariationCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/24 18:22
     */
    SingleResponse<ImageCO> createImageEdit(ImageCreateVariationCmd imageCreateVariationCmd);
}
