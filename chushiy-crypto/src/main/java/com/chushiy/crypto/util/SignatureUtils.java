package com.chushiy.crypto.util;

import com.chushiy.crypto.Crypto;
import com.chushiy.crypto.enums.CryptoType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 16:33
 * @Description 签名工具类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto.util
 * @ClassName SignatureUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class SignatureUtils {

    private final CryptoUtils cryptoUtils;

    /**
     * 验证签名
     * 签名规则
     * timestamp md5魔改加密
     * requestId base64魔改加密
     * nonce md5魔改加密
     * sign requestId+nonce+timestamp RSA加密
     *
     * @param timestamp 时间戳
     * @param requestId 请求id
     * @param nonce     temp
     * @param sign      签名
     * @return boolean
     */
    public boolean verifySignature(String timestamp, String requestId, String nonce, String sign) {
        Crypto md5 = cryptoUtils.getCrypto(CryptoType.MD5);
        // Crypto md5 = cryptoUtils.getCrypto(CryptoType.MD5);
        Crypto rsa = cryptoUtils.getCrypto(CryptoType.RSA);

        return true;
    }
}
