package com.coderbuff.third3feignprop;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.stereotype.Component;

/**
 * "聚合"客户端连接工厂类
 * @author yulinfeng
 * @date 2019/12/26
 */
@Component
public class JuheClientFactory {

    public JuheClient createClient(String url) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(JuheClient.class, url);
    }
}
