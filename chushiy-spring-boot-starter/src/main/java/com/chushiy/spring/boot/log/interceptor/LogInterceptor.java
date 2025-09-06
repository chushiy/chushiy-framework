package com.chushiy.spring.boot.log.interceptor;

import com.alibaba.fastjson.JSON;
import com.chushiy.spring.boot.log.context.ThreadLocalTraceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Author 初时y
 * @DateTime 2023/12/4 下午 9:06
 * @Description 日志记录拦截器
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.log.interceptor
 * @ClassName LogInterceptor.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {

    private static final String START_TIME_ATTRIBUTE = "startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod h = (HandlerMethod) handler;
            log.info("method is {}, param is{} ,path is {}",
                    h.getMethod().getName(), JSON.toJSONString(request.getParameterMap()), request.getRequestURI());
            request.setAttribute(START_TIME_ATTRIBUTE, System.currentTimeMillis());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        Long startTime = (Long) request.getAttribute("startTime");
        if (Objects.nonNull(startTime)) {
            log.info("the url use time is {}", System.currentTimeMillis() - startTime);
        }
        request.removeAttribute(START_TIME_ATTRIBUTE);
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        if (ex != null) {
            String requestId = ThreadLocalTraceContextHolder.getCurrentRequestId();
            log.error("Controller处理异常 - RequestID: {}, Error: {}", requestId, ex.getMessage(), ex);
        }

        // 清理请求属性
        request.removeAttribute(START_TIME_ATTRIBUTE);
    }
}
