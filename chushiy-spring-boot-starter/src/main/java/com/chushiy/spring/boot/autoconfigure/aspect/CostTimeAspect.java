package com.chushiy.spring.boot.autoconfigure.aspect;

import com.chushiy.spring.boot.autoconfigure.enums.InterfaceTimeLevelEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author 初时y
 * @DateTime 2023/11/27 下午 8:07
 * @Description 实现代码耗时注解切面实现
 * @ProjectName gulimall
 * @PackageName com.chushiy.spring.boot.autoconfigure.aspect
 * @ClassName CostTimeAspect.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
@Component
@Aspect
public class CostTimeAspect {

    @Pointcut(value = "@annotation(com.chushiy.spring.boot.autoconfigure.annotation.CostTime)")
    public void costTime() {
    }

    @Around("costTime()")
    public Object costTimeAround(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        try {
            long beginTime = System.currentTimeMillis();
            obj = joinPoint.proceed();
            // 获取方法名称
            String method = joinPoint.getSignature().getName();
            // 获取类名称
            String className = joinPoint.getSignature().getDeclaringTypeName();
            // 计算耗时
            long cost = System.currentTimeMillis() - beginTime;
            InterfaceTimeLevelEnum interfaceTimeLevel = InterfaceTimeLevelEnum.getInterfaceTimeLevel(cost);
            if (log.isDebugEnabled()) {
                // 慢接口
                if (interfaceTimeLevel.getLevel() > InterfaceTimeLevelEnum.ite3.getLevel()) {
                    log.warn("类:[{}]，方法:[{}]，接口耗时:[{}]毫秒！接口耗时等级:{}", className, method, cost, interfaceTimeLevel);
                } else {
                    log.info("类:[{}]，方法:[{}] 接口耗时:[{}] 毫秒", className, method, cost);
                }
            } else {
                log.info("类:[{}]，方法:[{}] 接口耗时:[{}] 毫秒", className, method, cost);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
}
