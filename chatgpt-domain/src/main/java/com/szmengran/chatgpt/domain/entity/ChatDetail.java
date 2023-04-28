package com.szmengran.chatgpt.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author maoyuan.li
 * @since 2023-04-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ChatDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "chat_detail_id", type = IdType.INPUT)
    private String chatDetailId;

    private String chatId;

    private String question;

    private String answer;

    private Integer promptTokens;

    private Integer completionTokens;

    private Integer totalTokens;

    private Integer validstatus;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
