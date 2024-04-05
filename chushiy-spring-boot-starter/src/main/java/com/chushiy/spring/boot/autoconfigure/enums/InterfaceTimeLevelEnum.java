package com.chushiy.spring.boot.autoconfigure.enums;

import java.util.concurrent.TimeUnit;

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
public enum InterfaceTimeLevelEnum {
    ite1(1, "秒级", "0-1秒"),
    ite2(2, "慢接口", "1-5秒"),
    ite3(3, "慢接口", "5-10秒"),
    ite4(4, "慢接口", "10-30秒"),
    ite5(5, "慢接口", ">30秒");


    /**
     * 等级
     */
    private int level;

    /**
     * 描述
     */
    private String desc;

    /**
     * 区间
     */
    private String section;

    InterfaceTimeLevelEnum(int level, String desc, String section) {
        this.level = level;
        this.desc = desc;
        this.section = section;
    }

    /**
     * 传入一个接口耗时毫秒返回一个接口耗时等级
     *
     * @param ite
     * @return
     */
    public static InterfaceTimeLevelEnum getInterfaceTimeLevel(long interfaceTime) {
        long newInterfaceTime = TimeUnit.MILLISECONDS.toSeconds(interfaceTime);
        if (newInterfaceTime <= 1) {
            return InterfaceTimeLevelEnum.ite1;
        } else if (newInterfaceTime <= 5) {
            return InterfaceTimeLevelEnum.ite2;
        } else if (newInterfaceTime <= 10) {
            return InterfaceTimeLevelEnum.ite3;
        } else if (newInterfaceTime <= 30) {
            return InterfaceTimeLevelEnum.ite4;
        } else {
            return InterfaceTimeLevelEnum.ite5;
        }
    }

    public int getLevel() {
        return level;
    }

    public String getDesc() {
        return desc;
    }

    public String getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "接口耗时{" +
                "等级:" + level +
                ", 描述:'" + desc + '\'' +
                ", 耗时区间:'" + section + '\'' +
                '}';
    }
}
