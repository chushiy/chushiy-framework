package com.chushiy.spring.boot.crypto.annotation;

import com.chushiy.crypto.annotation.Crypto;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/11 20:30
 * @Description 验签请求头参数 chushiy相关参数
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.crypto.annotation
 * @ClassName VerifyHeaderChuShiy.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Crypto
public @interface VerifyHeaderChuShiy {

}
