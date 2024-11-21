package com.chushiy.crypto.util;

import com.chushiy.crypto.Crypto;
import com.chushiy.crypto.CryptoFactory;
import com.chushiy.crypto.enums.CryptoType;
import com.chushiy.crypto.exception.support.CryptoError;
import com.chushiy.standard.exception.BusinessException;
import com.chushiy.standard.util.Assert;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 16:33
 * @Description 签名工具类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto.util
 * @ClassName SignatureUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class SignatureUtils {

    private final CryptoFactory cryptoFactory;

    /**
     * 签名格式部分长度
     * val1:val2:val3
     */
    private static final Integer SIGNATURE_FORMAT_PORTION_LENGTH = 3;

    /**
     * 签名格式符号
     * :
     */
    private static final String SIGNATURE_FORMAT_SYMBOL = ":";

    /**
     * 验证签名
     * 签名规则
     * timestamp md5加密
     * requestId base64加密
     * nonce md5加密
     * sign requestId+nonce+timestamp RSA加密 格式如下 requestId:nonce:timestamp
     *
     * @param timestamp 时间戳
     * @param requestId 请求id
     * @param nonce     temp
     * @param sign      签名
     * @return boolean
     */
    public boolean verifySignature(String timestamp, String requestId, String nonce, String sign) {
        Crypto rsa = cryptoFactory.get(CryptoType.RSA);

        try {
            // 解密sign
            String decryptSign = rsa.decrypt(sign);

            // 用指定格式分割sign
            String[] decryptSignFormat = decryptSign.split(SIGNATURE_FORMAT_SYMBOL);
            // 签名格式不合法
            Assert.isTrue(decryptSignFormat.length == SIGNATURE_FORMAT_PORTION_LENGTH, () -> {
                throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
            });

            // requestId校验
            // 从sign中分离出来的requestId
            String requestIdNew = decryptSignFormat[0];
            // 为空 不符合格式
            Assert.isNotBlank(requestIdNew, () -> {
                throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
            });
            // 将requestIdNew和requestId对比
            Assert.isTrue(requestIdNew.equals(requestId), () -> {
                throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
            });

            // nonce校验
            // 从sign中分离出来的nonce
            String nonceNew = decryptSignFormat[1];
            // 为空 不符合格式
            Assert.isNotBlank(nonceNew, () -> {
                throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
            });
            // 将nonceNew和nonce对比
            Assert.isTrue(nonceNew.equals(nonce), () -> {
                throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
            });

            // timestamp校验
            // 从sign中分离出来的timestamp
            String timestampNew = decryptSignFormat[2];
            // 为空 不符合格式
            Assert.isNotBlank(timestampNew, () -> {
                throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
            });
            // 将timestampNew和timestamp对比
            Assert.isTrue(timestampNew.equals(timestamp), () -> {
                throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
            });
        } catch (BusinessException e) {
            return false;
        } catch (Throwable e) {
            return false;
        }
        return true;
    }
}
