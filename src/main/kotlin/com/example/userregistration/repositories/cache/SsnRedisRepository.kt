package com.example.userregistration.repositories.cache

import com.example.userregistration.models.fragments.Ssn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class SsnRedisRepository: CacheRepository<Ssn> {
    @Autowired
    private lateinit var redisRepository: RedisRepository

    private val storeKey = "SSN"

    override fun save(uuid: UUID, obj: Ssn) {
        redisRepository.operations.put(storeKey, uuid.toString(), obj)
    }

    override fun findAll(): List<*> {
        return redisRepository.operations.values(storeKey)
    }

    override fun findByUuid(uuid: UUID): Ssn {
        return redisRepository.operations.get(storeKey, uuid.toString()) as Ssn
    }

    override fun update(uuid: UUID, obj: Ssn) {
        save(uuid, obj)
    }

    override fun delete(uuid: UUID) {
        redisRepository.operations.delete(storeKey, uuid.toString())
    }
}