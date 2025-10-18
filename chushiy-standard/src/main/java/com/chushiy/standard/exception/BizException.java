package com.chushiy.standard.exception;

import cn.hutool.core.util.StrUtil;
import com.chushiy.standard.constant.ResponseConstant;
import com.chushiy.standard.exception.support.ErrorSupport;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.lang.Throwable;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/6 下午 10:37
 * @Description 业务异常
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.exception
 * @ClassName BizException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class BizException extends BusinessException {

    public BizException(ErrorSupport errorSupport) {
        super(errorSupport);
    }
}
