package com.chushiy.spring.boot3.crypto.annotation;

import com.chushiy.crypto.annotation.Crypto;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 16:30
 * @Description 校验签名
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.crypto.annotation
 * @ClassName VerifySignature.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Crypto
public @interface VerifySignature {

}
