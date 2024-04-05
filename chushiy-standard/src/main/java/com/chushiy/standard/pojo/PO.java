package com.chushiy.standard.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Author 初时y
 * @DateTime 2023/11/28 下午 11:21
 * @Description PO基类
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.pojo
 * @ClassName PO.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Getter
@Setter
public class PO implements POJO {

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
