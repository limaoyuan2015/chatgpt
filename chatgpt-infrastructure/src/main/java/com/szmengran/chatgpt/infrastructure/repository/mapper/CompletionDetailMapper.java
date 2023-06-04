package com.szmengran.chatgpt.infrastructure.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szmengran.chatgpt.domain.entity.CompletionDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author maoyuan.li
 * @since 2023-04-26
 */
@Mapper
public interface CompletionDetailMapper extends BaseMapper<CompletionDetail> {

}
