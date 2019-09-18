package com.example.userregistration.repositories.cache

import com.example.userregistration.models.fragments.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AddressRedisRepository: CacheRepository<Address> {
    @Autowired
    private lateinit var redisRepository: RedisRepository
    private val storeKey = "ADDRESS"

    override fun save(uuid: UUID, obj: Address) {
        redisRepository.operations.put(storeKey, uuid.toString(), obj)
    }

    override fun findAll(): List<*> {
        return redisRepository.operations.values(storeKey)
    }

    override fun findByUuid(uuid: UUID): Address {
        return redisRepository.operations.get(storeKey, uuid.toString()) as Address
    }

    override fun update(uuid: UUID, obj: Address) {
        save(uuid, obj)
    }

    override fun delete(uuid: UUID) {
        redisRepository.operations.delete(storeKey, uuid.toString())
    }
}