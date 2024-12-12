package com.chushiy.json;

import com.chushiy.jsonapi.JSON;
import com.chushiy.jsonapi.exception.JSONParseException;
import com.chushiy.jsonapi.exception.JSONSerializationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/18 下午 6:51
 * @Description jackJSON
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.json
 * @ClassName JackJSON.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
public class JackJSON implements JSON {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String toJSONString(Serializable obj) throws JSONSerializationException {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("JackJSON writeValueAsString error", e);
            throw new JSONSerializationException(e);
        }
    }

    @Override
    public String toJSONString(Object obj) throws JSONSerializationException {
        return toJSONString((Serializable) obj);
    }

    @Override
    public <T> T parse(String jSONStr, Class<T> cla) throws JSONParseException {
        try {
            return objectMapper.readValue(jSONStr, cla);
        } catch (JsonProcessingException e) {
            log.error("JackJSON readValue error", e);
            throw new JSONParseException(e);
        }
    }

    @Override
    public Object get(String jSONStr, String key) throws JSONParseException {
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(jSONStr);
        } catch (JsonProcessingException e) {
            log.error("JackJSON readTree error", e);
            throw new JSONParseException(e);
        }
        JsonNode valueNode = jsonNode.get(key);
        return valueNode != null ? valueNode.asText() : null;
    }

    @Override
    public boolean has(String jSONStr, String key) throws JSONParseException {
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(jSONStr);
        } catch (JsonProcessingException e) {
            log.error("JackJSON readTree error", e);
            throw new JSONParseException(e);
        }
        return jsonNode.has(key);
    }

    @Override
    public String remove(String jSONStr, String key) throws JSONParseException {
        try {
            ObjectNode objectNode = (ObjectNode) objectMapper.readTree(jSONStr);
            if (objectNode.has(key)) {
                objectNode.remove(key);
                return objectMapper.writeValueAsString(objectNode);
            } else {
                // 如果key不存在，原样返回
                return jSONStr;
            }
        } catch (JsonProcessingException e) {
            log.error("JackJSON readTree | writeValueAsString error", e);
            throw new JSONParseException(e);
        }
    }
}
