package com.chushiy.jsonapi.exception;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/19 下午 1:41
 * @Description JSON解析异常 <br> 将JSON字符串解析成指定的类型时出现的异常
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.jsonapi.exception
 * @ClassName JSONParseException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class JSONParseException extends JSONEexception {
    public JSONParseException(String message) {
        super(message);
    }

    public JSONParseException(Throwable cause) {
        super(cause);
    }
}
