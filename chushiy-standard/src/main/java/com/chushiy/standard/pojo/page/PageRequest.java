package com.chushiy.standard.pojo.page;

import com.chushiy.standard.pojo.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Builder
public class PageRequest implements Request {

    /**
     * 页码
     */
    private Long current;

    /**
     * 条数
     */
    private Long size;
}
