package com.chushiy.spring.boot.advice;

import com.chushiy.spring.boot.annotation.ControllerResponse;
import com.chushiy.standard.pojo.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.Ordered;
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
// 最高优先级
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    private final ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        boolean isResult = returnType.getParameterType().isAssignableFrom(Result.class);
        boolean isModelAndView = returnType.getParameterType().equals(ModelAndView.class);
        return !isResult && !isModelAndView && returnType.hasMethodAnnotation(ControllerResponse.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 避免重复包裹
        if (body instanceof Result) {
            return body;
        }
        log.info("Controller返回对象包装开始");
        if (returnType.getGenericParameterType().equals(String.class)) {
            try {
                return this.objectMapper.writeValueAsString(Result.success(body));
            } catch (JsonProcessingException ex) {
                return Result.fail();
            }
        } else {
            return Result.success(body);
        }
    }
}
