//package com.szmengran.chatgpt.app.chat;
//
//import com.szmengran.chatgpt.api.ChatFacade;
//import com.szmengran.chatgpt.app.assembler.ChatAssembler;
//import com.szmengran.chatgpt.domain.chat.ChatDomainService;
//import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
//import com.szmengran.chatgpt.dto.chat.ChatCO;
//import com.szmengran.chatgpt.dto.chat.ChatCmd;
//import com.szmengran.cola.dto.SingleResponse;
//import feign.Response;
//import jakarta.annotation.Resource;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
//import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
//
///**
// * @Author MaoYuan.Li
// * @Date 2023/3/23 12:07
// * @Version 1.0
// */
//@Service
//public class ChatFacadeImpl implements ChatFacade {
//
//    @Resource
//    private ChatGPTProperties chatGPTProperties;
//
//    @Resource
//    private ChatDomainService chatDomainService;
//
//    @Override
//    public SingleResponse<ChatCO> chat(final ChatCmd chatCmd) {
//        ChatAssembler.converter(chatCmd, chatGPTProperties);
//        ChatCO chatCO = chatDomainService.chat(chatCmd);
//        return SingleResponse.of(chatCO);
//    }
//
//}
