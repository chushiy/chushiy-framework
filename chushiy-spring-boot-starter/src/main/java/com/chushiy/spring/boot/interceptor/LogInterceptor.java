package com.chushiy.spring.boot.interceptor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
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
 * @PackageName com.chushiy.spring.boot.interceptor
 * @ClassName LogInterceptor.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod h = (HandlerMethod) handler;
            log.info("method is {}, param is{} ,path is {}", h.getMethod().getName(), JSON.toJSONString(request.getParameterMap()), request.getRequestURI());
            request.setAttribute("startTime", System.currentTimeMillis());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Long startTime = (Long) request.getAttribute("startTime");
        if (Objects.nonNull(startTime)) {
            log.info("the url use time is {}", System.currentTimeMillis() - startTime);
        }
        request.removeAttribute("startTime");
    }

}
