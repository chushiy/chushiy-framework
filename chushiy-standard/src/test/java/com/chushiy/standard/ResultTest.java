package com.chushiy.standard;

import com.chushiy.standard.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/13 下午 8:12
 * @Description TODO
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard
 * @ClassName ResultTest.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
public class ResultTest {

    @Test
    void testI18nMessage() {
        // I18nConfig.language =Loca
        Result<Void> success = Result.success();
        log.info("success:{}", success);
    }
}
