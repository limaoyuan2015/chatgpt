package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.FileFacade;
import com.szmengran.chatgpt.dto.file.DeleteFileCO;
import com.szmengran.chatgpt.dto.file.File;
import com.szmengran.chatgpt.dto.file.FileCO;
import com.szmengran.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 15:54
 * @Version 1.0
 */
@Tag(name = "file")
@RestController
public class FileController {
    
    @Resource
    private FileFacade fileFacade;
    
    /** 
     * @description: Returns a list of files that belong to the user's organization.
     * @param  
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.file.FileCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 15:56
     */
    @GetMapping("/v1/files")
    public SingleResponse<FileCO> list() {
        return fileFacade.list();
    }
    
    /**
     * @description: Upload a file that contains document(s) to be used across various endpoints/features. Currently, the size of all the files uploaded by one organization can be up to 1 GB. Please contact us if you need to increase the storage limit.
     * @param purpose
     * @param file
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.file.File>
     * @author MaoYuan.Li
     * @date: 2023/3/27 11:58
     */
    @PostMapping("/v1/files")
    public SingleResponse<File> upload(String purpose, MultipartFile file) {
        return fileFacade.upload(purpose, file);
    }
    
    /**
     * @description: Delete a file.
     * @param fileId
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.file.DeleteFileCO>
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:06
     */
    @DeleteMapping("/v1/files/{fileId}")
    public SingleResponse<DeleteFileCO> delete(@PathVariable("fileId") String fileId) {
        return fileFacade.delete(fileId);
    }
    
    /**
     * @description: Returns information about a specific file.
     * @param fileId
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.file.File>
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:20
     */
    @DeleteMapping("/v1/files/{fileId}")
    public SingleResponse<File> retrieve(String fileId) {
        return fileFacade.retrieve(fileId);
    }
}
