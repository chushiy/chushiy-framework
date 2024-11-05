package com.chushiy.standard.exception.support;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 6:39
 * @Description 错误支持 策略模式 提供扩展
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.exception.support
 * @ClassName ErrorSupport.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface ErrorSupport {

    /**
     * is系统错误
     *
     * @return
     */
    boolean isSystemError();

    /**
     * 错误模块
     *
     * @return
     */
    ModuleSupport module();

    /**
     * 错误code
     * 错误码为8位
     * 第一位 0|1 0表示系统错误
     * 系统错误?1:0+模块code 4位+错误码 3位
     *
     * @return
     */
    String getCode();

    /**
     * 增加默认接口实现
     * 错误code
     * 错误码为8位
     * 第一位 0|1 0表示系统错误
     * 系统错误?1:0+模块code 4位+错误码 3位
     *
     * @param code 错误码 3位
     * @return
     */
    default String getCode(String code) {
        return (this.isSystemError() ? 0 : 1) + this.module().code() + code;
    }

    /**
     * 错误信息
     *
     * @return
     */
    String getMessage();
}
