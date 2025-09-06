package com.chushiy.spring.boot.advice;

import cn.hutool.core.lang.Assert;
import com.chushiy.spring.boot.log.context.ThreadLocalTraceContextHolder;
import com.chushiy.standard.pojo.Result;
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
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/9/6 18:54
 * @Description 链路追踪信息处理
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.advice
 * @ClassName TraceAdvice.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
// 在ControllerResponseAdvice之后
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class TraceAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Assert.notNull(returnType, "returnType is null");
        // 部分接口不一定返回Result
        if (body instanceof Result) {
            Result result = (Result) body;
            result.setTraceId(ThreadLocalTraceContextHolder.getCurrentTraceId());
            if (log.isDebugEnabled()) {
                log.info("设置traceId");
            }
            return result;
        }
        return body;
    }
}
