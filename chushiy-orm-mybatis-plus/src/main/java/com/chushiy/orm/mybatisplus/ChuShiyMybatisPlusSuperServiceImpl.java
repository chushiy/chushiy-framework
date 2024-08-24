package com.chushiy.orm.mybatisplus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/4/6 上午 7:34
 * @Description mybatisPlus ServiceImpl层基类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.orm.mybatisplus
 * @ClassName ChuShiyMybatisPlusSuperServiceImpl.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class ChuShiyMybatisPlusSuperServiceImpl<M extends ChuShiyMybatisPlusSuperMapper<T>, T> extends ServiceImpl<ChuShiyMybatisPlusSuperMapper<T>, T> implements ChuShiyMybatisPlusSuperService<T> {
}
