package com.coderbuff.third2resttemplateprop;

import com.alibaba.fastjson.JSONObject;
import com.coderbuff.third2resttemplateprop.entity.JuheStockResponse;
import com.coderbuff.third2resttemplateprop.entity.JuheStockResultDapanData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author yulinfeng
 * @date 2019/12/26
 */
@Service
public class StockServiceImpl {

    /**
     * 配置类
     */
    @Autowired
    private JuheConfig juheConfig;

    /**
     * API URL
     */
    private static final String URL = "http://web.juhe.cn:8080/finance/stock/hs?gid=%s&key=%s";

    /**
     * 根据股票代码获取股票
     *
     * @param code 股票代码
     * @return 股票信息
     */
    public StockDTO getStockByCode(String code) {
        String url = String.format(URL, code, juheConfig.getAppKey());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(parseContentType());
        JuheStockResponse response = restTemplate.getForObject(url, JuheStockResponse.class);
        JuheStockResultDapanData juheStockResultDapanData = response.getResult().get(0).getDapandata();
        StockDTO stockDTO = new StockDTO();
        stockDTO.setName(juheStockResultDapanData.getName());
        return stockDTO;
    }

    /**
     * 支持所有的contentType类型
     * @return 类型转换
     */
    private List<HttpMessageConverter<?>> parseContentType() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        return messageConverters;
    }
}
