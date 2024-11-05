package com.chushiy.standard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 5:35
 * @Description 客户端类型
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.enums
 * @ClassName PlatformEnum.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Getter
@ToString
@RequiredArgsConstructor
public enum PlatformEnum {

    /**
     * Unkonwn
     */
    UNKONWN("Unkonwn","未知"),
    /**
     * IOS
     */
    IOS( "IOS", "IOS"),
    /**
     * Android
     */
    ANDROID( "Android", "Android"),
    /**
     * PC
     */
    PC("PC", "PC"),
    /**
     * WECHAT
     */
    WECHAT( "WECHAT", "微信"),
    ;

    /**
     * 客户端类型
     */
    private final String platform;

    /**
     * 描述
     */
    private final String desc;

    private static final Map<String, PlatformEnum> PLATFORM_MAP = new HashMap<>();

    static {
        // 将所有的枚举值放入 Map 中进行缓存
        for (PlatformEnum platformEnum : PlatformEnum.values()) {
            PLATFORM_MAP.put(platformEnum.platform, platformEnum);
        }
    }
    
    /**
     *
     * @param platform 客户端类型
     * @return PlatformEnum
     */
    public static PlatformEnum getByPlatform(String platform) {
        return PLATFORM_MAP.getOrDefault(platform, UNKONWN);
    }
}
