package com.chushiy.spring.boot.aspect;

import com.alibaba.fastjson2.JSON;
import com.chushiy.standard.ip.Ip2regionUtils;
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

        // 记录请求信息
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 请求ip
        String ip = IpUtils.getIpAddr(request);
        // 请求
        String Ip2region = Ip2regionUtils.getIp2Region(ip);
        // 请求uri
        String uri = request.getRequestURI();
        // 请求方法
        String method = request.getMethod();
        // 请求参数
        String params = JSON.toJSONString(filterRequestParams(joinPoint.getArgs()));
        // 请求方法签名
        Signature signature = joinPoint.getSignature();

        try {
            Object result = null;

            // 接口返回结果
            result = joinPoint.proceed();

            // 耗时
            long elapsedTime = System.currentTimeMillis() - start;

            Object resultString = JSON.toJSONString(result);
            log.info(
                    "\n=============== API 请求日志 ===============\n" +
                            "客户端IP: {}\n" +
                            "IP归属地: {}\n" +
                            "请求路径: {}\n" +
                            "请求方式: {}\n" +
                            "请求类方法: {}\n" +
                            "请求参数: {}\n" +
                            "处理耗时: {}ms\n" +
                            "返回结果: {}\n" +
                            "=============================================",
                    ip, Ip2region, uri, method, signature, params, elapsedTime, resultString
            );
            return result;
        } catch (Exception e) {
            long elapsedTime = System.currentTimeMillis() - start;
            log.error(
                    "\n=============== API 请求失败 ❌ ===============\n" +
                            "客户端IP: {}\n" +
                            "IP归属地: {}\n" +
                            "请求路径: {}\n" +
                            "请求方式: {}\n" +
                            "请求类方法: {}\n" +
                            "请求参数: {}\n" +
                            "处理耗时: {}ms\n" +
                            "-----------------------------------------------\n" +
                            "异常信息:\n" +
                            "{}\n" +
                            "===============================================",
                    ip,
                    Ip2region,
                    uri,
                    method,
                    signature,
                    params,
                    elapsedTime,
                    e.getMessage()
            );
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
