package com.szmengran.chatgpt.infrastructure.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @Description: MyBatis plus自动填充与更新时间
 * @Author: limy66
 * @Date:   2021/2/20 10:58
 * @Param:  
 * @Return: 
 */
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {
    
    private final static String CREATE_DATE = "createTime";
    private final static String UPDATE_DATE = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        //创建时间
        strictInsertFill(metaObject, CREATE_DATE, LocalDateTime.class, LocalDateTime.now());
        strictInsertFill(metaObject, UPDATE_DATE, LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新时间
        strictUpdateFill(metaObject, UPDATE_DATE, LocalDateTime.class, LocalDateTime.now());
    }
}
