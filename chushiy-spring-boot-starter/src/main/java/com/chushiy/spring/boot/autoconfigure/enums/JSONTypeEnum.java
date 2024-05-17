package com.chushiy.spring.boot.autoconfigure.enums;

import lombok.RequiredArgsConstructor;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 3:10
 * @Description json类型
 * @ProjectName chushiy
 * @PackageName com.chushiy.spring.boot.autoconfigure.enums
 * @ClassName JSONTypeEnum.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@RequiredArgsConstructor
public enum JSONTypeEnum {

    /**
     * fastjson
     */
    FASTJSON("fastjson", "fastjson"),
    /**
     * gson
     */
    GSON("gson", "gson"),
    /**
     * jackson
     */
    JACKSON("jackson", "jackson");

    private final String name;
    private final String desc;
}
