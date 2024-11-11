package com.chushiy.crypto;

import com.chushiy.crypto.exception.CryptoException;
import com.chushiy.crypto.properties.ChuShiyCryptoProperties;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/5 14:14
 * @Description MD5
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto
 * @ClassName MD5.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
@Component
@Setter
public class MD5 implements Crypto {

    @Override
    public String encrypt(String plaintext) throws CryptoException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5", "BC");
            byte[] messageDigest = md.digest(plaintext.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            log.error("MD5加密失败", e);
            throw new CryptoException("Encryption failed", e);
        }
    }

    @Override
    @Deprecated
    public String decrypt(String ciphertext) throws CryptoException {
        // MD5例外 不能解密
        return "";
    }

    /**
     * 校验明文和密文是否一致
     * @param plaintext 明文
     * @param ciphertext 密文
     * @return boolean
     * @throws CryptoException
     */
    public boolean equals(String plaintext, String ciphertext) throws CryptoException {
        try {
            return encrypt(plaintext).equals(ciphertext);
        } catch (CryptoException e) {
            log.error("MD5 equals失败", e);
            return false;
        }
    }
}
