package com.chushiy.standard.json;

import com.chushiy.standard.pojo.POJO;

import java.util.Collection;
import java.util.Map;

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

    String toString(POJO pojo);

    String toString(Map<String, Object> map);

    String toString(Collection<Object> collection);

    <T> T parse(String jsonStr, Class<T> cla);

    Map<String, Object> parse(String jsonStr);

    <T> Collection<T> parseList(String jsonStr, Class<T> cla);
}
