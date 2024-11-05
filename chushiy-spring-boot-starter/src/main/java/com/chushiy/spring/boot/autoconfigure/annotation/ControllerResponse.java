package com.chushiy.spring.boot.autoconfigure.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/5 14:19
 * @Description controller是否包装响应
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.autoconfigure.annotation
 * @ClassName ControllerResponse.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerResponse {

    /**
     * 是否开启
     */
    boolean enable() default false;
}
