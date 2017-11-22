package com.demo;

import com.demo.listener.MyApplicationEnvironmentPreparedEvent;
import com.demo.listener.MyApplicationPreparedEventListener;
import com.demo.listener.MyApplicationReadyEventListener;
import com.demo.listener.MyApplicationStartingEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application {

    public static void main( String[] args ) {
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new MyApplicationStartingEventListener());
        app.addListeners(new MyApplicationEnvironmentPreparedEvent());
        app.addListeners(new MyApplicationPreparedEventListener());
        app.addListeners(new MyApplicationReadyEventListener());
        app.run();
    }
}
