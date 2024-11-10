package com.chushiy.crypto;

import com.chushiy.crypto.exception.CryptoException;
import com.chushiy.crypto.properties.ChuShiyCryptoProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/5 14:13
 * @Description DES
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto
 * @ClassName DES.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DES implements Crypto {

    private final SecretKeySpec keySpec;

    @Autowired
    public DES(ChuShiyCryptoProperties chuShiyCryptoProperties) {
        this.keySpec = new SecretKeySpec(chuShiyCryptoProperties.getDes().getKey().getBytes(), "DES");
    }

    @Override
    public String encrypt(String plaintext) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            log.error("DES加密错误", e);
            throw new CryptoException(e);
        }
    }

    @Override
    public String decrypt(String ciphertext) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding", "BC");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decodedBytes = Base64.getDecoder().decode(ciphertext);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            log.error("DES解密错误", e);
            throw new CryptoException(e);
        }
    }
}
