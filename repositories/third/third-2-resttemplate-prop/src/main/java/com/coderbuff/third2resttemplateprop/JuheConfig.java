package com.coderbuff.third2resttemplateprop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置
 * @author yulinfeng
 * @date 2019/12/26
 */
@Data
@Component
@ConfigurationProperties("juhe-stock")
public class JuheConfig {

    /**
     * appkey
     */
    private String appKey;
}
