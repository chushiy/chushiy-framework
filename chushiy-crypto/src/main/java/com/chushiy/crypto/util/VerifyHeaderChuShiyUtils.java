package com.chushiy.crypto.util;

import com.chushiy.crypto.CryptoFactory;
import com.chushiy.standard.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/11 20:39
 * @Description VerifyHeaderChuShiyUtils
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto.util
 * @ClassName VerifyHeaderChuShiyUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class VerifyHeaderChuShiyUtils {

    private final CryptoFactory cryptoFactory;

    /**
     * 校验
     *
     * @param timestamp 时间戳
     * @param csy       csy
     * @param b         b user-agent
     * @param qy        qy
     * @return 成功|失败
     */
    public boolean verifyHeaderChuShiy(String timestamp, String csy, String b, String qy) {
        try {

        } catch (BusinessException e) {
            return false;
        } catch (Throwable e) {
            return false;
        }
        return true;
    }
}
