package com.demo.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Spring Boot上下文Context加载完成，但Spring的bean还未加载
 * Created by Kevin on 2017/11/22.
 */
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        System.out.println("=====MyApplicationPreparedEventListener=====");
    }
}
