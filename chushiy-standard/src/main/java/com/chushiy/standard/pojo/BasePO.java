package com.chushiy.standard.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
public class BasePO implements POJO {

    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    @TableLogic(value = "0", delval = "1")
    private Integer deleteFlag;

    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;
}
