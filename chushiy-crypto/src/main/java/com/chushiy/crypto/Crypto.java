package com.chushiy.crypto;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/5 13:59
 * @Description 加解密接口
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto
 * @ClassName Crypto.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public interface Crypto {

    /**
     * 加密
     * @param plaintext 明文
     * @return 密文
     */
    String encrypt(String plaintext);

    /**
     * 解密
     * @param ciphertext 密文
     * @return 明文
     */
    String decrypt(String ciphertext);
}
