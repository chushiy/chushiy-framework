package com.chushiy.standard.service;

import com.chushiy.standard.condition.Condition;
import com.chushiy.standard.pojo.PO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/17 上午 11:19
 * @Description service基类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.service
 * @ClassName BaseService.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface BaseService<T extends PO> {

    /**
     * 保存
     *
     * @param po 持久层对象
     * @return 受影响行数
     */
    int save(T po);

    /**
     * 根据主键id删除
     *
     * @param id 主键id
     * @return 受影响行数
     */
    int removeById(Serializable id);

    /**
     * 根据主键id集合删除
     *
     * @param ids 主键集合
     * @return 受影响行数
     */
    int removeByIds(Collection<? extends Serializable> ids);

    /**
     * 根据条件删除
     *
     * @param condition 条件
     * @return 受影响行数
     */
    int remove(Condition<T> condition);

    /**
     * 根据主键id更新
     *
     * @param id 主键id
     * @return 受影响行数
     */
    int updateById(Serializable id);

    /**
     * 更新
     *
     * @param condition 条件
     * @return 受影响行数
     */
    int update(Condition<T> condition);

    /**
     * 是否存在
     *
     * @param condition 条件
     * @return 是否存在符合条件的记录
     */
    default boolean exists(Condition<T> condition) {
        return this.count(condition) > 0;
    }

    /**
     * 查询行数
     *
     * @param condition 条件
     * @return 符合条件的记录的行数
     */
    long count(Condition<T> condition);

    /**
     * 根据主键id查询
     *
     * @param id 主键
     * @return 符合条件的记录
     */
    T getById(Serializable id);

    /**
     * 查询一条 多条会报错
     *
     * @param condition 条件
     * @return 符合条件的记录
     */
    T getOne(Condition<T> condition);

    /**
     * 查询全部
     *
     * @return 符合条件的记录
     */
    List<T> list();

    /**
     * 根据条件查询
     *
     * @param condition 条件
     * @return 符合条件的记录
     */
    List<T> list(Condition<T> condition);
}
