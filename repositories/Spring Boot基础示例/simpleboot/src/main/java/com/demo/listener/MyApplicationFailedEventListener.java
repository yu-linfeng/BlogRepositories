package com.demo.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Spring Boot启动异常时执行的事件
 * Created by Kevin on 2017/11/22.
 */
public class MyApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent>{

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        Throwable throwable = event.getException();
        handleThrow(throwable);
    }

    private void handleThrow(Throwable throwable) {

    }
}
