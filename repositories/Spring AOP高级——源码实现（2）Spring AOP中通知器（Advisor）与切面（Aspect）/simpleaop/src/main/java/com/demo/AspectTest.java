package com.demo;

import org.springframework.stereotype.Component;

/**
 * Created by Kevin on 2017/11/15.
 */
@Component("aspectTest")
public class AspectTest {

    /**
     * 前置通知
     */
    public void doBefore() {
        System.out.println("前置通知");
    }

    /**
     * 后置通知
     */
    public void doAfter() {
        System.out.println("后置通知");
    }

}
