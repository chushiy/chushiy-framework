package com.chushiy.crypto.annotation;

import com.chushiy.crypto.enums.CryptoType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 12:21
 * @Description 加解密顶级注解
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto.annotation
 * @ClassName Crypto.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Crypto {

    /**
     * 加解密类型 默认AES
     *
     * @return CryptoType
     */
    CryptoType type() default CryptoType.AES;
}
