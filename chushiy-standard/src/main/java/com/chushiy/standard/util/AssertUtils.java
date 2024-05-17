package com.chushiy.standard.util;

import com.chushiy.standard.exception.BusinessException;
import com.chushiy.standard.function.Consumer;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

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
     * @param expression 布尔表达式
     * @param message    错误信息
     * @param consumer   消费者自己执行的操作
     */
    public static <T> void isTrue(boolean expression, String message, Consumer consumer) {
        if (!expression) {
            consumer.accept();
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
     * 是否为true
     *
     * @param expression 布尔表达式 布尔表达式
     * @param exception  传入指定异常 抛出指定的异常
     */
    public static void isTrue(boolean expression, Exception exception) throws Exception {
        if (!expression) {
            throw exception;
        }
    }

    /**
     * 是否为true
     *
     * @param expression  布尔表达式 布尔表达式
     * @param errSupplier 传入指定异常 抛出指定的异常
     */
    public static <X extends Throwable> void isTrue(boolean expression, Supplier<? extends X> errSupplier) throws X {
        if (!expression) {
            throw errSupplier.get();
        }
    }

    /**
     * 是否为false
     *
     * @param expression 布尔表达式
     * @param message    错误信息
     */
    public static void isFalse(boolean expression, String message) {
        isTrue(!expression, message);
    }

    /**
     * 是否为false
     *
     * @param expression        布尔表达式
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void isFalse(boolean expression, BusinessException businessException) {
        isTrue(!expression, businessException);
    }

    /**
     * 是否为false
     *
     * @param expression 布尔表达式 布尔表达式
     * @param exception  传入运行时异常 抛出指定的异常
     */
    public static void isFalse(boolean expression, RuntimeException exception) {
        isTrue(!expression, exception);
    }

    /**
     * 是否为false
     *
     * @param expression 布尔表达式 布尔表达式
     * @param exception  传入指定异常 抛出指定的异常
     */
    public static void isFalse(boolean expression, Exception exception) throws Exception {
        isTrue(!expression, exception);
    }

    /**
     * 不为空白字符串 ""也不行
     *
     * @param text    需要检查的字符串
     * @param message 错误信息
     */
    public static void isNotBlank(String text, String message) {
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
    public static void isNotBlank(String text, BusinessException businessException) {
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
    public static void isNotBlank(String text, RuntimeException exception) {
        if (StringUtils.isBlank(text)) {
            throw exception;
        }
    }

    public static void isNotBlank(String text, Exception exception) throws Exception {
        if (StringUtils.isBlank(text)) {
            throw exception;
        }
    }

    /**
     * 不为空白字符串 ""也不行
     *
     * @param text    需要检查的字符串
     * @param message 错误信息
     */
    public static void isBlank(String text, String message) {
        if (StringUtils.isNotBlank(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不为空白字符串 ""也不行
     *
     * @param text              需要检查的字符串
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void isBlank(String text, BusinessException businessException) {
        if (StringUtils.isNotBlank(text)) {
            throw businessException;
        }
    }

    /**
     * 不为空白字符串 ""也不行
     *
     * @param text      需要检查的字符串
     * @param exception 传入运行时异常 抛出指定的异常
     */
    public static void isBlank(String text, RuntimeException exception) {
        if (StringUtils.isNotBlank(text)) {
            throw exception;
        }
    }

    /**
     * 不为空白字符串 ""也不行
     *
     * @param text      需要检查的字符串
     * @param exception 传入异常 抛出指定的异常
     * @throws Exception 指定的异常
     */
    public static void isBlank(String text, Exception exception) throws Exception {
        if (StringUtils.isNotBlank(text)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param text    需要检查的字符串    需要检查的字符串
     * @param message 错误信息
     */
    public static void isNotEmpty(String text, String message) {
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
    public static void isNotEmpty(String text, BusinessException businessException) {
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
    public static void isNotEmpty(String text, RuntimeException exception) {
        if (StringUtils.isEmpty(text)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param text      需要检查的字符串
     * @param exception 传入运行时异常 抛出指定的异常
     * @throws Exception 指定的异常
     */
    public static void isNotEmpty(String text, Exception exception) throws Exception {
        if (StringUtils.isEmpty(text)) {
            throw exception;
        }
    }

    /**
     * 为空
     *
     * @param text    需要检查的字符串    需要检查的字符串
     * @param message 错误信息
     */
    public static void isEmpty(String text, String message) {
        if (StringUtils.isNotEmpty(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 为空
     *
     * @param text              需要检查的字符串
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void isEmpty(String text, BusinessException businessException) {
        if (StringUtils.isNotEmpty(text)) {
            throw businessException;
        }
    }

    /**
     * 为空
     *
     * @param text      需要检查的字符串
     * @param exception 传入运行时异常 抛出指定的异常
     */
    public static void isEmpty(String text, RuntimeException exception) {
        if (StringUtils.isNotEmpty(text)) {
            throw exception;
        }
    }

    /**
     * 为空
     *
     * @param text      需要检查的字符串
     * @param exception 传入运行时异常 抛出指定的异常
     * @throws Exception 指定的异常
     */
    public static void isEmpty(String text, Exception exception) throws Exception {
        if (StringUtils.isNotEmpty(text)) {
            throw exception;
        }
    }

    /**
     * 为空
     *
     * @param collection 需要检查的集合
     * @param message    错误信息
     */
    public static void isEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 为空
     *
     * @param collection        需要检查的集合
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void isEmpty(Collection<?> collection, BusinessException businessException) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw businessException;
        }
    }

    /**
     * 为空
     *
     * @param collection 需要检查的集合
     * @param exception  传入运行时异常 抛出指定的异常
     */
    public static void isEmpty(Collection<?> collection, RuntimeException exception) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw exception;
        }
    }

    /**
     * 为空
     *
     * @param collection 需要检查的集合
     * @param exception  传入运行时异常 抛出指定的异常
     * @throws Exception 指定的异常
     */
    public static void isEmpty(Collection<?> collection, Exception exception) throws Exception {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param collection 需要检查的集合
     * @param message    错误信息
     */
    public static void isNotEmpty(Collection<?> collection, String message) {
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
    public static void isNotEmpty(Collection<?> collection, BusinessException businessException) {
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
    public static void isNotEmpty(Collection<?> collection, RuntimeException exception) {
        if (CollectionUtils.isEmpty(collection)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param collection 需要检查的集合
     * @param exception  传入运行时异常 抛出指定的异常
     * @throws Exception 指定的异常
     */
    public static void isNotEmpty(Collection<?> collection, Exception exception) throws Exception {
        if (CollectionUtils.isEmpty(collection)) {
            throw exception;
        }
    }

    /**
     * 为空
     *
     * @param map     需要检查的map
     * @param message 错误信息
     */
    public static void isEmpty(Map<?, ?> map, String message) {
        if (MapUtils.isNotEmpty(map)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 为空
     *
     * @param map               需要检查的map
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void isEmpty(Map<?, ?> map, BusinessException businessException) {
        if (MapUtils.isNotEmpty(map)) {
            throw businessException;
        }
    }

    /**
     * 不为空
     *
     * @param map       需要检查的map
     * @param exception 传入运行时异常 抛出指定的异常
     */
    public static void isEmpty(Map<?, ?> map, RuntimeException exception) {
        if (MapUtils.isNotEmpty(map)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param map       需要检查的map
     * @param exception 传入运行时异常 抛出指定的异常
     * @throws Exception 指定的异常
     */
    public static void isEmpty(Map<?, ?> map, Exception exception) throws Exception {
        if (MapUtils.isNotEmpty(map)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param map     需要检查的map
     * @param message 错误信息
     */
    public static void isNotEmpty(Map<?, ?> map, String message) {
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
    public static void isNotEmpty(Map<?, ?> map, BusinessException businessException) {
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
    public static void isNotEmpty(Map<?, ?> map, RuntimeException exception) {
        if (MapUtils.isEmpty(map)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param map       需要检查的map
     * @param exception 传入运行时异常 抛出指定的异常
     * @throws Exception 指定的异常
     */
    public static void isNotEmpty(Map<?, ?> map, Exception exception) throws Exception {
        if (MapUtils.isEmpty(map)) {
            throw exception;
        }
    }

    /**
     * 为空
     *
     * @param object  需要检查的对象
     * @param message 错误信息
     */
    public static void isEmpty(Object object, String message) {
        if (ObjectUtils.isNotEmpty(object)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 为空
     *
     * @param object            需要检查的对象
     * @param businessException 传入业务异常 抛出指定的义务异常
     */
    public static void isEmpty(Object object, BusinessException businessException) {
        if (ObjectUtils.isNotEmpty(object)) {
            throw businessException;
        }
    }

    /**
     * 为空
     *
     * @param object    需要检查的对象
     * @param exception 传入运行时异常 抛出指定的异常
     */
    public static void isEmpty(Object object, RuntimeException exception) {
        if (ObjectUtils.isNotEmpty(object)) {
            throw exception;
        }
    }

    /**
     * 为空
     *
     * @param object    需要检查的对象
     * @param exception 传入运行时异常 抛出指定的异常
     * @throws Exception 指定的异常
     */
    public static void isEmpty(Object object, Exception exception) throws Exception {
        if (ObjectUtils.isNotEmpty(object)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param object  需要检查的对象
     * @param message 错误信息
     */
    public static void isNotEmpty(Object object, String message) {
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
    public static void isNotEmpty(Object object, BusinessException businessException) {
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
    public static void isNotEmpty(Object object, RuntimeException exception) {
        if (ObjectUtils.isEmpty(object)) {
            throw exception;
        }
    }

    /**
     * 不为空
     *
     * @param object    需要检查的对象
     * @param exception 传入运行时异常 抛出指定的异常
     * @throws Exception 指定的异常
     */
    public static void isNotEmpty(Object object, Exception exception) throws Exception {
        if (ObjectUtils.isEmpty(object)) {
            throw exception;
        }
    }
}
