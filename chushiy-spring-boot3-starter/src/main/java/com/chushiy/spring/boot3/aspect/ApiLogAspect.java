package com.chushiy.spring.boot3.aspect;

import cn.hutool.core.util.ObjUtil;
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
    @Pointcut("@annotation(com.chushiy.spring.boot3.annotation.ApiLog) || @within(com.chushiy.spring.boot3.annotation.ApiLog)")
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
            Object result = null;
            Throwable exception = null;

            try {
                // 接口返回结果
                result = joinPoint.proceed();
            } catch (Throwable e) {
                exception = e;
            }

            // 耗时
            long elapsedTime = System.currentTimeMillis() - start;

            if (ObjUtil.isNull(exception)) {
                Object resultString = JSON.toJSONString(result);
                // log.info(
                //         "\n\n\r======================================================================\n\r" +
                //                 "请求ip=>     {} \n\r" +
                //                 "ip地址=>     {} \n\r" +
                //                 "请求地址=>    {} \n\r" +
                //                 "请求方式=>    {} \n\r" +
                //                 "请求类方法=>   {} \n\r" +
                //                 "请求方法参数=>  {} \n\r" +
                //                 "处理耗时=>     {}ms \n\r" +
                //                 "返回结果=>     {} \n\r" +
                //                 "======================================================================\n\r",
                //         ip, Ip2regionUtils.getIp2Region(ip), uri, method, signature, params, resultString, elapsedTime
                // );
                // log.info(
                //         "\n" +
                //                 "================================================================================\n" +
                //                 "请求IP     => {}\n" +
                //                 "IP地理位置  => {}\n" +
                //                 "请求地址    => {}\n" +
                //                 "请求方式    => {}\n" +
                //                 "请求类方法  => {}\n" +
                //                 "请求参数    => {}\n" +
                //                 "处理耗时    => {}ms\n" +
                //                 "返回结果    => {}\n" +
                //                 "================================================================================",
                //         ip,
                //         Ip2regionUtils.getIp2Region(ip),
                //         uri,
                //         method,
                //         signature,
                //         params,
                //         elapsedTime,
                //         resultString
                // );

                log.info(
                        "\n" +
                                "================================================================================\n" +
                                "请求IP     => {}\n" +
                                "请求地址    => {}\n" +
                                "请求方式    => {}\n" +
                                "请求类方法  => {}\n" +
                                "请求参数    => {}\n" +
                                "处理耗时    => {}ms\n" +
                                "返回结果    => {}\n" +
                                "================================================================================",
                        ip,
                        uri,
                        method,
                        signature,
                        params,
                        elapsedTime,
                        resultString
                );
            } else {
                // log.error(
                //         "\n" +
                //                 "================================================================================\n" +
                //                 "         ❌ API 请求失败 \n" +
                //                 "--------------------------------------------------------------------------------\n" +
                //                 "请求IP        => {}\n" +
                //                 "IP地理位置    => {}\n" +
                //                 "请求地址      => {}\n" +
                //                 "请求方式      => {}\n" +
                //                 "请求类方法    => {}\n" +
                //                 "请求参数      => {}\n" +
                //                 "处理耗时      => {}ms\n" +
                //                 "--------------------------------------------------------------------------------\n" +
                //                 "异常信息      => \n" +
                //                 "================================================================================",
                //         ip,
                //         Ip2regionUtils.getIp2Region(ip),
                //         uri,
                //         method,
                //         signature,
                //         params,
                //         elapsedTime,
                //         exception
                // );
                log.error(
                        "\n" +
                                "================================================================================\n" +
                                "         ❌ API 请求失败 \n" +
                                "--------------------------------------------------------------------------------\n" +
                                "请求IP        => {}\n" +
                                "请求地址      => {}\n" +
                                "请求方式      => {}\n" +
                                "请求类方法    => {}\n" +
                                "请求参数      => {}\n" +
                                "处理耗时      => {}ms\n" +
                                "--------------------------------------------------------------------------------\n" +
                                "异常信息      => \n" +
                                "================================================================================",
                        ip,
                        uri,
                        method,
                        signature,
                        params,
                        elapsedTime,
                        exception
                );
            }

            if (ObjUtil.isNotNull(exception)) {
                throw exception;
            }
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
