package com.chushiy.crypto;

import com.chushiy.crypto.exception.CryptoException;
import com.chushiy.crypto.properties.ChuShiyCryptoProperties;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/5 14:13
 * @Description RSA
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto
 * @ClassName RSA.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
@Setter
public class RSA implements Crypto {

    private static final String ALGORITHM = "RSA";

    private static final String TRANSFORMATION = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /**
     * 字符集
     */
    private static final String CHARSET_NAME = StandardCharsets.UTF_8.name();

    /**
     * 公钥
     */
    private PublicKey publicKey;

    /**
     * 私钥
     */
    private PrivateKey privateKey;

    @Autowired
    public RSA(ChuShiyCryptoProperties chuShiyCryptoProperties) {
        this.publicKey = chuShiyCryptoProperties.getPublicKey();
        this.privateKey = chuShiyCryptoProperties.getPrivateKey();
    }

    public static KeyPair generateKeyPair() throws CryptoException {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM, "BC");
            keyGen.initialize(2048);
            return keyGen.generateKeyPair();
        } catch (Exception e) {
            throw new CryptoException("Key pair generation failed", e);
        }
    }

    @Override
    public String encrypt(String plaintext) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION, "BC");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedData = cipher.doFinal(plaintext.getBytes(CHARSET_NAME));
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            throw new CryptoException("Encryption failed", e);
        }
    }

    @Override
    public String decrypt(String ciphertext) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION, "BC");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decodedData = Base64.getDecoder().decode(ciphertext);
            byte[] decryptedData = cipher.doFinal(decodedData);
            return new String(decryptedData, CHARSET_NAME);
        } catch (Exception e) {
            throw new CryptoException("Decryption failed", e);
        }
    }

    /**
     * 将公钥转换为base64
     *
     * @param publicKey 公钥
     * @return base64
     */
    public static String exportPublicKey(PublicKey publicKey) {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    /**
     * 将base64的公钥转换为PublicKey
     *
     * @param publicKeyStr base64
     * @return 公钥
     * @throws Exception
     */
    public static PublicKey importPublicKey(String publicKeyStr) throws Exception {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", "BC");
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * 将私钥转换为base64
     *
     * @param privateKey 私钥
     * @return Base64
     */
    public static String exportPrivateKey(PrivateKey privateKey) {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    /**
     * 将base64的私钥转换为PrivateKey
     *
     * @param privateKeyStr Base64
     * @return PrivateKey
     * @throws Exception
     */
    public static PrivateKey importPrivateKey(String privateKeyStr) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", "BC");
        return keyFactory.generatePrivate(keySpec);
    }
}
