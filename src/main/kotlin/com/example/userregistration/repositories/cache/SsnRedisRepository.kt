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
        redisRepository.operation().put(storeKey, uuid.toString(), obj.ssn)
    }

    fun findAll(): List<*> {
        return redisRepository.operation().values(storeKey)
    }

    override fun findByUuid(uuid: UUID): Ssn {
        return redisRepository.operation().get(storeKey, uuid.toString()) as Ssn
    }

    fun update(uuid: UUID, obj: Ssn) {
        save(uuid, obj)
    }

    override fun delete(uuid: UUID) {
        redisRepository.operation().delete(storeKey, uuid.toString())
    }
}