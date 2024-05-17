package com.chushiy.standard.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/4/8 下午 9:08
 * @Description 日期工具
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.util
 * @ClassName DateUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
public final class DateUtils {

    /**
     * 遍历指定的日期格式 转换成功了直接返回 否则抛出ParseException
     *
     * @param dateStr       要转换的日期字符串
     * @param parsePatterns 日期格式
     * @return LocalDate
     * @throws ParseException 转换异常
     */
    public static LocalDate parse(String dateStr, String... parsePatterns) throws ParseException {
        for (String pattern : parsePatterns) {
            try {
                return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
            } catch (Exception e) {
                log.error("parse date error, dateStr: {}, pattern: {}", dateStr, pattern);
            }
        }
        throw new ParseException("Unable to parse the date: " + dateStr, -1);
    }

}
