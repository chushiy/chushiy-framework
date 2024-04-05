package com.chushiy.standard.pojo.page;

import java.util.List;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/8 下午 5:09
 * @Description 分页统一返回结果
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.pojo.page
 * @ClassName PageResult.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class PageResult<T> implements IPage<T> {

    private IPage<T> page;

    private PageResult() {
    }

    public PageResult(IPage<T> page) {
        this.page = page;
    }

    @Override
    public List<T> getRecords() {
        return this.page.getRecords();
    }

    @Override
    public IPage<T> setRecords(List<T> records) {
        return this.page.setRecords(records);
    }

    @Override
    public IPage<T> setTotal(long total) {
        return this.page.setTotal(total);
    }

    @Override
    public long getTotal() {
        return this.page.getTotal();
    }

    @Override
    public IPage<T> setSize(long size) {
        return this.page.setSize(size);
    }

    @Override
    public long getSize() {
        return this.page.getSize();
    }

    @Override
    public IPage<T> setCurrent(long current) {
        return this.page.setCurrent(current);
    }

    @Override
    public long getCurrent() {
        return this.page.getCurrent();
    }


}
