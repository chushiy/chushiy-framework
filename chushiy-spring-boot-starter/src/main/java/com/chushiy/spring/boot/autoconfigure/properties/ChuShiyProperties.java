package com.chushiy.spring.boot.autoconfigure.properties;

import com.chushiy.spring.boot.autoconfigure.enums.JSONTypeEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 2:51
 * @Description 系统配置文件
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.autoconfigure.properties
 * @ClassName ChuShiyProperties.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "chushiy")
@Data
public class ChuShiyProperties {

    /**
     * json类型
     */
    private JSONTypeEnum jsonType = JSONTypeEnum.JACKSON;

    /**
     * 日期转换格式
     */
    private String[] dateParsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd T HH:mm:ss"};

    private CorsRegistration cors;

    /**
     * 前缀
     */
    private String prefix;

    public static class CorsRegistration {
        private String pathPattern;

        private CorsConfiguration config;

    }
}
