package com.chushiy.standard.exception.support;

import lombok.RequiredArgsConstructor;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 6:38
 * @Description 默认错误
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.exception.support
 * @ClassName DefaultError.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@RequiredArgsConstructor
public enum DefaultError implements ErrorSupport {
    SUCCESS(false, DefaultModule.DEFAULT, "200", "操作执行成功"),

    INVALID_PARAM(false, DefaultModule.DEFAULT, "400", "请求参数不匹配"),

    UN_AUTHORIZED(false, DefaultModule.DEFAULT, "401", "请求未授权"),

    FORBIDDEN(false, DefaultModule.DEFAULT, "403", "无权执行该操作"),

    NOT_FOUND(false, DefaultModule.DEFAULT, "404", "请求资源不存在"),

    METHOD_NOT_ALLOWED(false, DefaultModule.DEFAULT, "405", "不支持当前请求方法"),

    NOT_ACCEPTABLE(false, DefaultModule.DEFAULT, "406", "操作执行失败"),

    REQUEST_TIMEOUT(false, DefaultModule.DEFAULT, "408", "请求连接超时"),

    NOT_FOUND_GONE(false, DefaultModule.DEFAULT, "410", "请求资源不存在"),

    UNSUPPORTED_MEDIA_TYPE(false, DefaultModule.DEFAULT, "415", "不支持当前媒体类型"),

    INTERNAL_SERVER_ERROR(true, DefaultModule.DEFAULT, "500", "系统异常"),

    SERVICE_UNAVAILABLE(false, DefaultModule.DEFAULT, "503", "服务不可用");

    private final boolean isSystemError;
    private final ModuleSupport module;
    private final String code;
    private final String message;

    @Override
    public boolean isSystemError() {
        return this.isSystemError;
    }

    @Override
    public ModuleSupport module() {
        return this.module;
    }

    @Override
    public String getCode() {
        return (this.isSystemError() ? 0 : 1) + this.module().code() + this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
