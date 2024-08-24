package com.chushiy.spring.boot.autoconfigure.config;

import com.chushiy.spring.boot.autoconfigure.converter.StringToLocalDateConverter;
import com.chushiy.spring.boot.autoconfigure.properties.ChuShiyProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/4/8 下午 7:58
 * @Description webMvc配置
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.autoconfigure.config
 * @ClassName WebMvcConfig.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final ChuShiyProperties chuShiYProperties;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        WebMvcConfigurer.super.addFormatters(registry);
        registry.addConverter(new StringToLocalDateConverter(this.chuShiYProperties));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry
                // 对所有的路径生效
                .addMapping("/**")
                // 允许任何域名访问
                .allowedOrigins("*")
                // 允许所有方法（GET、POST等）
                .allowedMethods("*")
                // 允许所有请求头
                .allowedHeaders("*")
                // 允许发送Cookie
                .allowCredentials(true)
                // 预检请求的有效期为1小时
                .maxAge(3600);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(chuShiYProperties.getPrefix(), p -> true);
    }
}
