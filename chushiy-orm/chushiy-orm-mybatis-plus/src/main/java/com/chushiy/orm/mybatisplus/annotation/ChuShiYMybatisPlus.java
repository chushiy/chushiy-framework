package com.chushiy.orm.mybatisplus.annotation;

import com.chushiy.orm.mybatisplus.ChuShiYMybaitsPlusProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/13 下午 5:13
 * @Description 开启初时y MybatisPlus配置
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.orm.mybatisplus.annotation
 * @ClassName ChuShiYMybatisPlusConfig.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@EnableConfigurationProperties(ChuShiYMybaitsPlusProperties.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface ChuShiYMybatisPlus {
}
