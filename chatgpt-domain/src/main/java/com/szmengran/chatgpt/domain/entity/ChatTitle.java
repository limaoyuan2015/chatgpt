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
public class ChatTitle implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "chat_id", type = IdType.INPUT)
    private String chatId;

    /**
     * 用户名
     */
    private String username;
    
    /**
     * 标题
     */
    private String title;
    
    /**
     * 状态 0-删除 1-有效
     */
    private Integer validstatus;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
