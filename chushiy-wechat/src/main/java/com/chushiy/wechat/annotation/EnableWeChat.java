package com.chushiy.wechat.annotation;

import com.chushiy.wechat.properties.WeChatProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/8/23 19:38
 * @Description 是否开启微信相关功能
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.wechat.annotation
 * @ClassName EnableWeChat.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@EnableConfigurationProperties(WeChatProperties.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableWeChat {

    boolean value() default true;
}
