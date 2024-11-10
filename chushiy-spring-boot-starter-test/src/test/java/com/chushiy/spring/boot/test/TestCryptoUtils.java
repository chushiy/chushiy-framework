package com.chushiy.spring.boot.test;

import com.chushiy.crypto.enums.CryptoType;
import com.chushiy.crypto.util.CryptoUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 18:21
 * @Description TestCryptoUtils
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.test
 * @ClassName TestCryptoUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@SpringBootTest
public class TestCryptoUtils {

    @Autowired
    private CryptoUtils cryptoUtils;

    @Test
    void testGetCrypto() {
        System.out.println(cryptoUtils.getCrypto(CryptoType.AES));
    }
}
