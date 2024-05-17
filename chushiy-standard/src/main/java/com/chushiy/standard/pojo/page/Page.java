package com.chushiy.standard.pojo.page;

import java.util.List;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/12 下午 11:02
 * @Description 默认分页实现
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.pojo.page
 * @ClassName Page.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class Page<T> implements IPage<T> {
    private List<T> records;

    private long total;

    private long size;
    private long current;

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public IPage<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    public IPage<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public IPage<T> setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public IPage<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }
}
