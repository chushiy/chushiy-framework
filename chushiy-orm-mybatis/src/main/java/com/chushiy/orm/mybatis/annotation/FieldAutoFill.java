package com.chushiy.orm.mybatis.annotation;

import cn.hutool.core.annotation.AliasFor;
import com.chushiy.orm.mybatis.enums.FieldFillType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/13 下午 6:13
 * @Description 字段自动填充
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.orm.mybatis.annotation
 * @ClassName FieldAutoFill.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldAutoFill {

    /**
     * 填充类型
     */
    @org.springframework.core.annotation.AliasFor
    @AliasFor
    FieldFillType value() default FieldFillType.DEFAULT;

    /**
     * 填充类型
     */
    FieldFillType fillType() default FieldFillType.DEFAULT;
}
