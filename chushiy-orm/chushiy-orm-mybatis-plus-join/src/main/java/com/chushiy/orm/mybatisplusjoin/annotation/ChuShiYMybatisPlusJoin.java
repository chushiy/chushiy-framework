package com.chushiy.orm.mybatisplusjoin.annotation;

import com.chushiy.orm.mybatisplusjoin.ChuShiYMybaitsPlusJoinProperties;
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
 * @Description 开启初时y MybatisPlusJoin配置
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.orm.mybatisplusjoin.annotation
 * @ClassName ChuShiYMybatisPlusJoin.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@EnableConfigurationProperties(ChuShiYMybaitsPlusJoinProperties.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface ChuShiYMybatisPlusJoin {
}
