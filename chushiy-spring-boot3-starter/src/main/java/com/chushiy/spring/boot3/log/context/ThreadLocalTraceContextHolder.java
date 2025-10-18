package com.chushiy.spring.boot3.log.context;

import com.chushiy.spring.boot3.log.util.RequestIdGenerator;
import com.chushiy.spring.boot3.log.util.TraceIdGenerator;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/9/6 18:09
 * @Description 链接追踪上下文
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.log.context
 * @ClassName ThreadLocalTraceContextHolder.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class ThreadLocalTraceContextHolder {

    private static final ThreadLocal<TraceContext> traceContextThreadLocal = new ThreadLocal<>();

    /**
     * 初始化trace
     *
     * @return TraceContext
     */
    public synchronized static void initTrace() {
        // 初始化TraceContext
        traceContextThreadLocal.set(
                new TraceContext(
                        RequestIdGenerator.generate(), TraceIdGenerator.generate()
                )
        );
    }

    /**
     * 获取当前请求id
     *
     * @return requestId
     */
    public static String getCurrentRequestId() {
        return traceContextThreadLocal.get().getRequestId();
    }

    /**
     * 获取traceId
     *
     * @return traceId
     */
    public static String getCurrentTraceId() {
        return traceContextThreadLocal.get().getTraceId();
    }

    /**
     * 设置trace上下文
     *
     * @param traceContext trace上下文
     */
    public synchronized static void setTraceContext(TraceContext traceContext) {
        traceContextThreadLocal.set(traceContext);
    }

    /**
     * 设置trace上下文
     *
     * @return traceContext trace上下文
     */
    public synchronized static TraceContext getTraceContext() {
        return traceContextThreadLocal.get();
    }

    /**
     * 清空trace上下文
     */
    public synchronized static void clear() {
        traceContextThreadLocal.remove();
    }
}
