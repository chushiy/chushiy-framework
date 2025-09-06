package com.chushiy.spring.boot.log.context;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/9/6 18:13
 * @Description 链路追踪上下文
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.log.context
 * @ClassName TraceContext.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Getter
public class TraceContext {

    /**
     * 请求ID
     */
    private String requestId;

    /**
     * 链路追踪ID
     */
    private String traceId;

    /**
     * 额外信息
     */
    private Map<String, Object> extra;

    public TraceContext(String requestId, String traceId) {
        this.requestId = requestId;
        this.traceId = traceId;
        this.extra = new HashMap<>();
    }

    public void addExtra(String key, Object value){
        this.extra.put(key, value);
    }
}
