package com.chushiy.crypto;

import com.chushiy.standard.util.Assert;
import lombok.Setter;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
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
@Setter
public class AES implements Crypto {

    public String key;

    public String iv;

    public AES() {
        this("chushiy11080aqgeszaqtwkpi.hrfcdw", "chushiy11080ehwu");
    }

    public AES(String key, String iv) {
        Assert.isTrue(key.length() == 32, "key长度必须是32位");
        this.key = key;
        Assert.isTrue(iv.length() == 16, "iv长度必须是16位");
        this.iv = iv;
    }

    @Override
    public String encrypt(String plaintext) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] encrypted = cipher.doFinal(plaintext.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String decrypt(String ciphertext) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
            return new String(decrypted, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException("解密失败", e);
        }
    }
}
