package com.chushiy.standard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/31 下午 10:35
 * @Description 删除标识(逻辑删除)
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.enums
 * @ClassName DeleteFlagEnum.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum DeleteFlagEnum {

    /**
     * 删除
     */
    DELETE(1, "删除"),
    /**
     * 正常
     */
    NORMAL(0, "正常");

    private final Integer code;
    private final String desc;

}
