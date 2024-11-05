package com.chushiy.spring.boot.autoconfigure.advice;

import com.chushiy.spring.boot.autoconfigure.annotation.ControllerResponse;
import com.chushiy.standard.pojo.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/5 14:20
 * @Description controller包装响应
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.autoconfigure.advice
 * @ClassName ControllerResponseAdvice.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        boolean isResult = returnType.getParameterType().isAssignableFrom(Result.class);
        boolean isModelAndView = returnType.getParameterType().equals(ModelAndView.class);
        // region 如果加了@ControllerResponse enable = true正常执行 =false则不包装 没有加该注解也进行包装
        ControllerResponse controllerResponse =
                returnType.getMethod().getAnnotation(ControllerResponse.class);
        // endregion
        return !isResult && !isModelAndView
                && (ObjectUtils.isEmpty(controllerResponse) || controllerResponse.enable());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (returnType.getGenericParameterType().equals(String.class)) {
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
