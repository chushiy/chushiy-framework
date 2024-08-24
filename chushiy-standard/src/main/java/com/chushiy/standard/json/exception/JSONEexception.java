package com.chushiy.standard.json.exception;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/28 下午 9:25
 * @Description JSON异常 顶级类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.json.exception
 * @ClassName JSONEexception.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class JSONEexception extends RuntimeException {

    private JSONEexception() {
    }

    public JSONEexception(String message) {
        super(message);
    }

    public JSONEexception(Throwable cause) {
        super(cause);
    }
}
