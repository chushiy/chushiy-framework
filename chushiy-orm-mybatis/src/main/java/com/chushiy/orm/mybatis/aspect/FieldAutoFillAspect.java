package com.chushiy.orm.mybatis.aspect;

import com.chushiy.orm.mybatis.annotation.FieldAutoFill;
import com.chushiy.orm.mybatis.constant.FieldAutoFillConstant;
import com.chushiy.orm.mybatis.enums.FieldFillType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/13 下午 6:18
 * @Description 字段自动填充切面
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.orm.mybatis.aspect
 * @ClassName FieldAutoFillAspect.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class FieldAutoFillAspect {

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.chushiy.orm.mybatis.annotation.FieldAutoFill)")
    public void fieldAutoFillPointCut() {
    }

    /**
     * 前置通知，在通知中进行公共字段的自动填充
     */
    @Before("fieldAutoFillPointCut()")
    public void fieldAutoFill(JoinPoint joinPoint) {
        log.info("开始进行公共字段的填充...");

        // 获取到当前被拦截的方法上的数据库操作类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        FieldAutoFill autoFill = signature.getMethod().getAnnotation(FieldAutoFill.class);
        FieldFillType operationType = autoFill.value();
        // 获取到当前被拦截方法的参数--实体对象
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];
        // 准备赋值数据
        LocalDateTime now = LocalDateTime.now();
        // 根据数据库操作类型进行赋值
        if (operationType == FieldFillType.INSERT) {
            try {
                // TODO 公共字段可配置
                Method setCreateTime = entity.getClass().getDeclaredMethod(FieldAutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(FieldAutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                setCreateTime.invoke(entity, now);
                setUpdateTime.invoke(entity, now);
            } catch (Exception ignored) {
            }
        } else if (operationType == FieldFillType.UPDATE) {
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod(FieldAutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                setUpdateTime.invoke(entity, now);
            } catch (Exception ignored) {
            }
        }
    }

}
