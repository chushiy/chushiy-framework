package com.chushiy.spring.boot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 18:20
 * @Description Application
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.test
 * @ClassName Application.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@SpringBootApplication
@ComponentScan("com.chushiy.**")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
