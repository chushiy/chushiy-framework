package com.chushiy.spring.boot.autoconfigure.properties;

import com.chushiy.spring.boot.autoconfigure.enums.JSONTypeEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 2:51
 * @Description 系统配置文件
 * @ProjectName chushiy
 * @PackageName com.chushiy.spring.boot.autoconfigure.properties
 * @ClassName ChuShiYProperties.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "chushiy")
@Data
public class ChuShiYProperties {

    /**
     * json类型
     */
    private JSONTypeEnum jsonType;
}
