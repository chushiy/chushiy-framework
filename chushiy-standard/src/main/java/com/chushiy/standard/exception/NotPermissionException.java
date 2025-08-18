package com.chushiy.standard.exception;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/8/18 23:54
 * @Description 没有权限异常
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.exception
 * @ClassName NotPermissionException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class NotPermissionException extends ChuShiyException {

    public NotPermissionException(String message) {
        super("无此权限: " + message);
    }
}
