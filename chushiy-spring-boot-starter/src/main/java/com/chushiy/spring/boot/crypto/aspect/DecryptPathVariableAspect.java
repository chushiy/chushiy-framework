package com.chushiy.spring.boot.crypto.aspect;

import com.chushiy.crypto.util.CryptoUtils;
import com.chushiy.spring.boot.crypto.annotation.DecryptPathVariable;
import com.chushiy.spring.boot.crypto.annotation.DecryptRequestParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 12:26
 * @Description 解密路径参数 切面
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.crypto.aspect
 * @ClassName DecryptPathVariableAspect.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class DecryptPathVariableAspect {

    private final CryptoUtils cryptoUtils;

    @Around("@annotation(com.chushiy.spring.boot.crypto.annotation.DecryptPathVariable)")
    public Object decrypt(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();
        Parameter[] parameters = method.getParameters();

        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            if (parameter.isAnnotationPresent(DecryptPathVariable.class)) {
                String encryptedValue = (String) args[i];
                if (encryptedValue != null) {
                    DecryptPathVariable decryptPathVariable = parameter.getAnnotation(DecryptPathVariable.class);
                    try {
                        // 根据指定的类型解密
                        args[i] = cryptoUtils.getCrypto(decryptPathVariable.type()).decrypt(encryptedValue);
                        log.info("PathVariable解密.参数:{},密文:{},明文:{}", parameter.getName(), encryptedValue, args[i]);
                    } catch (Exception e) {
                        log.error("参数解密失败，参数名：" + parameter.getName());
                        args[i] = "";
                    }
                }
            }
        }

        return joinPoint.proceed(args);
    }
}
