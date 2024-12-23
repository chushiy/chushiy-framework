package com.chushiy.spring.boot.enums;

import lombok.RequiredArgsConstructor;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 3:10
 * @Description json类型
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.enums
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

    /**
     * json类型
     */
    private final String name;

    /**
     * 描述
     */
    private final String desc;
}
