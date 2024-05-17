package com.chushiy.oss.spring.boot.autoconfigure;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.chushiy.oss.spring.boot.autoconfigure.core.OSSTemplate;
import com.chushiy.oss.spring.boot.autoconfigure.core.impl.OSSTemplateImpl;
import com.chushiy.oss.spring.boot.autoconfigure.properties.OSSProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/29 下午 8:45
 * @Description 自动配置
 * @ProjectName chushiy
 * @PackageName com.chushiy.oss.spring.boot.autoconfigure
 * @ClassName ChuShiYOSSAutoConfigure.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@EnableConfigurationProperties(OSSProperties.class)
@Configuration
public class ChuShiYOSSAutoConfigure {

    @ConditionalOnMissingBean
    @Bean
    public AmazonS3 ossClient(OSSProperties ossProperties) {
        // 客户端配置，主要是全局的配置信息
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setMaxConnections(ossProperties.getMaxConnections());
        // url以及region配置
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
                ossProperties.getEndpoint(), ossProperties.getRegion());
        // 凭证配置
        AWSCredentials awsCredentials = new BasicAWSCredentials(ossProperties.getAccessKey(),
                ossProperties.getSecretKey());
        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);
        // build amazonS3Client客户端
        return AmazonS3Client.builder().withEndpointConfiguration(endpointConfiguration)
                .withClientConfiguration(clientConfiguration).withCredentials(awsCredentialsProvider)
                .disableChunkedEncoding().withPathStyleAccessEnabled(ossProperties.getPathStyleAccess()).build();
    }

    @ConditionalOnBean(AmazonS3.class)
    @Bean
    public OSSTemplate ossTemplate(AmazonS3 amazonS3) {
        return new OSSTemplateImpl(amazonS3);
    }
}
