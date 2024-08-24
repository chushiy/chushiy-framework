package com.chushiy.spring.boot.autoconfigure;

import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/30 下午 12:58
 * @Description 应用运行完成执行
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.autoconfigure
 * @ClassName ApplicationRunner.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@RequiredArgsConstructor
@Slf4j
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

    private final Environment env;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String applicationName = env.getProperty("spring.application.name");
        String contextPath = env.getProperty("server.servlet.context-path");
        String path = StrUtil.isNotBlank(contextPath) ? contextPath : "";
        log.info("\n----------------------------------------------------------\n\t" +
                "Application " + applicationName + " is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/login\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/login\n\t" +
                "Api Doc: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "\n----------------------------------------------------------");
    }
}
