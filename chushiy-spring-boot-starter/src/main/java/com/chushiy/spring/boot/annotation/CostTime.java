package com.chushiy.spring.boot.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @DateTime 2023/11/27 下午 8:06
 * @Description 实现代码耗时打印
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.annotation
 * @ClassName CostTime.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CostTime {
}
