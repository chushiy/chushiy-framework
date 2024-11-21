package com.chushiy.spring.boot.crypto.advice;

import com.chushiy.crypto.CryptoFactory;
import com.chushiy.crypto.enums.CryptoType;
import com.chushiy.crypto.util.CryptoUtils;
import com.chushiy.spring.boot.crypto.annotation.EncryptResponseBody;
import com.chushiy.standard.pojo.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/5 00:55
 * @Description 给响应体加密
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.advice.crypto
 * @ClassName EncryptResponseBodyAdvice.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
@RestControllerAdvice
@Order(2)
@RequiredArgsConstructor
public class EncryptResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private final ObjectMapper objectMapper;

    private final CryptoFactory cryptoFactory;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 控制器是否标注了EncryptResponse注解 只有标注了才进行加密
        return returnType.hasMethodAnnotation(EncryptResponseBody.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("响应加密开始");
        String bodyStr = null;
        try {
            bodyStr = this.objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            try {
                bodyStr = objectMapper.writeValueAsString(Result.fail());
                log.error("响应加密报错", e);
            } catch (JsonProcessingException ex) {
                log.error("响应加密报错", ex);
            }
        }
        EncryptResponseBody encryptResponseBody = Objects.requireNonNull(returnType.getMethod()).getAnnotation(EncryptResponseBody.class);
        CryptoType type = encryptResponseBody.type();
        String encryptStr = null;
        try {
            encryptStr = this.cryptoFactory.get(type).encrypt(bodyStr);
        } catch (Exception e) {
            encryptStr = "";
        }
        log.info("响应加密:原始响应:{},加密响应:{}", bodyStr, encryptStr);
        return encryptStr;
    }
}
