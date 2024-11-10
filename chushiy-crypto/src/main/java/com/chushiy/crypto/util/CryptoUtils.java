package com.chushiy.crypto.util;

import com.chushiy.crypto.Crypto;
import com.chushiy.crypto.enums.CryptoType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
@Component
@RequiredArgsConstructor
@Slf4j
public class CryptoUtils {

    /**
     * 所有加解密算法
     */
    private final Map<CryptoType, Crypto> cryptoMap;

    /**
     * 获取加解密算法
     *
     * @param type 加解密类型
     * @return Crypto
     */
    public Crypto getCrypto(CryptoType type) {
        return cryptoMap.get(type);
    }
}
