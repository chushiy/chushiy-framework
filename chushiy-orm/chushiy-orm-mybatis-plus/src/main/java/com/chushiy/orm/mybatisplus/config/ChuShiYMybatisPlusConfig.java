package com.chushiy.orm.mybatisplus.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.chushiy.orm.mybatisplus.ChuShiYMybatisPlusMetaObjectHandler;
import com.chushiy.standard.enums.DeleteFlagEnum;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/13 下午 5:25
 * @Description mybatisPlus配置
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.orm.mybatisplus.config
 * @ClassName MybatisPlusConfig.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@MapperScan(basePackages = {"com.example.project.mapper"})
@Configuration
public abstract class ChuShiYMybatisPlusConfig {

    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig config = new GlobalConfig();
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setIdType(IdType.AUTO);
        // 开启驼峰命名映射
        // dbConfig.setMapUnderscoreToCamelCase(true);
        // 逻辑已删除值
        dbConfig.setLogicDeleteValue(DeleteFlagEnum.DELETE.getCode().toString());
        // 逻辑未删除值
        dbConfig.setLogicNotDeleteValue(DeleteFlagEnum.NORMAL.getCode().toString());
        config.setDbConfig(dbConfig);
        return config;
    }

    @Bean
    @Primary
    public DataSource primaryDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("...");
        dataSource.setUsername("...");
        dataSource.setPassword("...");
        return dataSource;
    }

    @Bean
    public DataSource secondaryDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("...");
        dataSource.setUsername("...");
        dataSource.setPassword("...");
        return dataSource;
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new ChuShiYMybatisPlusMetaObjectHandler() {
        };
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 如果配置多个插件,切记分页最后添加
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //如果有多数据源可以不配具体类型 否则都建议配上具体的DbType
        // interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
