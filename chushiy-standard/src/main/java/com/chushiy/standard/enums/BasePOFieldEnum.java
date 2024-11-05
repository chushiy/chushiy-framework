package com.chushiy.standard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/10/28 12:57
 * @Description po基类字段
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.enums
 * @ClassName BasePOFieldEnum.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@RequiredArgsConstructor
@Getter
public enum BasePOFieldEnum {

    /**
     * 删除标志
     */
    DELETE_FLAG("deleteFlag", "删除标志（0代表未删除，1代表已删除）"),
    /**
     * 创建人
     */
    CREATE_BY("createBy", "创建人"),
    /**
     * 创建时间
     */
    CREATE_TIME("createTime", "创建时间"),
    /**
     * 更新人
     */
    UPDATE_BY("updateBy", "更新人"),
    /**
     * 更新时间
     */
    UPDATE_TIME("updateTime", "更新时间"),
    /**
     * 备注
     */
    REMARK("remark", "备注");

    private final String field;
    private final String desc;
}
