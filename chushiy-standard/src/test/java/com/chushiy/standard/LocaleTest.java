package com.chushiy.standard;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Locale;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/13 下午 7:53
 * @Description test
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard
 * @ClassName LocaleTest.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
public class LocaleTest {

    @Test
    void test() {
        Locale locale = Locale.SIMPLIFIED_CHINESE;
        log.info("locale={}", locale);
        log.info(locale.toString());
    }
}
