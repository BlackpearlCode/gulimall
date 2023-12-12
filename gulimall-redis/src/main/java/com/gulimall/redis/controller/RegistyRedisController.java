package com.gulimall.redis.controller;

import com.gulimall.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/registy/redis")
@RestController
public class RegistyRedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/saveCode")
    public void saveCode(@RequestParam("key") String key,@RequestParam("code")String code,@RequestParam("time") long time){
        redisUtil.set(key,code,time);
    }

    @RequestMapping("/getCode")
    public String getCode(@RequestParam("key") String key){
        return (String)redisUtil.get(key);
    }
}
