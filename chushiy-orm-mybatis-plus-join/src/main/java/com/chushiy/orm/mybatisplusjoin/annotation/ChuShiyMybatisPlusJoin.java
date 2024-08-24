package com.chushiy.orm.mybatisplusjoin.annotation;

import com.chushiy.orm.mybatisplusjoin.ChuShiyMybaitsPlusJoinProperties;
import com.chushiy.orm.mybatisplusjoin.config.ChuShiyMybatisPlusJoinConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

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
 * @ClassName ChuShiyMybatisPlusJoin.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Import({ChuShiyMybatisPlusJoinConfig.class})// TODO 判断有无ChuShiyMybatisPlusJoinConfig得子类 如果有则用子类
@EnableConfigurationProperties(ChuShiyMybaitsPlusJoinProperties.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface ChuShiyMybatisPlusJoin {
}
