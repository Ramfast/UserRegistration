package com.example.userregistration.repositories.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository {
    public HashOperations operations;
    private RedisTemplate redisTemplate;

    @Autowired
    public RedisRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.operations = this.redisTemplate.opsForHash();
    }
}