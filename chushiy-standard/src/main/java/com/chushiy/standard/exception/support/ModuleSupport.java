package com.chushiy.standard.exception.support;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 6:37
 * @Description 模块支持
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.exception.support
 * @ClassName ModuleSupport.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface ModuleSupport {

    /**
     * 模块code
     * 四位
     * @return
     */
    String code();

    /**
     * 模块名称
     * @return
     */
    String name();
}
