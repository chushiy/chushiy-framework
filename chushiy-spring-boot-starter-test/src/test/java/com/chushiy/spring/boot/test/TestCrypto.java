package com.chushiy.spring.boot.test;

import com.chushiy.crypto.Crypto;
import com.chushiy.crypto.RSA;
import com.chushiy.crypto.enums.CryptoType;
import com.chushiy.crypto.util.CryptoUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.KeyPair;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 22:57
 * @Description TestCrypto
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.test
 * @ClassName TestCrypto.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@SpringBootTest
public class TestCrypto {

    @Autowired
    private CryptoUtils cryptoUtils;

    @Test
    void testAES() {
        Crypto crypto = cryptoUtils.getCrypto(CryptoType.AES);
        String ciphertext = crypto.encrypt("蛋黄味哦吼");
        System.out.println(ciphertext);

        String plaintext = crypto.decrypt(ciphertext);
        System.out.println(plaintext);
    }

    @Test
    void testDES() {
        Crypto crypto = cryptoUtils.getCrypto(CryptoType.DES);
        String ciphertext = crypto.encrypt("蛋黄味哦吼");
        System.out.println(ciphertext);

        String plaintext = crypto.decrypt(ciphertext);
        System.out.println(plaintext);
    }

    @Test
    void testMD5() {
        Crypto crypto = cryptoUtils.getCrypto(CryptoType.MD5);
        String ciphertext = crypto.encrypt("蛋黄味哦吼");
        System.out.println(ciphertext);

        String plaintext = crypto.decrypt(ciphertext);
        System.out.println(plaintext);
    }

    @Test
    void testRSA() {
        RSA crypto = (RSA) cryptoUtils.getCrypto(CryptoType.RSA);
        // KeyPair keyPair = RSA.generateKeyPair();
        //
        // crypto.setPublicKey(keyPair.getPublic());
        // crypto.setPrivateKey(keyPair.getPrivate());


        // System.out.println(RSA.exportPublicKey(keyPair.getPublic()));
        // System.out.println(RSA.exportPrivateKey(keyPair.getPrivate()));

        String ciphertext = crypto.encrypt("蛋黄味哦吼");
        System.out.println(ciphertext);

        String plaintext = crypto.decrypt(ciphertext);
        System.out.println(plaintext);
    }

}
