package com.gulimall.cart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("gulimall-redis")
public interface RedisFeignService {

    @RequestMapping("/cart/redis/saveHash")
    public boolean saveHash(@RequestParam("key") String key, @RequestParam("item") String item, @RequestParam("value") Object value);
}
