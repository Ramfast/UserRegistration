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
        redisRepository.operation().put(storeKey, uuid.toString(), obj)
    }

    override fun findAll(): List<*> {
        return redisRepository.operation().values(storeKey)
    }

    override fun findByUuid(uuid: UUID): Personalia {
        return redisRepository.operation().get(storeKey, uuid.toString()) as Personalia
    }

    override fun update(uuid: UUID, obj: Personalia) {
        save(uuid, obj)
    }

    override fun delete(uuid: UUID) {
        redisRepository.operation().delete(storeKey, uuid.toString())
    }
}