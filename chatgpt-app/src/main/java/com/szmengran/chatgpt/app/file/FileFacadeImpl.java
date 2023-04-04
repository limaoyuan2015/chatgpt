package com.szmengran.chatgpt.app.file;

import com.szmengran.chatgpt.api.FileFacade;
import com.szmengran.chatgpt.dto.OpenAiResponse;
import com.szmengran.chatgpt.dto.file.DeleteFileCO;
import com.szmengran.chatgpt.dto.file.File;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.MultiResponse;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/27 16:42
 * @Version 1.0
 */
@Service
public class FileFacadeImpl implements FileFacade {
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Override
    public MultiResponse<File> list() {
        OpenAiResponse<File> response = openAiClient.listFiles();
        return MultiResponse.of(response.getData());
    }
    
    @Override
    public SingleResponse<File> upload(final String purpose, final MultipartFile file) {
        File fileData = openAiClient.uploadFile(purpose, file);
        return SingleResponse.of(fileData);
    }
    
    @Override
    public SingleResponse<DeleteFileCO> delete(final String fileId) {
        DeleteFileCO deleteFileCO = openAiClient.deleteFile(fileId);
        return SingleResponse.of(deleteFileCO);
    }
    
    @Override
    public SingleResponse<File> retrieve(final String fileId) {
        File file = openAiClient.retrieveFile(fileId);
        return SingleResponse.of(file);
    }
}
