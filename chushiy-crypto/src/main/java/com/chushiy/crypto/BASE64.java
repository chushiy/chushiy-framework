package com.chushiy.crypto;

import com.chushiy.crypto.exception.CryptoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Base64;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/11 17:28
 * @Description BASE64
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto
 * @ClassName BASE64.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
@Component
public class BASE64 implements Crypto{

    @Override
    public String encrypt(String plaintext) throws CryptoException {
        try {
            return new String(Base64.getEncoder().encode(plaintext.getBytes()));
        } catch (Exception e) {
            log.error("BASE64加密错误", e);
            throw new CryptoException(e);
        }
    }

    @Override
    public String decrypt(String ciphertext) throws CryptoException {
        try {
            return new String(Base64.getDecoder().decode(ciphertext.getBytes()));
        } catch (Exception e) {
            log.error("BASE64解密错误", e);
            throw new CryptoException(e);
        }
    }
}
