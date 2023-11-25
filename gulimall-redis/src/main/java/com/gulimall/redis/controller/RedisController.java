package com.gulimall.redis.controller;


import com.gulimall.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/test")
    public void save(){
        redisUtil.set("name","lisi");
    }

    @RequestMapping("/get")
    public String get(){
        return redisUtil.get("name").toString();
    }

}
