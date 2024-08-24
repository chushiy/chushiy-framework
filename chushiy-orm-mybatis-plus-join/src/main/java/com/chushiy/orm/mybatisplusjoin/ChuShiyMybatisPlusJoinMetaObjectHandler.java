package com.chushiy.orm.mybatisplusjoin;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.chushiy.standard.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/13 下午 5:48
 * @Description mp字段填充器
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.orm.mybatisplus
 * @ClassName ChuShiyMybatisPlusMetaObjectHandler.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
public abstract class ChuShiyMybatisPlusJoinMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        this.strictInsertFill(metaObject, "createBy", SecurityUtils::getUserName, String.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
        this.strictUpdateFill(metaObject, "updateBy", SecurityUtils::getUserName, String.class);
    }
}
