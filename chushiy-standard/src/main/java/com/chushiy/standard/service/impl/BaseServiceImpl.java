package com.chushiy.standard.service.impl;

import com.chushiy.standard.condition.Condition;
import com.chushiy.standard.dao.BaseDao;
import com.chushiy.standard.pojo.PO;
import com.chushiy.standard.service.BaseService;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/17 上午 11:21
 * @Description service impl基类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.service.impl
 * @ClassName BaseServiceImpl.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@RequiredArgsConstructor
public class BaseServiceImpl<D extends BaseDao<T>, T extends PO> implements BaseService<T> {

    private final D dao;

    @Override
    public int save(T po) {
        return this.dao.insert(po);
    }

    @Override
    public int removeById(Serializable id) {
        return this.dao.deleteById(id);
    }

    @Override
    public int removeByIds(Collection<? extends Serializable> ids) {
        return this.dao.deleteByIds(ids);
    }

    @Override
    public int remove(Condition<T> condition) {
        return this.dao.delete(condition);
    }

    @Override
    public int updateById(Serializable id) {
        return this.dao.updateById(id);
    }

    @Override
    public int update(Condition<T> condition) {
        return this.dao.update(condition);
    }

    @Override
    public boolean exists(Condition<T> condition) {
        return BaseService.super.exists(condition);
    }

    @Override
    public long count(Condition<T> condition) {
        return this.dao.selectCount(condition);
    }

    @Override
    public T getById(Serializable id) {
        return this.dao.selectById(id);
    }

    @Override
    public T getOne(Condition<T> condition) {
        return this.dao.selectOne(condition);
    }

    @Override
    public List<T> list() {
        return this.dao.selectList();
    }

    @Override
    public List<T> list(Condition<T> condition) {
        return this.dao.selectList(condition);
    }
}
