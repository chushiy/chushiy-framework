package com.chushiy.spring.boot.autoconfigure;

import com.chushiy.spring.boot.autoconfigure.properties.ChuShiYProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 上午 11:10
 * @Description 自动配置类
 * @ProjectName chushiy
 * @PackageName com.chushiy.spring.boot.autoconfigure
 * @ClassName ChuShiYAutoConfigure.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@EnableConfigurationProperties(ChuShiYProperties.class)
@Configuration
public class ChuShiYAutoConfigure {
}
