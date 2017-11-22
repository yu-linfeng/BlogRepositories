package com.demo.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

/**
 * 监听Spring Boot的Environment环境已经准备完毕，但此时Context上下文还未创建
 * Created by Kevin on 2017/11/22.
 */
public class MyApplicationEnvironmentPreparedEvent implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment env = event.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();
        if (propertySources != null) {
            Iterator<PropertySource<?>> itor = propertySources.iterator();
            System.out.println("=====MyApplicationEnvironmentPreparedEvent=====");
            while (itor.hasNext()) {
                PropertySource<?> ps = itor.next();
                System.out.println("name: " + ps.getName() + ", source: " + ps.getSource() + "class: " + ps.getClass());
            }
        }
    }
}
