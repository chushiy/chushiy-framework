package com.chushiy.spring.boot3.autoconfigure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/20 16:50
 * @Description jackson配置
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.autoconfigure.config
 * @ClassName JacksonConfig.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Configuration
public class JacksonConfig {

    /**
     * 配置ObjectMapper
     * 为什么不使用@Bean
     * 不能覆盖容器中有的配置 在已有的配置上面在进行配置
     *
     * @param objectMapper objectMapper
     */
    @Autowired
    public void configureObjectMapper(ObjectMapper objectMapper) {
        // 添加JavaTimeModule以支持Java 8的日期/时间类型
        objectMapper.registerModule(new JavaTimeModule());
    }

    /*@Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        // 添加JavaTimeModule以支持Java 8的日期/时间类型
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }*/
}
