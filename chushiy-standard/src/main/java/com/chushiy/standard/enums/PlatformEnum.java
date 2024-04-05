package com.chushiy.standard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 5:35
 * @Description 客户端类型
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.enums
 * @ClassName PlatformEnum.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum PlatformEnum {

    Unkonwn(-1, "Unkonwn"),
    IOS(1, "IOS"),
    Android(2, "Android"),
    PC(0, "PC"),
    WECHAT(3, "WECHAT"),
    ;

    private int platform;

    private String desc;

    public static PlatformEnum getByPlatform(int platform) {
        if (platform == IOS.platform) {
            return IOS;
        }

        if (platform == Android.platform) {
            return Android;
        }

        if (platform == PC.platform) {
            return PC;
        }

        if (platform == WECHAT.platform) {
            return WECHAT;
        }

        return Unkonwn;
    }
}
