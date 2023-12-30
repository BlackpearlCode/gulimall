package com.example.order.config;

import com.example.order.interceptor.LoginUserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OrderWebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginUserInterceptor interceptor;

    @Override
    public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
               .addPathPatterns("/**")
               .excludePathPatterns("/toTrade", "/toPay", "/toSubmitOrder", "/toPaySuccess");
    }
}
