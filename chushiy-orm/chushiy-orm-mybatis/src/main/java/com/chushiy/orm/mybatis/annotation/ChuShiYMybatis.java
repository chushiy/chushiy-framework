package com.chushiy.orm.mybatis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/13 下午 6:33
 * @Description 开启初时y mybatis
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.orm.mybatis.annotation
 * @ClassName ChuShiYMybatis.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface ChuShiYMybatis {
}
