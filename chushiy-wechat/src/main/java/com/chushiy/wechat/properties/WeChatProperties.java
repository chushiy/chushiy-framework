package com.chushiy.wechat.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/8/23 19:24
 * @Description 微信配置文件类
 * @ProjectName chushiy-wechat
 * @PackageName com.chushiy.wechat.properties
 * @ClassName WeChatProperties.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "chushiy.wechat")
public class WeChatProperties {

    @NestedConfigurationProperty
    private Applet applet;

    /**
     * 小程序
     */
    @Data
    public static class Applet {
        /**
         * AppID(小程序ID)
         */
        private String appId;

        /**
         * AppSecret(小程序密钥)
         */
        private String secret;
    }

}
