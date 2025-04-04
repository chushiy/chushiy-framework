package com.chushiy.standard.util;

import cn.hutool.core.lang.Assert;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/4/4 13:45
 * @Description chushiy工具类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.util
 * @ClassName ChuShiyUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class ChuShiyUtils {

    public static final String CHUSHIY = "chushiy";

    /**
     * 验证值是否正确
     *
     * @param val 验证值
     * @throws IllegalArgumentException exception
     */
    public static void verify(String val) throws IllegalArgumentException {
        Assert.isTrue(CHUSHIY.equals(val));
    }
}
