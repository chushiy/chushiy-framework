package com.chushiy.orm.mybatisplusjoin;

import com.github.yulichang.base.MPJBaseServiceImpl;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/4/6 上午 7:34
 * @Description mybatisPlus ServiceImpl层基类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.orm.mybatisplus
 * @ClassName ChuShiYMybatisPlusSuperServiceImpl.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class ChuShiYMybatisPlusJoinSuperServiceImpl<M extends ChuShiYMybatisPlusJoinSuperMapper<T>, T> extends MPJBaseServiceImpl<ChuShiYMybatisPlusJoinSuperMapper<T>, T> implements ChuShiYMybatisPlusJoinSuperService<T> {
}
