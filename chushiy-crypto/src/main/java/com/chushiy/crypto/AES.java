package com.chushiy.crypto;

import com.chushiy.crypto.exception.CryptoException;
import com.chushiy.crypto.properties.ChuShiyCryptoProperties;
import com.chushiy.standard.util.Assert;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/5 14:03
 * @Description AES
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto
 * @ClassName AES.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
@Component
@Setter
public class AES implements Crypto {

    /**
     * key
     */
    private String key;

    /**
     * iv
     */
    private String iv;

    /**
     * 算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加密变换
     */
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    /**
     * 字符集
     */
    private static final String CHARSET_NAME = StandardCharsets.UTF_8.name();

    @Autowired
    public AES(ChuShiyCryptoProperties chuShiyCryptoProperties) {
        this(chuShiyCryptoProperties.getAes().getKey(), chuShiyCryptoProperties.getAes().getIv());
    }

    public AES(String key, String iv) {
        Assert.isTrue(key.length() == 32, "key长度必须是32位");
        this.key = key;
        Assert.isTrue(iv.length() == 16, "iv长度必须是16位");
        this.iv = iv;
    }

    @Override
    public String encrypt(String plaintext) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION, "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(CHARSET_NAME), ALGORITHM);
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes(CHARSET_NAME));
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] encrypted = cipher.doFinal(plaintext.getBytes(CHARSET_NAME));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            log.error("AES加密失败", e);
            throw new CryptoException("加密失败", e);
        }
    }

    @Override
    public String decrypt(String ciphertext) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION, "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(CHARSET_NAME), ALGORITHM);
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes(CHARSET_NAME));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
            return new String(decrypted, CHARSET_NAME);
        } catch (Exception e) {
            log.error("AES解密失败", e);
            throw new CryptoException("解密失败", e);
        }
    }
}
