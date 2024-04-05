package com.chushiy.standard.util;

import com.chushiy.standard.exception.BusinessException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/6 下午 10:34
 * @Description 断言工具类 不传入Exception 则默认抛出IllegalArgumentException
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.util
 * @ClassName AssertUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class AssertUtils {

    /**
     * 是否为true
     *
     * @param expression 布尔表达式
     * @param message    错误信息
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 是否为true
     *
     * @param expression        布尔表达式
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void isTrue(boolean expression, BusinessException businessException) {
        if (!expression) {
            throw businessException;
        }
    }

    /**
     * 是否为true
     *
     * @param expression 布尔表达式 布尔表达式
     * @param exception  传入运行时异常 抛出指定的异常
     */
    public static void isTrue(boolean expression, RuntimeException exception) {
        if (!expression) {
            throw exception;
        }
    }

    /**
     * 不为空白字符串 ""也不行
     *
     * @param text    需要检查的字符串
     * @param message 错误信息
     */
    public static void notBlank(String text, String message) {
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不为空白字符串 ""也不行
     *
     * @param text              需要检查的字符串
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void notBlank(String text, BusinessException businessException) {
        if (StringUtils.isBlank(text)) {
            throw businessException;
        }
    }

    /**
     * 不为空白字符串 ""也不行
     *
     * @param text      需要检查的字符串
     * @param exception 传入运行时异常 抛出指定的异常
     */
    public static void notBlank(String text, RuntimeException exception) {
        if (StringUtils.isBlank(text)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param text    需要检查的字符串    需要检查的字符串
     * @param message 错误信息
     */
    public static void notEmpty(String text, String message) {
        if (StringUtils.isEmpty(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不为空
     *
     * @param text              需要检查的字符串
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void notEmpty(String text, BusinessException businessException) {
        if (StringUtils.isEmpty(text)) {
            throw businessException;
        }
    }

    /**
     * 不为空
     *
     * @param text      需要检查的字符串
     * @param exception 传入运行时异常 抛出指定的异常
     */
    public static void notEmpty(String text, RuntimeException exception) {
        if (StringUtils.isEmpty(text)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param collection 需要检查的集合
     * @param message    错误信息
     */
    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不为空
     *
     * @param collection        需要检查的集合
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void notEmpty(Collection<?> collection, BusinessException businessException) {
        if (CollectionUtils.isEmpty(collection)) {
            throw businessException;
        }
    }

    /**
     * 不为空
     *
     * @param collection 需要检查的集合
     * @param exception  传入运行时异常 抛出指定的异常
     */
    public static void notEmpty(Collection<?> collection, RuntimeException exception) {
        if (CollectionUtils.isEmpty(collection)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param map     需要检查的map
     * @param message 错误信息
     */
    public static void notEmpty(Map<?, ?> map, String message) {
        if (MapUtils.isEmpty(map)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不为空
     *
     * @param map               需要检查的map
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void notEmpty(Map<?, ?> map, BusinessException businessException) {
        if (MapUtils.isEmpty(map)) {
            throw businessException;
        }
    }

    /**
     * 不为空
     *
     * @param map       需要检查的map
     * @param exception 传入运行时异常 抛出指定的异常
     */
    public static void notEmpty(Map<?, ?> map, RuntimeException exception) {
        if (MapUtils.isEmpty(map)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param object  需要检查的对象
     * @param message 错误信息
     */
    public static void notEmpty(Object object, String message) {
        if (ObjectUtils.isEmpty(object)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不为空
     *
     * @param object            需要检查的对象
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void notEmpty(Object object, BusinessException businessException) {
        if (ObjectUtils.isEmpty(object)) {
            throw businessException;
        }
    }

    /**
     * 不为空
     *
     * @param object    需要检查的对象
     * @param exception 传入运行时异常 抛出指定的异常
     */
    public static void notEmpty(Object object, RuntimeException exception) {
        if (ObjectUtils.isEmpty(object)) {
            throw exception;
        }
    }
}
