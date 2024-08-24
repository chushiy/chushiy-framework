package com.chushiy.standard.controller;

import cn.hutool.core.util.StrUtil;
import com.chushiy.standard.convert.Convert;
import com.chushiy.standard.pojo.PO;
import com.chushiy.standard.service.BaseService;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/1/23 下午 7:21
 * @Description controller基类
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.controller
 * @ClassName BaseController.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public abstract class BaseController<T extends PO> extends AbstractBaseController<T> {

    protected BaseController(Convert<T> convert, BaseService<T> service) {
        super(convert, service);
    }

    /**
     * 重定向到指定的url
     *
     * @param url url
     * @return 重定向的url
     */
    public String redirect(String url) {
        return StrUtil.format("redirect:{}", url);
    }
}
