package com.chushiy.spring.boot3.log.filter;

import cn.hutool.extra.servlet.JakartaServletUtil;
import com.chushiy.spring.boot3.log.context.ThreadLocalTraceContextHolder;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/9/6 18:00
 * @Description 请求日志过滤器 记录HTTP请求的详细信息，包括请求参数、响应状态、执行时间等
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.log.filter
 * @ClassName RequestLogFilter.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
public class RequestLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        long startTime = System.currentTimeMillis();
        String requestId = ThreadLocalTraceContextHolder.getCurrentRequestId();

        try {
            // 记录请求开始日志
            logRequestStart(httpRequest, requestId);

            // 继续处理请求
            chain.doFilter(request, response);

            // 记录请求完成日志
            long duration = System.currentTimeMillis() - startTime;
            logRequestEnd(httpRequest, httpResponse, requestId, duration);

        } catch (Exception e) {
            // 记录请求异常日志
            long duration = System.currentTimeMillis() - startTime;
            logRequestError(httpRequest, requestId, duration, e);
            throw e;
        }
    }

    /**
     * 记录请求开始日志
     */
    private void logRequestStart(HttpServletRequest request, String requestId) {
        if (!log.isInfoEnabled()) {
            return;
        }

        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String clientIp = JakartaServletUtil.getClientIP(request);

        StringBuilder logMsg = new StringBuilder();
        logMsg.append("HTTP请求开始 - ");
        logMsg.append("RequestID: ").append(requestId).append(", ");
        logMsg.append("Method: ").append(method).append(", ");
        logMsg.append("URI: ").append(uri);

        if (queryString != null) {
            logMsg.append("?").append(queryString);
        }

        logMsg.append(", ClientIP: ").append(clientIp);

        // 记录重要的HTTP头
        String userAgent = request.getHeader("User-Agent");
        if (userAgent != null) {
            logMsg.append(", UserAgent: ").append(userAgent);
        }

        String contentType = request.getContentType();
        if (contentType != null) {
            logMsg.append(", ContentType: ").append(contentType);
        }

        log.info(logMsg.toString());
    }

    /**
     * 记录请求完成日志
     */
    private void logRequestEnd(HttpServletRequest request, HttpServletResponse response,
                               String requestId, long duration) {
        if (!log.isInfoEnabled()) {
            return;
        }

        String method = request.getMethod();
        String uri = request.getRequestURI();
        int status = response.getStatus();

        StringBuilder logMsg = new StringBuilder();
        logMsg.append("HTTP请求完成 - ");
        logMsg.append("RequestID: ").append(requestId).append(", ");
        logMsg.append("Method: ").append(method).append(", ");
        logMsg.append("URI: ").append(uri).append(", ");
        logMsg.append("Status: ").append(status).append(", ");
        logMsg.append("Duration: ").append(duration).append("ms");

        // 根据响应状态选择日志级别
        if (status >= 500) {
            log.error(logMsg.toString());
        } else if (status >= 400) {
            log.warn(logMsg.toString());
        } else {
            log.info(logMsg.toString());
        }
    }

    /**
     * 记录请求异常日志
     */
    private void logRequestError(HttpServletRequest request, String requestId,
                                 long duration, Exception e) {
        String method = request.getMethod();
        String uri = request.getRequestURI();

        StringBuilder logMsg = new StringBuilder();
        logMsg.append("HTTP请求异常 - ");
        logMsg.append("RequestID: ").append(requestId).append(", ");
        logMsg.append("Method: ").append(method).append(", ");
        logMsg.append("URI: ").append(uri).append(", ");
        logMsg.append("Duration: ").append(duration).append("ms, ");
        logMsg.append("Error: ").append(e.getMessage());

        log.error(logMsg.toString(), e);
    }

}
