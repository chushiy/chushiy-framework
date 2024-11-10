package com.chushiy.crypto.exception;

import java.io.Serializable;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 12:01
 * @Description 加解密错误
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto.exception
 * @ClassName CryptoException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class CryptoException  extends RuntimeException implements Serializable {

    public CryptoException(String message) {
        super(message);
    }

    public CryptoException(Throwable cause) {
        super(cause);
    }

    public CryptoException(String message, Throwable cause) {
        super(message, cause);
    }
}
