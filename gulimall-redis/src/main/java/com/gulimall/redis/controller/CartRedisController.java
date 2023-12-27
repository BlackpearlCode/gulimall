package com.gulimall.redis.controller;

import com.gulimall.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart/redis")
public class CartRedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/saveHash")
    public boolean saveHash(@RequestParam("key") String key, @RequestParam("item") String item, @RequestParam("value") Object value){
        return redisUtil.hset(key,item,value);
    }


    @RequestMapping("/getHash")
    public String getHash(@RequestParam("key") String key, @RequestParam("item") String item){
        boolean bool = redisUtil.hHasKey(key, item);
        if(!bool){
            return null;
        }
        Object object = redisUtil.hget(key, item);
        return object.toString();
    }
}
