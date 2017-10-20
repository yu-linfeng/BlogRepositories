package com.springdemo.aop;

import com.springdemo.aop.security.CheckUserHolder;
import com.springdemo.aop.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class AopTest {

    @Autowired
    private ProductService productService;

    /**
     * 匿名权限访问校验
     */
    @Test(expected = Exception.class)
    public void annoDeleteTest() {
        CheckUserHolder.set("kevin");
        productService.delete(1L);
    }

    /**
     * 管理员权限校验
     */
    @Test
    public void adminDelete() {
        CheckUserHolder.set("admin");
        productService.delete(1L);
    }
}
