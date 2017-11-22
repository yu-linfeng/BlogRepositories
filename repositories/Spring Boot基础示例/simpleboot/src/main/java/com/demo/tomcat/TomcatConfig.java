package com.demo.tomcat;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

/**
 * 复杂的Tomcat自定义配置，定义默认编码
 * Created by Kevin on 2017/11/22.
 */
@Configuration
public class TomcatConfig {

    public EmbeddedServletContainerFactory servletContain() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.setUriEncoding(Charset.forName("UTF-8"));
        return tomcat;
    }
}
