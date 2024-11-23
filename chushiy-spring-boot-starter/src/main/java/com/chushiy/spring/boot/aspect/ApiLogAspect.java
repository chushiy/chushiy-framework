package com.chushiy.spring.boot.aspect;

import com.alibaba.fastjson2.JSON;
import com.chushiy.standard.ip.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/23 17:41
 * @Description Api接口日志注解切面实现
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.aspect
 * @ClassName ApiLogAspect.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
@Component
@Aspect
public class ApiLogAspect {

    /**
     * 切点
     * 方法上或者类上
     */
    @Pointcut("@annotation(com.chushiy.spring.boot.annotation.ApiLog) || @within(com.chushiy.spring.boot.annotation.ApiLog)")
    public void apiLogPointcut() {
    }

    @Around("apiLogPointcut()")
    public Object apiLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            // 记录请求信息
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            // 请求ip
            String ip = IpUtils.getIpAddr(request);
            // 请求uri
            String uri = request.getRequestURI();
            // 请求方法
            String method = request.getMethod();
            // 请求参数
            String params = JSON.toJSONString(filterRequestParams(joinPoint.getArgs()));
            // 请求方法签名
            Signature signature = joinPoint.getSignature();
            // 接口返回结果
            Object result = JSON.toJSONString(joinPoint.proceed());
            // 耗时
            long elapsedTime = System.currentTimeMillis() - start;

            log.info("\n\r======================================================================\n\r" +
                            "请求ip:{} \n\r" +
                            "请求地址:{} \n\r" +
                            "请求方式:{} \n\r" +
                            "请求类方法:{} \n\r" +
                            "请求方法参数:{} \n\r" +
                            "返回结果:{} \n\r" +
                            "处理耗时:{}ms \n\r" +
                            "\n\r======================================================================\n\r",
                    ip, uri, method, signature, params, result, elapsedTime
            );

            return result;
        } catch (Exception e) {
            log.error("日志记录异常=>", e);
            throw e;
        }
    }

    /**
     * 过滤掉请求的参数
     *
     * @param args 请求参数
     * @return List<Object>
     */
    private static List<Object> filterRequestParams(Object[] args) {
        return Arrays.stream(args).filter(arg ->
                        !(arg instanceof MultipartFile)
                                && !(arg instanceof HttpServletRequest)
                                && !(arg instanceof HttpServletResponse)
                )
                .collect(Collectors.toList());
    }
}
