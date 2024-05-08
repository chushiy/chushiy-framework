package com.chushiy.json;

import com.alibaba.fastjson.TypeReference;
import com.chushiy.standard.json.JSON;
import com.chushiy.standard.pojo.POJO;

import java.util.Collection;
import java.util.Map;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 上午 11:44
 * @Description fastJSON实现
 * @ProjectName chushiy
 * @PackageName com.chushiy.json
 * @ClassName FastJSON.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
// TODO 完美考虑继承 alibaba JSON
public final class FastJSON implements JSON, com.alibaba.fastjson2.JSON {
    @Override
    public String toString(POJO pojo) {
        return com.alibaba.fastjson.JSON.toJSONString(pojo);
    }

    @Override
    public String toString(Map<String, Object> map) {
        return com.alibaba.fastjson.JSON.toJSONString(map);
    }

    @Override
    public String toString(Collection<Object> collection) {
        return com.alibaba.fastjson.JSON.toJSONString(collection);
    }

    @Override
    public <T> T parse(String jsonStr, Class<T> cla) {
        return com.alibaba.fastjson.JSON.parseObject(jsonStr, cla);
    }

    @Override
    public Map<String, Object> parse(String jsonStr) {
        return com.alibaba.fastjson.JSON.parseObject(jsonStr, new TypeReference<Map<String, Object>>() {
        });
    }

    @Override
    public <T> Collection<T> parseList(String jsonStr, Class<T> cla) {
        return com.alibaba.fastjson.JSON.parseObject(jsonStr, new TypeReference<Collection<T>>() {
        });
    }
}
