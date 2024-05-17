package com.chushiy.standard.controller;

import com.chushiy.standard.convert.Convert;
import com.chushiy.standard.pojo.LoginUser;
import com.chushiy.standard.pojo.PO;
import com.chushiy.standard.pojo.page.Page;
import com.chushiy.standard.service.BaseService;
import com.chushiy.standard.util.SecurityUtils;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/17 下午 1:33
 * @Description 抽象的控制器基类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.controller
 * @ClassName AbstractBaseController.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@RequiredArgsConstructor
public abstract class AbstractBaseController<T extends PO> {

    private final Convert<T> convert;

    private final BaseService<T> service;

    public LoginUser getLoginUser() {
        return SecurityUtils.getLoginUser();
    }

    public Long getUserId() {
        return this.getLoginUser().getUserId();
    }

    public String getUserName() {
        return this.getLoginUser().getUserName();
    }

    /**
     * 所有记录
     */
    public abstract List<T> list();

    /**
     * 所有记录分页
     */
    public abstract List<T> list(Page<T> page);

    /**
     * 添加
     */
    public abstract Void add();

    /**
     * 编辑
     */
    public abstract Void edit();

    /**
     * 删除
     */
    public abstract Void remove();
}
