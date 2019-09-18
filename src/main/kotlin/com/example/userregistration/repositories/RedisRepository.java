package com.example.userregistration.repositories;

import com.example.userregistration.models.fragments.UserSsn;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository {
    private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    public RedisRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void putSsn(String uuid, UserSsn ssn) {
        hashOperations.put("SSN", uuid, ssn.getSsn());
    }

    public String getUserSsn(String uuid) {
        return (String) hashOperations.get("SSN", uuid);
    }
}