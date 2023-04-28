package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.ImageFacade;
import com.szmengran.chatgpt.dto.image.ImageCO;
import com.szmengran.chatgpt.dto.image.ImageCreateCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateEditCmdV2;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmd;
import com.szmengran.chatgpt.dto.image.ImageCreateVariationCmdV2;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public SingleResponse<ImageCO> generate(@RequestBody ImageCreateCmd imageCreateCmd) {
        return imageFacade.create(imageCreateCmd);
    }
    
    /** 
     * @description: Creates an edited or extended image given an original image and a prompt.
     * @param imageCreateEditCmd
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/4/4 14:06
     */
    @PostMapping("/v1/images/edits")
    public SingleResponse<ImageCO> edit(@ModelAttribute ImageCreateEditCmd imageCreateEditCmd) {
        return imageFacade.edit(imageCreateEditCmd);
    }
    
    /** 
     * @description: Creates an edited or extended image given an original image and a prompt.
     * @param imageCreateEditCmdV2
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/4/24 15:07
     */
    @PostMapping("/v2/images/edits")
    public SingleResponse<ImageCO> editV2(@RequestBody ImageCreateEditCmdV2 imageCreateEditCmdV2) {
        return imageFacade.editV2(imageCreateEditCmdV2);
    }
    
    /** 
     * @description: Creates a variation of a given image.
     * @param imageCreateVariationCmd
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/4/4 14:18
     */
    @PostMapping("/v1/images/variations")
    public SingleResponse<ImageCO> variation(@ModelAttribute ImageCreateVariationCmd imageCreateVariationCmd) {
        return imageFacade.variation(imageCreateVariationCmd);
    }
    
    /** 
     * @description: Creates a variation of a given image.
     * @param imageCreateVariationCmdV2 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.image.ImageCO> 
     * @author MaoYuan.Li
     * @date: 2023/4/26 19:04
     */
    @PostMapping("/v2/images/variations")
    public SingleResponse<ImageCO> variationV2(@RequestBody ImageCreateVariationCmdV2 imageCreateVariationCmdV2) {
        return imageFacade.variationV2(imageCreateVariationCmdV2);
    }
}
