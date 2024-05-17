package com.chushiy.standard.dao;

import com.chushiy.standard.condition.Condition;
import com.chushiy.standard.pojo.PO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/17 上午 11:20
 * @Description dao基类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.dao
 * @ClassName BaseDao.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface BaseDao<T extends PO> {

    /**
     * 插入
     *
     * @param po 持久层对象
     * @return 受影响行数
     */
    int insert(T po);

    /**
     * 根据主键id删除
     *
     * @param id 主键id
     * @return 受影响行数
     */
    int deleteById(Serializable id);

    /**
     * 根据主键id集合删除
     *
     * @param ids 主键集合
     * @return 受影响行数
     */
    int deleteByIds(Collection<? extends Serializable> ids);

    /**
     * 根据条件删除
     *
     * @param condition 条件
     * @return 受影响行数
     */
    int delete(Condition<T> condition);

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
        return this.selectCount(condition) > 0;
    }

    /**
     * 查询行数
     *
     * @param condition 条件
     * @return 符合条件的记录的行数
     */
    long selectCount(Condition<T> condition);

    /**
     * 根据主键id查询
     *
     * @param id 主键
     * @return 符合条件的记录
     */
    T selectById(Serializable id);

    /**
     * 查询一条 多条会报错
     *
     * @param condition 条件
     * @return 符合条件的记录
     */
    T selectOne(Condition<T> condition);

    /**
     * 查询全部
     *
     * @return 符合条件的记录
     */
    List<T> selectList();

    /**
     * 根据条件查询
     *
     * @param condition 条件
     * @return 符合条件的记录
     */
    List<T> selectList(Condition<T> condition);
}
