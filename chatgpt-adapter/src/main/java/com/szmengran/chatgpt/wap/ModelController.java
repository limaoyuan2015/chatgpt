package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.ModelFacade;
import com.szmengran.chatgpt.dto.model.Model;
import com.szmengran.cola.dto.MultiResponse;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 18:42
 * @Version 1.0
 */
@Tag(name = "model")
@RestController
public class ModelController {
    
    @Resource
    private ModelFacade modelFacade;
    
    /**
     * @description: Lists the currently available models, and provides basic information about each one such as the owner and availability.
     * @param
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.model.Model>
     * @author MaoYuan.Li
     * @date: 2023/3/27 18:33
     */
    @Operation(summary = "Lists the currently available models, and provides basic information about each one such as the owner and availability.")
    @GetMapping("/v1/models")
    public MultiResponse<Model> listModels() {
        return modelFacade.listModels();
    }
    
    /**
     * @description: Retrieves a model instance, providing basic information about the model such as the owner and permissioning.
     * @param model
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.model.Model>
     * @author MaoYuan.Li
     * @date: 2023/3/27 18:35
     */
    @Operation(summary = "Retrieves a model instance, providing basic information about the model such as the owner and permissioning.")
    @GetMapping("/v1/models/{model}")
    public SingleResponse<Model> retrieve(@PathVariable("model") String model) {
        return modelFacade.retrieve(model);
    }
}
