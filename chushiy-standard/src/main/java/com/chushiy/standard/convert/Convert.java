package com.chushiy.standard.convert;

import com.chushiy.standard.pojo.DTO;
import com.chushiy.standard.pojo.PO;
import com.chushiy.standard.pojo.Param;
import com.chushiy.standard.pojo.Query;
import com.chushiy.standard.pojo.Request;
import com.chushiy.standard.pojo.Response;
import com.chushiy.standard.pojo.VO;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/17 下午 1:08
 * @Description POJO相互转换
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.convert
 * @ClassName Convert.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface Convert<T extends PO> {

    /**
     * po转换为DTO
     *
     * @param po po
     * @return DTO
     */
    DTO poToDTO(T po);

    /**
     * po转换为Param
     *
     * @param po po
     * @return Param
     */
    Param poToParam(T po);

    /**
     * po转换为Query
     *
     * @param po po
     * @return Query
     */
    Query poToQuery(T po);

    /**
     * po转换为Request
     *
     * @param po po
     * @return Request
     */
    Request poToRequest(T po);

    /**
     * po转换为Response
     *
     * @param po po
     * @return Response
     */
    Response poToResponse(T po);

    /**
     * po转换为VO
     *
     * @param po po
     * @return VO
     */
    VO poToVO(T po);
}
