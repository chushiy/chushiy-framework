package com.chushiy.standard.validation.group;

import java.io.Serializable;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/19 下午 5:20
 * @Description 分组校验接口基类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.validation.group
 * @ClassName BaseGroup.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class BaseGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新增
     */
    public interface Add {
    }

    /**
     * 删除
     */
    public interface Delete {
    }

    /**
     * 更新
     */
    public interface Update {
    }
}
