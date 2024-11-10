package com.chushiy.spring.boot;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 16:38
 * @Description TestStringUtils
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot
 * @ClassName TestStringUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class TestStringUtils {

    @Test
    public void test1() {
        String str = null;
        System.out.println(StringUtils.isBlank(str));
    }
}
