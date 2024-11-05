package com.chushiy.crypto.util;

import com.chushiy.crypto.AES;
import com.chushiy.crypto.Crypto;
import com.chushiy.crypto.DES;
import com.chushiy.crypto.MD5;
import com.chushiy.crypto.RSA;
import com.chushiy.crypto.enums.CryptoType;
import com.chushiy.standard.util.Assert;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;
import java.util.Base64;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/4 23:50
 * @Description 加解密工具类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto.util
 * @ClassName CryptoUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class CryptoUtils {

    /**
     * 所有加解密算法
     */
    private static Map<CryptoType, Crypto> cryptoMap = new EnumMap<>(CryptoType.class);

    static {
        // 注册
        Security.addProvider(new BouncyCastleProvider());
        cryptoMap.put(CryptoType.AES, new AES());
        cryptoMap.put(CryptoType.DES, new DES());
        cryptoMap.put(CryptoType.RSA, new RSA());
        cryptoMap.put(CryptoType.MD5, new MD5());
    }

    public static Crypto getCrypto(CryptoType type) {
        return cryptoMap.get(type);
    }
}
