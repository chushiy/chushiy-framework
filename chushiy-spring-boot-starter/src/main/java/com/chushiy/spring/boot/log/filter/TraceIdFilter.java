package com.chushiy.spring.boot.log.filter;

import cn.hutool.extra.servlet.ServletUtil;
import com.chushiy.spring.boot.log.constant.LogConstant;
import com.chushiy.spring.boot.log.context.ThreadLocalTraceContextHolder;
import com.chushiy.spring.boot.log.context.TraceContext;
import com.chushiy.spring.boot.log.util.RequestIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/9/6 17:48
 * @Description 链路追踪ID过滤器 为每个HTTP请求初始化或传递追踪上下文 支持从HTTP头中读取上游传递的追踪信息
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.log.filter
 * @ClassName TraceIdFilter.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
public class TraceIdFilter implements Filter {

    /**
     * HTTP头常量
     */
    private static final String HEADER_REQUEST_ID = "X-Request-ID";
    private static final String HEADER_TRACE_ID = "X-Trace-ID";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            // 初始化追踪上下文
            TraceContext traceContext = initializeTraceContext(httpRequest);

            // 将追踪ID写入响应头
            writeTraceHeaders(httpResponse, traceContext);

            // 存入MDC
            MDC.put(LogConstant.TRACE_ID, traceContext.getTraceId());

            log.debug("请求开始 - URI: {}, 追踪信息: {}",
                    httpRequest.getRequestURI(), traceContext);

            // 继续处理请求
            chain.doFilter(request, response);

        } finally {
            // 清理ThreadLocal，防止内存泄漏
            ThreadLocalTraceContextHolder.clear();
            // 结束后清除 MDC，防止线程复用导致 traceId 污染
            MDC.clear();
            log.debug("请求结束 - URI: {}, 上下文已清理", httpRequest.getRequestURI());
        }
    }

    /**
     * 初始化追踪上下文
     */
    private TraceContext initializeTraceContext(HttpServletRequest request) {
        // 尝试从HTTP头中获取上游传递的追踪信息
        String requestId = getHeaderValue(request, HEADER_REQUEST_ID);
        String traceId = getHeaderValue(request, HEADER_TRACE_ID);

        TraceContext traceContext;

        if (traceId != null) {
            // 如果有上游追踪ID，继续使用
            traceContext = new TraceContext(
                    requestId != null ? requestId : RequestIdGenerator.generate(),
                    traceId
            );
            log.debug("继续上游追踪链路 - TraceID: {}", traceId);
        } else {
            // 否则创建新的追踪链路
            ThreadLocalTraceContextHolder.initTrace();
            traceContext = ThreadLocalTraceContextHolder.getTraceContext();
            log.debug("开始新的追踪链路 - TraceID: {}", traceContext.getTraceId());
        }

        // 添加HTTP请求信息
        traceContext.addExtra("method", request.getMethod());
        traceContext.addExtra("uri", request.getRequestURI());
        traceContext.addExtra("remoteAddr", ServletUtil.getClientIP(request));
        traceContext.addExtra("userAgent", request.getHeader("User-Agent"));

        // 设置到ThreadLocal
        ThreadLocalTraceContextHolder.setTraceContext(traceContext);

        return traceContext;
    }

    /**
     * 将追踪信息写入响应头
     */
    private void writeTraceHeaders(HttpServletResponse response, TraceContext traceContext) {
        if (traceContext != null) {
            response.setHeader(HEADER_REQUEST_ID, traceContext.getRequestId());
            response.setHeader(HEADER_TRACE_ID, traceContext.getTraceId());
        }
    }

    /**
     * 获取HTTP头值
     */
    private String getHeaderValue(HttpServletRequest request, String headerName) {
        String value = request.getHeader(headerName);
        return (value != null && !value.trim().isEmpty()) ? value.trim() : null;
    }

}
