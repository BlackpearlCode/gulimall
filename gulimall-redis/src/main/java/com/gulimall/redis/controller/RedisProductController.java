package com.gulimall.redis.controller;


import com.gulimall.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/redis/product")
public class RedisProductController {

    @Autowired
    private RedisUtil redisUtil;

    //将三级目录保存到redis缓存中
    @RequestMapping("/saveCatalogJSON")
    public <T> Boolean saveCatalogJson(@RequestParam("key") String key,@RequestParam("time") long time, @RequestBody Map<String, T> map){
        return redisUtil.hmset(key,map,time);
    }

    //判断key是否存在
    @RequestMapping("/isExist")
    public Boolean isExist(@RequestParam("key") String key){
        return redisUtil.hasKey(key);
    }

    //获取hashKey对应的所有键值
    @RequestMapping("/getValue")
    public<T> Map<String,T> hmget(@RequestParam("key") String key){
        return redisUtil.hmget(key);
    }


}
