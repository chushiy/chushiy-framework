package com.chushiy.standard.i18n;

import com.chushiy.standard.exception.BusinessException;

import java.util.Locale;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/8 下午 11:07
 * @Description 统一返回结果国际化message组装
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.i18n
 * @ClassName ResultI18nMessageAssembler.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface ResultI18nMessageAssembler {

    /**
     * 返回国际化message
     *
     * @param language 语言
     * @param businessException 业务异常
     * @return 返回对应的国际化信息
     */
    String assembler(Locale language,BusinessException businessException);

    /**
     *
     * @param language 语言
     * @param originMessage 原始信息
     * @return 返回对应的国际化信息
     */
    String assembler(Locale language,String originMessage);
}
