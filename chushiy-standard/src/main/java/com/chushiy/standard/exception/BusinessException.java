package com.chushiy.standard.exception;

import cn.hutool.core.util.StrUtil;
import com.chushiy.standard.constant.ResponseConstant;
import com.chushiy.standard.exception.support.ErrorSupport;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/6 下午 10:37
 * @Description 业务异常
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.exception
 * @ClassName BusinessException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@ToString
@Getter
public class BusinessException extends RuntimeException implements Serializable {

    private String code;

    private String message;

    private BusinessException() {
    }

    /**
     * @param message
     * @deprecated 可以自己传入code或者message不推荐 <br>
     * 推荐使用{@link #BusinessException(ErrorSupport errorSupport)} <br>
     * 或者{@link #BusinessException(ErrorSupport errorSupport, Throwable cause, Object... args)}
     */
    @Deprecated
    public BusinessException(String message) {
        this(ResponseConstant.FAIL_CODE, message, new BusinessException());
    }

    @Deprecated
    public BusinessException(String message, Throwable cause, Object... args) {
        this(ResponseConstant.FAIL_CODE, StrUtil.format(message, args), cause);
    }

    @Deprecated
    public BusinessException(String code, String message) {
        this(code, message, new BusinessException());
    }

    @Deprecated
    public BusinessException(String code, String message, Throwable cause, Object... args) {
        super(message, cause);
        this.code = code;
        this.message = StrUtil.format(message, args);
    }

    public BusinessException(ErrorSupport errorSupport) {
        super(errorSupport.getMessage());
        this.code = errorSupport.getCode();
        this.message = errorSupport.getMessage();
    }

    public BusinessException(ErrorSupport errorSupport, Throwable cause, Object... args) {
        super(StrUtil.format(errorSupport.getMessage(), args), cause);
        this.code = errorSupport.getCode();
        this.message = StrUtil.format(errorSupport.getMessage(), args);
    }
}
