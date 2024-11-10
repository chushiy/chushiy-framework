package com.chushiy.spring.boot.crypto.aspect;

import cn.hutool.core.util.NumberUtil;
import com.chushiy.crypto.exception.support.CryptoError;
import com.chushiy.crypto.properties.ChuShiyCryptoProperties;
import com.chushiy.crypto.util.SignatureUtils;
import com.chushiy.standard.exception.BusinessException;
import com.chushiy.standard.util.Assert;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 16:31
 * @Description 校验签名切面
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.crypto.aspect
 * @ClassName VerifySignatureAspect.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class VerifySignatureAspect {

    private final SignatureUtils signatureUtils;

    private final ChuShiyCryptoProperties cryptoProperties;

    private static final String TIMESTAMP_KEY = "timestamp";
    private static final String REQUEST_ID_KEY = "request-id";
    private static final String NONCE_KEY = "nonce";
    private static final String SIGN_KEY = "sign";

    @Pointcut("@annotation(com.chushiy.spring.boot.crypto.annotation.VerifySignature)")
    public void verifySignPointcut() {
    }

    @Around("verifySignPointcut()")
    public Object verifySign(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // timestamp
        String timestamp = request.getHeader(TIMESTAMP_KEY);
        Assert.isBlank(timestamp, () -> {
            throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
        });
        // 判断timestamp是否可以转为Long
        Assert.isFalse(NumberUtil.isLong(timestamp), () -> {
            throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
        });

        // requestId
        String requestId = request.getHeader(REQUEST_ID_KEY);
        Assert.isBlank(requestId, () -> {
            throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
        });

        // nonce
        String nonce = request.getHeader(NONCE_KEY);
        Assert.isBlank(nonce, () -> {
            throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
        });

        // sign
        String sign = request.getHeader(SIGN_KEY);
        Assert.isBlank(sign, () -> {
            throw new BusinessException(CryptoError.VERIFY_SIGNATURE_FAIL);
        });

        // 超过配置的时间
        if (Math.abs(System.currentTimeMillis() - Long.parseLong(timestamp)) > cryptoProperties.getTimeOut()) {
            throw new BusinessException(CryptoError.TIMESTAMP_TIMEOUT);
        }

        // 验签
        if (!this.signatureUtils.verifySignature(timestamp, requestId, nonce, sign)) {
            throw new BusinessException(CryptoError.TIMESTAMP_TIMEOUT);
        }

        return joinPoint.proceed();
    }
}
