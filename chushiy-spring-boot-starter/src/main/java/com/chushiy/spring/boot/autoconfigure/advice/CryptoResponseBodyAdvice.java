package com.chushiy.spring.boot.autoconfigure.advice;

import com.chushiy.crypto.enums.CryptoType;
import com.chushiy.crypto.util.CryptoUtils;
import com.chushiy.spring.boot.autoconfigure.annotation.CryptoResponse;
import com.chushiy.standard.pojo.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/5 00:55
 * @Description 加密响应advice
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.autoconfigure.advice
 * @ClassName CryptoResponseBodyAdvice.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
public class CryptoResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 控制器是否标注了CryptoResponse注解 只有标注了才进行加密
        CryptoResponse cryptoResponse = returnType.getMethod().getAnnotation(CryptoResponse.class);
        return ObjectUtils.isNotEmpty(cryptoResponse);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        String bodyStr = null;
        try {
            bodyStr = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            try {
                bodyStr = objectMapper.writeValueAsString(Result.fail());
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        }
        CryptoResponse cryptoResponse = returnType.getMethod().getAnnotation(CryptoResponse.class);
        CryptoType type = cryptoResponse.type();
        String encryptStr = CryptoUtils.getCrypto(type).encrypt(bodyStr);
        if (log.isDebugEnabled()) {
            log.info("响应加密:原始响应:{},加密响应:{}", bodyStr, encryptStr);
        }
        return encryptStr;
    }
}
