package com.chushiy.spring.boot.autoconfigure.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/4/2 下午 8:05
 * @Description 是否开启rest控制器响应包装
 * @ProjectName chushiy
 * @PackageName com.chushiy.spring.boot.autoconfigure.annotation
 * @ClassName EnableRestControllerResponseAdvice.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableRestControllerResponseAdvice {

    // TODO 可以支持指定对象进行包装 指定正确方法 错误方法

    /**
     * 是否开启
     */
    boolean enable() default true;
}
