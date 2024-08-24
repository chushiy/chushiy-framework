package com.chushiy.standard.json;

import com.chushiy.standard.json.exception.JSONSerializationException;
import com.chushiy.standard.pojo.POJO;

import java.io.Serializable;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 上午 11:30
 * @Description JSON接口
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.json
 * @ClassName JSON.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface JSON {

    /**
     * 转换为JSON字符串
     *
     * @param obj 对象
     * @return JSON字符串
     */
    String toJSONString(Serializable obj) throws JSONSerializationException;

    /**
     * 转换为JSON字符串
     *
     * @param pojo pojo
     * @return JSON字符串
     */
    String toJSONString(POJO pojo) throws JSONSerializationException;

    /**
     * 解析成指定的class
     *
     * @param jSONStr JSON字符串
     * @param cla     被解析类的class
     * @return 被解析类的class的实例
     */
    <T> T parse(String jSONStr, Class<T> cla) throws JSONParseException;

    /**
     * 获取指定key的值 没有则返回null
     *
     * @param jSONStr JSON字符串
     * @param key     键
     * @return 指定key的值
     */

    Object get(String jSONStr, String key) throws JSONParseException;

    /**
     * 是否有指定的key
     *
     * @param jSONStr JSON字符串
     * @param key     键
     * @return true/false true 包含 false 不包含
     */
    boolean has(String jSONStr, String key) throws JSONParseException;

    /**
     * 移除指定的key并返回移除后的JSON字符串
     *
     * @param jSONStr JSON字符串
     * @param key     键
     * @return 移除后的JSON字符串
     */
    String remove(String jSONStr, String key) throws JSONParseException;
}
