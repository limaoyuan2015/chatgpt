package com.szmengran.chatgpt.wap;

import com.szmengran.chatgpt.api.ChatFacade;
import com.szmengran.chatgpt.domain.chat.repository.ChatRepository;
import com.szmengran.chatgpt.dto.chat.ChatCO;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.cola.dto.SingleResponse;
import feign.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/23 11:43
 *
 * @Version 1.0
 */
@Tag(name = "chat")
@RestController
public class ChatController {
    
    @Resource
    private ChatFacade chatFacade;
    
    @Operation(summary = "Creates a completion for the chat message")
    @PostMapping("/v1/chat/completions")
    public SingleResponse<ChatCO> chat(@RequestBody ChatCmd chatCmd, Principal principal) {
        chatCmd.setUsername(principal.getName());
        return chatFacade.chat(chatCmd);
    }
    
    @Resource
    private ChatRepository chatRepository;
    
    @Resource
    private OpenAiClient openAiClient;
    
    @Operation(summary = "Creates a completion for the chat message")
    @PostMapping("/v1/chat/completionStream")
    public void chatStream(@RequestBody ChatCmd chatCmd, HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType(MediaType.TEXT_EVENT_STREAM_VALUE);
        httpServletResponse.setCharacterEncoding("UTF-8");
        Response response = openAiClient.chatStream(chatCmd);
        try(InputStream inputStream = response.body().asInputStream()) {
            StreamUtils.copy(inputStream, httpServletResponse.getOutputStream());
            httpServletResponse.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
