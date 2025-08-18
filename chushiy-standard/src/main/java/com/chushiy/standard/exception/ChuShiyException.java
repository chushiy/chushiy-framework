package com.chushiy.standard.exception;

import java.io.Serializable;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/8/18 23:53
 * @Description chushiy-framework框架顶级异常 此框架其他异常都要继续此类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.exception
 * @ClassName ChuShiyException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class ChuShiyException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public ChuShiyException(String message) {
        super(message);
    }

}
