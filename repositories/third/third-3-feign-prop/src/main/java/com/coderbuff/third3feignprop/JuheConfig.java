package com.coderbuff.third3feignprop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yulinfeng
 * @date 2019/12/26
 */
@Data
@Component
@ConfigurationProperties("juhe-stock")
public class JuheConfig {

    private String url;
    private String appKey;
}
