package com.chushiy.spring.boot3.log.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/9/6 18:18
 * @Description traceId生成器
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.log.util
 * @ProductName IntelliJ IDEA
 * @ClassName TraceIdGenerator.java
 * @Version 1.0.0
 */
public class TraceIdGenerator {

    private static final Snowflake SNOWFLAKE = IdUtil.getSnowflake(7, 8);

    /**
     * 生成traceId
     * 雪花算法实现
     *
     * @return traceId
     */
    public synchronized static String generate() {
        return "trace-" + SNOWFLAKE.nextIdStr();
    }
}
