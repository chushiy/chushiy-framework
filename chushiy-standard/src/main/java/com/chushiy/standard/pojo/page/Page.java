package com.chushiy.standard.pojo.page;

import com.chushiy.standard.constant.PageConstant;
import com.chushiy.standard.util.Assert;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/12 下午 11:02
 * @Description 默认分页实现
 * @ProjectName chushiy-framework
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
        if (ObjectUtils.isEmpty(this.size)) {
            return PageConstant.DEFAULT_CURRENT;
        }
        return this.size;
    }

    @Override
    public IPage<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    @Override
    public long getCurrent() {
        if (ObjectUtils.isEmpty(this.current)) {
            return PageConstant.DEFAULT_CURRENT;
        }
        return this.current;
    }

    public Page() {
    }

    public Page(List<T> records, long total, long size, long current) {
        Assert.isNotEmpty(records);
        this.setRecords(records);
        Assert.isNotEmpty(total);
        this.setTotal(total);
        Assert.isNotEmpty(size);
        this.setSize(size);
        Assert.isNotEmpty(current);
        this.setCurrent(current);
    }
}
