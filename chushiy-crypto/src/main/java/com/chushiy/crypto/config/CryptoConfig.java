package com.chushiy.crypto.config;

import com.chushiy.crypto.AES;
import com.chushiy.crypto.BASE64;
import com.chushiy.crypto.Crypto;
import com.chushiy.crypto.DES;
import com.chushiy.crypto.MD5;
import com.chushiy.crypto.RSA;
import com.chushiy.crypto.enums.CryptoType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.Map;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 18:39
 * @Description CryptoConfig
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto.config
 * @ClassName CryptoConfig.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Configuration
public class CryptoConfig {

    @Bean
    public Map<CryptoType, Crypto> cryptoMap(AES aes, DES des, MD5 md5, RSA rsa, BASE64 base64) {
        Map<CryptoType, Crypto> map = new EnumMap<>(CryptoType.class);
        map.put(CryptoType.AES, aes);
        map.put(CryptoType.DES, des);
        map.put(CryptoType.MD5, md5);
        map.put(CryptoType.RSA, rsa);
        map.put(CryptoType.BASE64, base64);
        return map;
    }
}
