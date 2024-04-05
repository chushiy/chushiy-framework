package com.chushiy.standard.exception.support;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 6:38
 * @Description 默认模块
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.exception.support
 * @ClassName DefaultModule.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class DefaultModule {

    /**
     * 采用单例
     * 默认模块
     */
    public static final ModuleSupport DEFAULT = new ModuleSupport() {
        @Override
        public String code() {
            return "0000";
        }

        @Override
        public String name() {
            return "default";
        }
    };
}
