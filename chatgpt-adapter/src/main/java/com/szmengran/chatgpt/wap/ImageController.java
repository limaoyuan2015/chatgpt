package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.ImageFacade;
import com.szmengran.chatgpt.dto.image.ImageCO;
import com.szmengran.chatgpt.dto.image.ImageCreateCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmd;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 14:37
 * @Version 1.0
 */
@Tag(name = "image")
@RestController
public class ImageController {
    
    @Resource
    private ImageFacade imageFacade;
    
    /** 
     * @description: Creates an image given a prompt.
     * @param imageCreateCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 14:40
     */
    @PostMapping("/v1/images/generations")
    public SingleResponse<ImageCO> generate(ImageCreateCmd imageCreateCmd) {
        return imageFacade.create(imageCreateCmd);
    }
    
    /** 
     * @description: Creates an edited or extended image given an original image and a prompt.
     * @param imageCreateEditCmd
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 15:26
     */
    @PostMapping("/v1/images/edits")
    public SingleResponse<ImageCO> edit(ImageCreateEditCmd imageCreateEditCmd) {
        return imageFacade.edit(imageCreateEditCmd);
    }
    
    /** 
     * @description: Creates a variation of a given image.
     * @param imageCreateVariationCmd 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 16:14
     */
    @PostMapping("/v1/images/variations")
    public SingleResponse<ImageCO> variation(ImageCreateVariationCmd imageCreateVariationCmd) {
        return imageFacade.variation(imageCreateVariationCmd);
    }
}
