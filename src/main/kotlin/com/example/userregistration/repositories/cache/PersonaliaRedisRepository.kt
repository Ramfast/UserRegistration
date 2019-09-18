package com.example.userregistration.repositories.cache

import com.example.userregistration.models.fragments.Personalia
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PersonaliaRedisRepository: CacheRepository<Personalia> {
    @Autowired
    private lateinit var redisRepository: RedisRepository
    private val storeKey = "PERSONALIA"

    override fun save(uuid: UUID, obj: Personalia) {
        redisRepository.operations.put(storeKey, uuid.toString(), obj)
    }

    override fun findAll(): List<*> {
        return redisRepository.operations.values(storeKey)
    }

    override fun findByUuid(uuid: UUID): Personalia {
        return redisRepository.operations.get(storeKey, uuid.toString()) as Personalia
    }

    override fun update(uuid: UUID, obj: Personalia) {
        save(uuid, obj)
    }

    override fun delete(uuid: UUID) {
        redisRepository.operations.delete(storeKey, uuid.toString())
    }
}