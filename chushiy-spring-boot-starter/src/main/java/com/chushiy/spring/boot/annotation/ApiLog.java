package com.chushiy.spring.boot.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/23 17:37
 * @Description Api接口日志注解
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.annotation
 * @ClassName ApiLog.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiLog {
}
