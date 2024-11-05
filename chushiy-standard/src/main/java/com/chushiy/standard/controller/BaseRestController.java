package com.chushiy.standard.controller;

import com.chushiy.standard.convert.Convert;
import com.chushiy.standard.exception.BusinessException;
import com.chushiy.standard.exception.support.ErrorSupport;
import com.chushiy.standard.pojo.PO;
import com.chushiy.standard.pojo.Result;
import com.chushiy.standard.service.BaseService;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/1/23 下午 7:22
 * @Description restful controller基类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.controller
 * @ClassName BaseRestController.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public abstract class BaseRestController<T extends PO> extends AbstractBaseController<T> {

    protected BaseRestController(Convert<T> convert, BaseService<T> service) {
        super(convert, service);
    }

    public Result<Void> success(String message) {
        return Result.success(message);
    }

    public <T> Result<T> success(T data) {
        return Result.success(data);
    }

    public <T> Result<T> success(String message, T data) {
        return Result.success(data);
    }

    public Result<Void> fail() {
        return Result.fail();
    }

    public Result<Void> fail(ErrorSupport errorSupport) {
        return Result.fail(errorSupport);
    }

    public Result<Void> fail(BusinessException businessException) {
        return Result.fail(businessException);
    }
}
