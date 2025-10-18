package com.chushiy.spring.boot3.log.util;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/9/6 18:18
 * @Description requestId生成器
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.log.util
 * @ClassName RequestIdGenerator.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class RequestIdGenerator {

    private static final String ALPHABET = "0123456789abcdef";

    private static final SecureRandom random = new SecureRandom();

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * 生成requestId
     *
     * @return requestId
     */
    public synchronized static String generate() {
        StringBuilder sb = new StringBuilder(32);

        // 1. 前缀
        sb.append("req-");

        // 2. 当前时间（精确到秒）
        sb.append(formatter.format(LocalDateTime.now()));

        // 3. 两段随机十六进制字符串（各6位）
        sb.append('-').append(randomHexString(6));
        sb.append('-').append(randomHexString(6));
        return sb.toString();
    }

    /**
     * 生成指定长度的随机十六进制字符串
     */
    private static String randomHexString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }
}
