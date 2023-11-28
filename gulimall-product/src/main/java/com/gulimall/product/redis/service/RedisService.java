package com.gulimall.product.redis.service;

import org.springframework.data.redis.core.RedisTemplate;

public interface RedisService {

    RedisTemplate getRedisTemplate();
}
