package com.gulimall.redis.service;

import org.springframework.data.redis.core.RedisTemplate;

public interface RedisService {

    RedisTemplate getRedisTemplate();
}
