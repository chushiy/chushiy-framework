package com.chushiy.crypto.exception.support;

import com.chushiy.standard.exception.support.ErrorSupport;
import com.chushiy.standard.exception.support.ModuleSupport;
import lombok.RequiredArgsConstructor;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 16:50
 * @Description 加解密异常支持
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto.exception.support
 * @ClassName CryptoError.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@RequiredArgsConstructor
public enum CryptoError implements ErrorSupport {

    /**
     * 校验签名失败
     */
    VERIFY_SIGNATURE_FAIL(false, CryptoModule.CRYPTO, "100", "校验签名失败"),
    /**
     * 超时
     */
    TIMESTAMP_TIMEOUT(false, CryptoModule.CRYPTO, "101", "超时"),
    /**
     * 校验CHUSHIY失败
     */
    VERIFY_CHUSHIY_FAIL(false, CryptoModule.CRYPTO, "102", "校验chushiy失败"),
    ;

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
