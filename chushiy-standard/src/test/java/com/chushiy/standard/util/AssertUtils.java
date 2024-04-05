package com.chushiy.standard.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/6 下午 10:20
 * @Description TODO
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.util
 * @ClassName AssertUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class AssertUtils {

    @Test
    void testAcc() {
        Assert.isTrue(false, "error");
    }
}
