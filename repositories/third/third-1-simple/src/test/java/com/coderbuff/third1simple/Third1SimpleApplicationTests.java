package com.coderbuff.third1simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Third1SimpleApplication.class)
public class Third1SimpleApplicationTests {

    @Autowired
    private StockServiceImpl stockService;

    @Test
    public void test() {
        StockDTO stockDTO = stockService.getStockByCode("sh600519");
        System.out.println(stockDTO);
    }

}
