package com.chushiy.spring.boot.advice;

import com.chushiy.spring.boot.annotation.ControllerResponse;
import com.chushiy.standard.pojo.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/5 14:20
 * @Description controller包装响应
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.advice
 * @ClassName ControllerResponseAdvice.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
@RestControllerAdvice
@Order(-1)
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        boolean isResult = returnType.getParameterType().isAssignableFrom(Result.class);
        boolean isModelAndView = returnType.getParameterType().equals(ModelAndView.class);
        return !isResult && !isModelAndView && returnType.hasMethodAnnotation(ControllerResponse.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (returnType.getGenericParameterType().equals(String.class)) {
            log.info("Controller返回对象包装开始");
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(Result.success(body));
            } catch (JsonProcessingException ex) {
                return Result.fail();
            }
        } else {
            return Result.success(body);
        }
    }
}
