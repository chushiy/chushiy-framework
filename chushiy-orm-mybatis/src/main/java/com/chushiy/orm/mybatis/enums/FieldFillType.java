package com.chushiy.orm.mybatis.enums;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/13 下午 6:14
 * @Description 字段填充类型
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.orm.mybatis.enums
 * @ClassName FieldFillType.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public enum FieldFillType {

    /**
     * 默认不处理
     */
    DEFAULT,
    /**
     * 插入时填充字段
     */
    INSERT,
    /**
     * 更新时填充字段
     */
    UPDATE,
    /**
     * 插入和更新时填充字段
     */
    INSERT_UPDATE
}
