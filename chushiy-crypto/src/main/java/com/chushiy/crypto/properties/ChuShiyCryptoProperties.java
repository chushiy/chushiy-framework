package com.chushiy.crypto.properties;

import com.chushiy.crypto.RSA;
import com.chushiy.crypto.constant.CryptoConstant;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;

import jakarta.annotation.PostConstruct;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 17:09
 * @Description crypto配置
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto.properties
 * @ClassName ChuShiyCryptoProperties.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@ConfigurationProperties(prefix = "chushiy.crypto")
@Data
public class ChuShiyCryptoProperties {

    static {
        // 注册
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * 请求超时时间 秒
     */
    private Long timeOut;

    /**
     * AES
     */
    private AES aes;

    /**
     * 公钥
     */
    private PublicKey publicKey;

    /**
     * 私钥
     */
    private PrivateKey privateKey;

    /**
     * DES
     */
    private DES des;

    public DES getDes() {
        // 默认值
        if (des == null) {
            return new DES();
        }
        return des;
    }

    @Getter
    @Setter
    public static class DES {

        /**
         * key
         */
        private String key;

        public String getKey() {
            if (key == null) {
                return CryptoConstant.DES_KEY;
            }
            return key;
        }
    }

    @PostConstruct
    public void init() {
        // 初始化公钥和私钥
        KeyPair keyPair = RSA.generateKeyPair();
        this.publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();
    }

    public AES getAes() {
        // 默认值
        if (aes == null) {
            return new AES();
        }
        return aes;
    }

    @Getter
    @Setter
    public static class AES {

        /**
         * key
         */
        private String key;

        /**
         * iv
         */
        private String iv;

        public String getKey() {
            // 默认值
            if (key == null) {
                return CryptoConstant.AES_KEY;
            }
            return key;
        }

        public String getIv() {
            // 默认值
            if (iv == null) {
                return CryptoConstant.AES_IV;
            }
            return iv;
        }
    }

    /**
     * 将timeout自动变成毫秒单位
     *
     * @return timeOut
     */
    public Long getTimeOut() {
        // 默认值
        if (timeOut == null) {
            return CryptoConstant.TIMEOUT;
        }
        return timeOut * 1000;
    }
}
