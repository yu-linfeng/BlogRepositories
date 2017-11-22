package com.demo.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * 监听Spring Boot刚开始启动的时候
 * Created by Kevin on 2017/11/22.
 */
public class MyApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        SpringApplication app = event.getSpringApplication();
        System.out.println("=====MyApplicationStartedEventListener=====");
    }
}
