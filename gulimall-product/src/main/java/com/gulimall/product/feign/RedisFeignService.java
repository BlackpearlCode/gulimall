package com.gulimall.product.feign;


import com.gulimall.product.vo.Catelog2Vo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "gulimall-redis")
public interface RedisFeignService {

    //将三级目录内容加入缓存
    @RequestMapping("/redis/product/saveCatalogJSON")
    public<T>  Boolean saveCatalogJson(@RequestParam("key") String key, @RequestBody Map<String, T> map);

    //判断key是否存在
    @RequestMapping("/redis/product/isExist")
    public Boolean isExist(@RequestParam("key") String key);

    //获取hashKey对应的所有键值
    @RequestMapping("/redis/product/getValue")
    public<T> Map<String,T> hmget(@RequestParam("key") String key);
}
