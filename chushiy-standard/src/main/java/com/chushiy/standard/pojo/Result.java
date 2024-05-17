package com.chushiy.standard.pojo;

import com.chushiy.standard.constant.ResponseConstant;
import com.chushiy.standard.exception.BusinessException;
import com.chushiy.standard.exception.support.ErrorSupport;
import com.chushiy.standard.i18n.I18nConfig;
import com.chushiy.standard.spi.ResultI18nMessageAssemblerProvider;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/8 下午 5:09
 * @Description 统一返回结果 支持国际化使用JAVA SPI机制 提供扩展性
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.pojo
 * @ClassName Result.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@ToString
@Setter
@Getter
public class Result<T> implements VO {

    /**
     * 空数据
     */
    private static final Void EMPTY_DATA = null;
    /**
     * 默认成功
     * 使用单例模式
     */
    private static Result<Void> success = new Result<>();
    /**
     * 代码 使用字符串类型
     * 使用int类型有弊端 0001
     */
    private final String code;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    private Result() {
        this.code = ResponseConstant.SUCCESS_CODE;
        this.message = ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, ResponseConstant.SUCCESS_MESSAGE);
    }

    private Result(String message) {
        this.code = ResponseConstant.SUCCESS_CODE;
        this.message = message;
    }

    private Result(T data) {
        if (data instanceof ErrorSupport) {
            ErrorSupport errorSupport = (ErrorSupport) data;
            this.code = ResponseConstant.SUCCESS_CODE;
            this.data = data;
            this.message = ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, errorSupport.getMessage());
        } else {
            this.code = ResponseConstant.SUCCESS_CODE;
            this.data = data;
            this.message = ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, ResponseConstant.SUCCESS_MESSAGE);
        }
    }


    private Result(String message, T data) {
        this.code = ResponseConstant.SUCCESS_CODE;
        this.message = message;
        this.data = data;
    }

    private Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result<Void> success() {
        if (success != null) {
            return success;
        }
        synchronized (Result.class) {
            if (success != null) {
                return success;
            }
            success = new Result<>(ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, ResponseConstant.SUCCESS_MESSAGE));
            return success;
        }
    }

    public static Result<Void> success(String message) {
        return new Result<>(ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, message), Result.EMPTY_DATA);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, ResponseConstant.SUCCESS_MESSAGE), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, message), data);
    }

    public static Result<Void> fail() {
        return new Result<>(ResponseConstant.FAIL_CODE, ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, ResponseConstant.SUCCESS_MESSAGE));
    }

    public static Result<Void> fail(ErrorSupport errorSupport) {
        return new Result<>(errorSupport.getCode(), ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, errorSupport.getMessage()));
    }

    public static Result<Void> fail(BusinessException businessException) {
        return new Result<>(businessException.getCode(), ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, businessException));
    }

    public boolean isSuccess() {
        return ResponseConstant.SUCCESS_CODE.equals(this.code);
    }
}
