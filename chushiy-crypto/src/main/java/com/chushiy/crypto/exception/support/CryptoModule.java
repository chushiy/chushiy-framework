package com.chushiy.crypto.exception.support;

import com.chushiy.standard.exception.support.ModuleSupport;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 16:54
 * @Description TODO
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto.exception.support
 * @ClassName CryptoModule.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class CryptoModule {

    public static final ModuleSupport CRYPTO = new ModuleSupport() {
        @Override
        public String code() {
            return "0001";
        }

        @Override
        public String name() {
            return "crypto";
        }
    };
}
