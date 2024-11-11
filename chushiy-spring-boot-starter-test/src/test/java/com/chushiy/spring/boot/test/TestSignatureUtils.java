package com.chushiy.spring.boot.test;

import cn.hutool.core.util.RandomUtil;
import com.chushiy.crypto.Crypto;
import com.chushiy.crypto.MD5;
import com.chushiy.crypto.enums.CryptoType;
import com.chushiy.crypto.util.CryptoUtils;
import com.chushiy.crypto.util.SignatureUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/11 17:52
 * @Description TestSignatureUtils
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.test
 * @ClassName TestSignatureUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@SpringBootTest
public class TestSignatureUtils {

    @Autowired
    private SignatureUtils signatureUtils;

    @Autowired
    private CryptoUtils cryptoUtils;

    @Test
    public void test() {
        // * timestamp md5加密
        // * requestId base64加密
        // * nonce md5加密
        // * sign requestId+nonce+timestamp RSA加密 格式如下 val1:val2:val3
        MD5 md5 = (MD5) cryptoUtils.getCrypto(CryptoType.MD5);
        Crypto rsa = cryptoUtils.getCrypto(CryptoType.RSA);
        Crypto base64 = cryptoUtils.getCrypto(CryptoType.BASE64);

        String timestamp = md5.encrypt(String.valueOf(System.currentTimeMillis()));
        String requestId = base64.encrypt(RandomUtil.randomNumbers(7));
        String nonce = md5.encrypt(RandomUtil.randomNumbers(8));
        String sign = rsa.encrypt(requestId + ":" + nonce + ":" + timestamp);
        boolean verifySignature = signatureUtils.verifySignature(timestamp, requestId, nonce, sign);
        System.out.println(verifySignature);
    }
}
