package com.szmengran.chatgpt.infrastructure.repository;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.szmengran.chatgpt.domain.assembler.Assembler;
import com.szmengran.chatgpt.domain.completion.repository.CompletionRepository;
import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import com.szmengran.chatgpt.domain.converter.Converter;
import com.szmengran.chatgpt.domain.entity.CompletionDetail;
import com.szmengran.chatgpt.domain.entity.CompletionTitle;
import com.szmengran.chatgpt.domain.utils.IDTypes;
import com.szmengran.chatgpt.dto.chat.ChatMessage;
import com.szmengran.chatgpt.dto.completion.CompletionCO;
import com.szmengran.chatgpt.dto.completion.CompletionCmd;
import com.szmengran.chatgpt.dto.completion.CompletionCreateCmd;
import com.szmengran.chatgpt.dto.completion.CompletionDTO;
import com.szmengran.chatgpt.infrastructure.openai.OpenAiClient;
import com.szmengran.chatgpt.infrastructure.repository.mapper.CompletionDetailMapper;
import com.szmengran.chatgpt.infrastructure.repository.mapper.CompletionTitleMapper;
import com.szmengran.cola.base.utils.IDUtils;
import feign.Response;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Repository;

/**
 * @Author MaoYuan.Li
 * @Date 2023/5/4 16:18
 * @Version 1.0
 */
@Repository
public class CompletionRepositoryImpl implements CompletionRepository {
    
    @Resource
    private OpenAiClient openAiClient;

    @Resource
    private CompletionTitleMapper completionTitleMapper;

    @Resource
    private CompletionDetailMapper completionDetailMapper;

    @Resource
    private ChatGPTProperties chatGPTProperties;

    @Override
    public Response completionsStream(final CompletionCreateCmd completionCreateCmd) {
        return openAiClient.createCompletionStream(completionCreateCmd);
    }
    
    @Override
    public CompletionCO createCompletion(final CompletionCmd completionCmd) {
        Assembler.converter(completionCmd, chatGPTProperties);
        CompletionCreateCmd completionCreateCmd = Converter.INSTANCE.toCompletionCreateCmd(completionCmd);
        CompletionCO completionCO = openAiClient.createCompletion(completionCreateCmd);
        String chatDetailId = completionCO.getId();
        completionCO.setCompletionDetailId(chatDetailId);
        if (StringUtils.isBlank(completionCO.getCompletionId())) {
            String completionId = IDUtils.getSnowId(IDTypes.CHAT_TITLE);
            String question = completionCO.getChoices().get(0).getText();
            String title = question.length() > 20 ? question.substring(0, 20) : question;
            completionCO.setCompletionId(completionId);
            completionCO.setTitle(title);
        }
        return completionCO;
    }

    @Override
    public void addCompletionTitle(CompletionTitle completionTitle) {
        completionTitleMapper.insert(completionTitle);
    }

    @Override
    public void addCompletionDetail(CompletionDetail completionDetail) {
        completionDetailMapper.insert(completionDetail);
    }

    @Override
    public List<CompletionTitle> getCompletionListByUsername(String username) {
        LambdaQueryWrapper<CompletionTitle> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(CompletionTitle::getUsername, username);
        return completionTitleMapper.selectList(queryWrapper);
    }

    @Override
    public List<CompletionDetail> getCompletionListById(String completionId) {
        LambdaQueryWrapper<CompletionDetail> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(CompletionDetail::getCompletionDetailId, completionId);
        queryWrapper.last("order by create_time desc limit 5");
        return completionDetailMapper.selectList(queryWrapper);
    }
}
