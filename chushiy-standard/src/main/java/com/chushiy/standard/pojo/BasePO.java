package com.chushiy.standard.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/8 下午 11:07
 * @Description PO基类 同PO的区别是多了表基础字段
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.pojo
 * @ClassName BasePO.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Getter
@Setter
public class BasePO {

    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    private Integer deleteFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;
}
