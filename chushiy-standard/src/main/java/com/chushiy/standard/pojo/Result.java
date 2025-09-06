package com.chushiy.standard.pojo;

import com.chushiy.standard.constant.ResponseConstant;
import com.chushiy.standard.exception.BusinessException;
import com.chushiy.standard.exception.support.ErrorSupport;
import com.chushiy.standard.i18n.I18nConfig;
import com.chushiy.standard.spi.ResultI18nMessageAssemblerProvider;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/8 下午 5:09
 * @Description 统一返回结果 支持国际化使用JAVA SPI机制 提供扩展性
 * @ProjectName chushiy-framework
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
     * 编码 使用字符串类型
     * 使用int类型有弊端 0001
     */
    private String code;
    /**
     * 消息
     */
    private String message;
    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * 扩展参数
     * 例如 version等等
     */
    private Map<String, Object> extra;
    /**
     * 数据
     */
    private T data;
    /**
     * 链路追踪ID
     */
    private String traceId;

    protected Result() {
        this.code = ResponseConstant.SUCCESS_CODE;
        this.timestamp = System.currentTimeMillis();
        this.message = ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, ResponseConstant.SUCCESS_MESSAGE);
    }

    private Result(String message) {
        this.code = ResponseConstant.SUCCESS_CODE;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
    }

    private Result(T data) {
        if (data instanceof ErrorSupport) {
            ErrorSupport errorSupport = (ErrorSupport) data;
            this.code = ResponseConstant.SUCCESS_CODE;
            this.timestamp = System.currentTimeMillis();
            this.data = data;
            this.message = ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, errorSupport.getMessage());
        } else {
            this.code = ResponseConstant.SUCCESS_CODE;
            this.timestamp = System.currentTimeMillis();
            this.data = data;
            this.message = ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, ResponseConstant.SUCCESS_MESSAGE);
        }
    }

    private Result(String message, T data) {
        this.code = ResponseConstant.SUCCESS_CODE;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
        this.data = data;
    }

    private Result(String code, String message) {
        this.code = code;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
    }

    private Result(String code, String message, Map<String, Object> extra) {
        this.code = code;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
        this.extra = extra;
    }

    private Result(String code, String message, Map<String, Object> extra, T data) {
        this.code = code;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
        this.extra = extra;
        this.data = data;
    }

    private Result(String code, String message, T data, String traceId, Map<String, Object> extra) {
        this.code = code;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
        this.data = data;
        this.traceId = traceId;
        this.extra = extra;
    }

    public static Result<Void> success() {
        return ok();
    }

    public static Result<Void> success(String message) {
        return ok(message);
    }

    public static <T> Result<T> success(T data) {
        return ok(data);
    }

    public static <T> Result<T> success(Map<String, Object> extra) {
        return ok(extra);
    }

    public static <T> Result<T> success(String message, T data) {
        return ok(message, data);
    }

    public static <T> Result<T> success(String code, String message, T data, String traceId) {
        return ok(code, message, data, traceId);
    }

    public static <T> Result<T> success(String code, String message, T data, String traceId, Map<String, Object> extra) {
        return ok(code, message, data, traceId, extra);
    }

    public static Result<Void> ok() {
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

    public static Result<Void> ok(String message) {
        return new Result<>(ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, message), Result.EMPTY_DATA);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, ResponseConstant.SUCCESS_MESSAGE), data);
    }

    public static <T> Result<T> ok(Map<String, Object> extra) {
        return new Result<>(ResponseConstant.SUCCESS_CODE, ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, ResponseConstant.SUCCESS_MESSAGE), extra);
    }

    public static <T> Result<T> ok(String message, T data) {
        return new Result<>(ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, message), data);
    }

    public static <T> Result<T> ok(String code, String message, T data, String traceId) {
        return new Result<>(ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, message), data);
    }

    public static <T> Result<T> ok(String code, String message, T data, String traceId, Map<String, Object> extra) {
        return new Result<>(code, ResultI18nMessageAssemblerProvider.getProvider().assembler(I18nConfig.language, message), data, traceId, extra);
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
