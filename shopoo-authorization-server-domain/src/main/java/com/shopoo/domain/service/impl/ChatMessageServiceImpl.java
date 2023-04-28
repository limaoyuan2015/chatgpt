package com.shopoo.domain.service.impl;

import com.shopoo.domain.entity.ChatMessage;
import com.shopoo.domain.mapper.ChatMessageMapper;
import com.shopoo.domain.service.IChatMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author maoyuan.li
 * @since 2023-04-26
 */
@Service
public class ChatMessageServiceImpl extends ServiceImpl<ChatMessageMapper, ChatMessage> implements IChatMessageService {

}
