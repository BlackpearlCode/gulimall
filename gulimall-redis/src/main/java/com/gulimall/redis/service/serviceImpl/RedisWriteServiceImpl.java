package com.gulimall.redis.service.serviceImpl;


import com.gulimall.redis.config.RedisConfig;
import com.gulimall.redis.service.RedisService;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redis主节点
 */
@Service
public class RedisWriteServiceImpl implements RedisService {



    private RedisConfig redisConfig;

    public void setRedisConfig(RedisConfig redisConfig) {
        this.redisConfig = redisConfig;
    }


    @Override
    public RedisTemplate getRedisTemplate() {
        LettuceConnectionFactory lettuceConnectionFactory = redisConfig.redisConnectionFactory();
        return redisConfig.redisTemplate(lettuceConnectionFactory);
    }
}