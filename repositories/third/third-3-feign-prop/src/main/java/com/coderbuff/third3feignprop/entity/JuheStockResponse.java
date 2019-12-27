package com.coderbuff.third3feignprop.entity;

import lombok.Data;

import java.util.List;

/**
 * @author yulinfeng
 * @date 2019/12/26
 */
@Data
public class JuheStockResponse {

    /**
     * 响应码
     */
    private String resultcode;

    /**
     * 错误信息
     */
    private String reason;

    /**
     * 错误码
     */
    private String error_code;

    /**
     * 数据
     */
    private List<JuheStockResult> result;
}
