package com.chushiy.crypto;

import com.chushiy.crypto.enums.CryptoType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/21 15:24
 * @Description 加解密工厂类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto
 * @ClassName CryptoFactory.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CryptoFactory {

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
    public Crypto get(CryptoType type) {
        return cryptoMap.get(type);
    }
}
