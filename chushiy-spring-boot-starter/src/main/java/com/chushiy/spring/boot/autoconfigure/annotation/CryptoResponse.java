package com.chushiy.spring.boot.autoconfigure.annotation;

import com.chushiy.crypto.enums.CryptoType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/5 00:57
 * @Description 加密响应
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.autoconfigure.annotation
 * @ClassName CryptoResponse.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CryptoResponse {

    /**
     * 加解密类型 默认AES
     * @return CryptoType
     */
    CryptoType type() default CryptoType.AES;
}
