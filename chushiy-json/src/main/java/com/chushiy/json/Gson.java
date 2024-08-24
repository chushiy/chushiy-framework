package com.chushiy.json;

import com.chushiy.standard.json.JSON;
import com.chushiy.standard.json.JSONParseException;
import com.chushiy.standard.json.exception.JSONSerializationException;
import com.chushiy.standard.pojo.POJO;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/18 下午 6:53
 * @Description gson
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.json
 * @ClassName Gson.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class Gson implements JSON {
    private static final com.google.gson.Gson gSON = new GsonBuilder().create();

    @Override
    public String toJSONString(Serializable obj) throws JSONSerializationException {
        return gSON.toJson(obj);
    }

    @Override
    public String toJSONString(POJO pojo) throws JSONSerializationException {
        return toJSONString((Serializable) pojo);
    }

    @Override
    public <T> T parse(String jSONStr, Class<T> cla) throws JSONParseException {
        return gSON.fromJson(jSONStr, cla);
    }

    @Override
    public Object get(String jSONStr, String key) throws JSONParseException {
        JsonObject jsonObject = gSON.fromJson(jSONStr, JsonObject.class);
        JsonElement element = jsonObject.get(key);
        return element != null ? element.getAsString() : null;
    }

    @Override
    public boolean has(String jSONStr, String key) throws JSONParseException {
        JsonObject jsonObject = gSON.fromJson(jSONStr, JsonObject.class);
        return jsonObject.has(key);
    }

    @Override
    public String remove(String jSONStr, String key) throws JSONParseException {
        JsonObject jsonObject = gSON.fromJson(jSONStr, JsonObject.class);
        if (jsonObject.has(key)) {
            jsonObject.remove(key);
            return jsonObject.toString();
        } else {
            // 如果key不存在，原样返回
            return jSONStr;
        }
    }
}
