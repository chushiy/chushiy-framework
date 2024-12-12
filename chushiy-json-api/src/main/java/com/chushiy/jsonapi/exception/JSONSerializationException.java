package com.chushiy.jsonapi.exception;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/28 下午 9:20
 * @Description JSON序列化异常 <br> 将对象转换JSON中出现遇到对象结构不符合JSON规范或者存在无法序列化的字段（如循环引用、非Serializable类型等）
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.jsonapi.exception
 * @ClassName JSONSerializationException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class JSONSerializationException extends JSONEexception {

    public JSONSerializationException(String message) {
        super(message);
    }

    public JSONSerializationException(Throwable cause) {
        super(cause);
    }
}
