package com.szmengran.chatgpt.api;

import com.szmengran.chatgpt.dto.file.DeleteFileCO;
import com.szmengran.chatgpt.dto.file.File;
import com.szmengran.chatgpt.dto.file.FileCO;
import com.szmengran.cola.dto.SingleResponse;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件用于上传可与微调等功能一起使用的文档。
 * @Author MaoYuan.Li
 * @Date 2023/3/27 10:17
 * @Version 1.0
 */
public interface FileFacade {
    /** 
     * @description: Returns a list of files that belong to the user's organization.
     * @param  
     * @return: com.szmengran.chatgpt.dto.file.FileCO 
     * @author MaoYuan.Li
     * @date: 2023/3/27 11:53
     */
    SingleResponse<FileCO> list();
    
    /** 
     * @description: Upload a file that contains document(s) to be used across various endpoints/features. Currently, the size of all the files uploaded by one organization can be up to 1 GB. Please contact us if you need to increase the storage limit.
     * @param purpose
     * @param file
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.file.File> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 11:58
     */
    SingleResponse<File> upload(String purpose, MultipartFile file);
    
    /** 
     * @description: Delete a file.
     * @param fileId
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.file.DeleteFileCO> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:06
     */
    SingleResponse<DeleteFileCO> delete(String fileId);
    
    /** 
     * @description: Returns information about a specific file.
     * @param fileId 
     * @return: com.szmengran.cola.dto.SingleResponse<com.szmengran.chatgpt.dto.file.File> 
     * @author MaoYuan.Li
     * @date: 2023/3/27 12:20
     */
    SingleResponse<File> retrieve(String fileId);
}
