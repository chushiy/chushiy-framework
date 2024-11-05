package com.chushiy.standard.pojo.page;

import com.chushiy.standard.constant.PageConstant;
import com.chushiy.standard.pojo.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/10/25 11:56
 * @Description 分页请求参数基类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.pojo.page
 * @ClassName PageRequest.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest implements Request {

    /**
     * 页码
     */
    private Long current;

    /**
     * 条数
     */
    private Long size;

    public Long getCurrent() {
        if (ObjectUtils.isEmpty(this.current)) {
            return PageConstant.DEFAULT_CURRENT;
        }
        // 非法页码
        if (this.current < 0) {
            return PageConstant.DEFAULT_CURRENT;
        }
        return current;
    }

    public Long getSize() {
        if (ObjectUtils.isEmpty(this.current)) {
            return PageConstant.DEFAULT_SIZE;
        }
        return size;
    }
}
