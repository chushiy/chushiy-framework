package com.chushiy.oss.spring.boot.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/29 下午 8:42
 * @Description OSS配置属性
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.oss.spring.boot.autoconfigure.properties
 * @ClassName OSSProperties.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "chushiy.oss")
@Data
public class OSSProperties {

    /**
     * 对象存储服务的URL
     */
    private String endpoint;

    /**
     * 区域
     */
    private String region;

    /**
     * true path-style nginx 反向代理和S3默认支持 pathStyle模式 {http://endpoint/bucketname}
     * false supports virtual-hosted-style 阿里云等需要配置为 virtual-hosted-style 模式{http://bucketname.endpoint}
     * 只是url的显示不一样
     */
    private Boolean pathStyleAccess = true;

    /**
     * Access key
     */
    private String accessKey;

    /**
     * Secret key
     */
    private String secretKey;

    /**
     * 最大线程数，默认： 100
     */
    private Integer maxConnections = 100;
}
