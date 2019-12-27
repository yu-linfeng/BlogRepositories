package com.coderbuff.third3feignprop;

import com.coderbuff.third3feignprop.entity.JuheStockResponse;
import com.coderbuff.third3feignprop.entity.JuheStockResultDapanData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yulinfeng
 * @date 2019/12/26
 */
@Service
public class StockServiceImpl {

    @Autowired
    private JuheClientFactory juheClientFactory;

    @Autowired
    private JuheConfig juheConfig;

    /**
     * 根据股票代码获取股票
     *
     * @param code 股票代码
     * @return 股票信息
     */
    public StockDTO getStockByCode(String code) {
        JuheClient client = juheClientFactory.createClient(juheConfig.getUrl());
        JuheStockResponse response = client.queryStock(code, juheConfig.getAppKey());
        JuheStockResultDapanData juheStockResultDapanData = response.getResult().get(0).getDapandata();
        StockDTO stockDTO = new StockDTO();
        stockDTO.setName(juheStockResultDapanData.getName());
        return stockDTO;
    }
}
