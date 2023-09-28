package com.gulimall.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GulimallCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCommonApplication.class, args);
    }

}
