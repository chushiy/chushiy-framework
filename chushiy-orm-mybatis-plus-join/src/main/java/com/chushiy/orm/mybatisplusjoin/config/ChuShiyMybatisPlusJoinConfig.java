package com.chushiy.orm.mybatisplusjoin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.chushiy.orm.mybatisplusjoin.ChuShiyMybatisPlusJoinMetaObjectHandler;
import com.chushiy.standard.enums.DeleteFlagEnum;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
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
public class ChuShiyMybatisPlusJoinConfig {

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

    // @Bean
    // @Primary
    // public DataSource primaryDataSource() {
    //     DruidDataSource dataSource = new DruidDataSource();
    //     dataSource.setUrl("...");
    //     dataSource.setUsername("...");
    //     dataSource.setPassword("...");
    //     return dataSource;
    // }
    //
    // @Bean
    // public DataSource secondaryDataSource() {
    //     DruidDataSource dataSource = new DruidDataSource();
    //     dataSource.setUrl("...");
    //     dataSource.setUsername("...");
    //     dataSource.setPassword("...");
    //     return dataSource;
    // }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new ChuShiyMybatisPlusJoinMetaObjectHandler() {
        };
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));// 如果配置多个插件,切记分页最后添加
        // interceptor.addInnerInterceptor(new PaginationInnerInterceptor()); 如果有多数据源可以不配具体类型 否则都建议配上具体的DbType
        return interceptor;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);

        // 注册动态返回值插件
        // sqlSessionFactory.setPlugins(new DynamicResultInterceptor());

        // 注册扩展sql注入器
        MybatisConfiguration configuration = new MybatisConfiguration();
        GlobalConfig globalConfig = GlobalConfigUtils.getGlobalConfig(configuration);
        // globalConfig.setSqlInjector(new JoinMethodInjector());
        sqlSessionFactory.setConfiguration(configuration);

        return sqlSessionFactory.getObject();
    }
}
