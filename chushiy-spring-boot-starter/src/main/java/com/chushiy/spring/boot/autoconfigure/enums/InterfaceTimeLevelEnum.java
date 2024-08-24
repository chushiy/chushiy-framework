package com.chushiy.spring.boot.autoconfigure.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @Author 初时y
 * @DateTime 2023/11/27 下午 8:28
 * @Description 接口耗时等级枚举
 * @ProjectName chushiy
 * @PackageName com.chushiy.spring.boot.autoconfigure.enums
 * @ClassName InterfaceTimeLevelConstant.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@ToString
@Getter
@RequiredArgsConstructor
public enum InterfaceTimeLevelEnum {
    /**
     * 极快响应
     */
    ite1(1, "极快响应", "0ms - 100ms", 0, 100),
    /**
     * 较快响应
     */
    ite2(2, "较快响应", "101ms - 500ms", 101, 500),
    /**
     * 一般响应
     */
    ite3(3, "一般响应", "501ms - 1000ms", 501, 1000),
    /**
     * 较慢响应
     */
    ite4(4, "较慢响应", "1001ms - 3000ms", 1001, 3000),
    /**
     * 极慢响应
     */
    ite5(5, "极慢响应", "3001ms 以上", 3001, Integer.MAX_VALUE);


    /**
     * 等级
     */
    private final int level;

    /**
     * 描述
     */
    private final String desc;

    /**
     * 区间
     */
    private final String section;

    /**
     * 最小时间 毫秒
     */
    private final int minTime;

    /**
     * 最大时间 毫秒
     */
    private final int maxTime;

    /**
     * 传入一个接口耗时毫秒返回一个接口耗时等级
     *
     * @param interfaceTime 接口耗时毫秒
     * @return InterfaceTimeLevelEnum
     */
    public static InterfaceTimeLevelEnum getInterfaceTimeLevel(long interfaceTime) {
        for (InterfaceTimeLevelEnum level : InterfaceTimeLevelEnum.values()) {
            if (interfaceTime <= level.getMaxTime()) {
                return level;
            }
        }
        return InterfaceTimeLevelEnum.ite5;
    }
}
