package com.demo.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * Spring Boot初始化完成
 * Created by Kevin on 2017/11/22.
 */
public class MyApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("=====MyApplicationReadyEventListener=====");
    }
}
