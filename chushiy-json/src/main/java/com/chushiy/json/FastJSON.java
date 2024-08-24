package com.chushiy.json;

import com.alibaba.fastjson.JSONObject;
import com.chushiy.standard.json.JSON;
import com.chushiy.standard.json.JSONParseException;
import com.chushiy.standard.json.exception.JSONSerializationException;
import com.chushiy.standard.pojo.POJO;

import java.io.Serializable;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 上午 11:44
 * @Description fast-JSON实现
 * @ProjectName chushiy
 * @PackageName com.chushiy.json
 * @ClassName FastJSON.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class FastJSON implements JSON {

    @Override
    public String toJSONString(Serializable obj) throws JSONSerializationException {
        return com.alibaba.fastjson.JSON.toJSONString(obj);
    }

    @Override
    public String toJSONString(POJO pojo) throws JSONSerializationException {
        return this.toJSONString((Serializable) pojo);
    }

    @Override
    public <T> T parse(String jSONStr, Class<T> cla) throws JSONParseException {
        return com.alibaba.fastjson.JSON.parseObject(jSONStr, cla);
    }

    @Override
    public Object get(String jSONStr, String key) throws JSONParseException {
        return com.alibaba.fastjson.JSON.parseObject(jSONStr).get(key);
    }

    @Override
    public boolean has(String jSONStr, String key) throws JSONParseException {
        return com.alibaba.fastjson.JSON.parseObject(jSONStr).containsKey(key);
    }

    @Override
    public String remove(String jSONStr, String key) throws JSONParseException {
        JSONObject jsonObject = com.alibaba.fastjson.JSON.parseObject(jSONStr);
        jsonObject.remove(key);
        return jsonObject.toJSONString();
    }
}
