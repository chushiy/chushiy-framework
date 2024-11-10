package com.chushiy.spring.boot.crypto.advice;

import com.chushiy.crypto.enums.CryptoType;
import com.chushiy.crypto.util.CryptoUtils;
import com.chushiy.spring.boot.crypto.annotation.DecryptRequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 11:17
 * @Description 给请求体参数解密
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.crypto.advice
 * @ClassName DecryptRequestBodyAdvice.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
@Order(2)
@RestControllerAdvice
public class DecryptRequestBodyAdvice extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 参数被标注了DecryptRequestBody注解
        return methodParameter.hasParameterAnnotation(DecryptRequestBody.class);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        String encryptBodyStr = new String(StreamUtils.copyToByteArray(inputMessage.getBody()));
        DecryptRequestBody decryptRequestBody = parameter.getMethodAnnotation(DecryptRequestBody.class);
        // 获取指定的加密类型
        assert decryptRequestBody != null;
        CryptoType cryptoType = decryptRequestBody.type();
        // 解密
        String decryptBodyStr = null;
        try {
            decryptBodyStr = CryptoUtils.getCrypto(cryptoType).decrypt(encryptBodyStr);
        } catch (Exception e) {
            decryptBodyStr = "";
        }
        log.info("body解密。密文:{}，明文:{}", encryptBodyStr, decryptBodyStr);
        String finalDecryptBodyStr = decryptBodyStr;
        return new HttpInputMessage() {
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(finalDecryptBodyStr.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                return inputMessage.getHeaders();
            }
        };
    }
}
