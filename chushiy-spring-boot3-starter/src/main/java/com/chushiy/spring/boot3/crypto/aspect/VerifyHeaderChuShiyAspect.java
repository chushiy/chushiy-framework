package com.chushiy.spring.boot3.crypto.aspect;

import cn.hutool.core.util.NumberUtil;
import com.chushiy.crypto.exception.support.CryptoError;
import com.chushiy.crypto.properties.ChuShiyCryptoProperties;
import com.chushiy.crypto.util.VerifyHeaderChuShiyUtils;
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
 * @DateTime 2024/11/11 20:31
 * @Description VerifyHeaderChuShiy切面
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.crypto.aspect
 * @ClassName VerifyHeaderChuShiyAspect.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class VerifyHeaderChuShiyAspect {


    private final ChuShiyCryptoProperties cryptoProperties;

    private final VerifyHeaderChuShiyUtils verifyHeaderChuShiyUtils;

    private static final String TIMESTAMP_KEY = "timestamp";
    private static final String CSY_KEY = "csy";
    private static final String B_KEY = "b";
    private static final String QY_KEY = "qy";

    @Pointcut("@annotation(com.chushiy.spring.boot3.crypto.annotation.VerifyHeaderChuShiy)")
    public void verifyHeaderChuShiyPointcut() {
    }

    @Around("verifyHeaderChuShiyPointcut()")
    public Object verifyHeaderChuShiy(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // timestamp
        String timestamp = request.getHeader(TIMESTAMP_KEY);
        Assert.isBlank(timestamp, () -> {
            throw new BusinessException(CryptoError.VERIFY_CHUSHIY_FAIL);
        });
        // 判断timestamp是否可以转为Long
        Assert.isFalse(NumberUtil.isLong(timestamp), () -> {
            throw new BusinessException(CryptoError.VERIFY_CHUSHIY_FAIL);
        });
        // 超时
        if (Math.abs(System.currentTimeMillis() - Long.parseLong(timestamp)) > cryptoProperties.getTimeOut()) {
            throw new BusinessException(CryptoError.TIMESTAMP_TIMEOUT);
        }

        // csy
        String csy = request.getHeader(CSY_KEY);
        Assert.isBlank(csy, () -> {
            throw new BusinessException(CryptoError.VERIFY_CHUSHIY_FAIL);
        });

        // b
        String b = request.getHeader(B_KEY);
        Assert.isBlank(b, () -> {
            throw new BusinessException(CryptoError.VERIFY_CHUSHIY_FAIL);
        });

        // qy
        String qy = request.getHeader(QY_KEY);
        Assert.isBlank(qy, () -> {
            throw new BusinessException(CryptoError.VERIFY_CHUSHIY_FAIL);
        });

        // 验证
        if (!this.verifyHeaderChuShiyUtils.verifyHeaderChuShiy(timestamp, csy, b, qy)) {
            throw new BusinessException(CryptoError.VERIFY_CHUSHIY_FAIL);
        }

        return joinPoint.proceed();
    }
}
