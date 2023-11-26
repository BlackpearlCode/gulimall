package com.gulimall.redis.controller;


import com.gulimall.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    @RequestMapping("/getMap")
    public<T> Map<String,T> hmget(@RequestParam("key") String key){
        return redisUtil.hmget(key);
    }

    //设置redis分布式锁
    @RequestMapping("/redisLock")
    public<T> Boolean redisLock(@RequestParam("key") String key,@RequestParam("value") T value, @RequestParam("timeout")long timeout,@RequestParam("timeUnit") TimeUnit timeUnit){
        return redisUtil.redisLock( key,  value, timeout,timeUnit);
    }


    //普通缓存获取
    @RequestMapping("/get")
    public Object getValue(@RequestParam("key") String key){
        return redisUtil.get(key);
    }

    @RequestMapping("/deleteRedisLock")
    public<T> T deleteRedisLock(@RequestParam("script")String script,@RequestParam("keys") List<String> keys,@RequestParam("value") String value){
        return redisUtil.deleteRedisLock(script,keys,value);
    }


}
