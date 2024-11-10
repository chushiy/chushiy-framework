package com.chushiy.crypto;

import com.chushiy.crypto.exception.CryptoException;
import com.chushiy.crypto.properties.ChuShiyCryptoProperties;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
@RequiredArgsConstructor
public class MD5 implements Crypto {

    private final ChuShiyCryptoProperties chuShiyCryptoProperties;

    @Override
    public String encrypt(String plaintext) throws CryptoException {
        return null;
    }

    @Override
    public String decrypt(String ciphertext) throws CryptoException {
        return null;
    }
}
