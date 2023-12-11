package com.gulimall.product.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "gulimall.pool")
@Component
@Data
public class ThreadPoolConfigProperties {

    //核心线程数
    private Integer corePoolSize;
    //最大线程数
    private Integer maxPoolSize;
    //线程空闲时间
    private Integer keepAliveTime;

}
