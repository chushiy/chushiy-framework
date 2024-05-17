package com.chushiy.standard.pojo.page;

import com.chushiy.standard.pojo.VO;

import java.util.List;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/12 下午 10:34
 * @Description 分页接口
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard.pojo
 * @ClassName IPage.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface IPage<T> extends VO {

    /**
     * 获取分页总页数
     */
    default long getPages() {
        if (this.getSize() != 0L) {
            return (this.getTotal() + this.getSize() - 1) / this.getSize();
        }
        return 0L;
    }

    /**
     * 获取分页记录
     */
    List<T> getRecords();

    /**
     * 获取分页记录
     */
    IPage<T> setRecords(List<T> records);

    /**
     * 获取记录总行数
     */
    long getTotal();

    /**
     * 设置记录总行数
     *
     * @param size
     */
    IPage<T> setTotal(long total);

    /**
     * 获取每页显示条数
     */
    long getSize();

    /**
     * 设置每页显示条数
     */
    IPage<T> setSize(long size);

    /**
     * 获取当前页
     */
    long getCurrent();

    /**
     * 设置当前页
     */
    IPage<T> setCurrent(long current);
}
