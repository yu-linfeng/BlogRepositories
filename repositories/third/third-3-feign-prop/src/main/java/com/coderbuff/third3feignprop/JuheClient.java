package com.coderbuff.third3feignprop;

import com.coderbuff.third3feignprop.entity.JuheStockResponse;
import feign.Param;
import feign.RequestLine;

/**
 * @author yulinfeng
 * @date 2019/12/26
 */
public interface JuheClient {

    /**
     * 根据股票代码查询股票信息
     * @param code 股票代码
     * @return 接口返回
     */
    @RequestLine("GET /finance/stock/hs?gid={gid}&key={key}")
    JuheStockResponse queryStock(@Param("gid") String code, @Param("key") String appKey);
}
