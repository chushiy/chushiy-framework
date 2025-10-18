package com.chushiy.spring.boot3.log.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.filter.OrderedFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 4:59
 * @Description 日志
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.log.filter
 * @ClassName LogFilter.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
public class LogFilter implements OrderedFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 打印请求信息
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.info("------------- LogFilter 开始 -------------");
        log.info("请求地址: {} {}", httpServletRequest.getRequestURL().toString(), httpServletRequest.getMethod());
        log.info("远程地址: {}", httpServletRequest.getRemoteAddr());
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        log.info("------------- LogFilter 结束 耗时：{} ms -------------", System.currentTimeMillis() - startTime);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
