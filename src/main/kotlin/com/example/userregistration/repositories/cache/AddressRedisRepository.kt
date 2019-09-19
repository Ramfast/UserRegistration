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
        redisRepository.operation().put(storeKey + "_STREET", uuid.toString(), obj.street)
        redisRepository.operation().put(storeKey + "_ZIP", uuid.toString(), obj.zip)
        redisRepository.operation().put(storeKey + "_CITY", uuid.toString(), obj.city)
    }

    override fun findByUuid(uuid: UUID): Address {
        val street = redisRepository.operation().get(storeKey + "_STREET", uuid.toString()) as String
        val zip = redisRepository.operation().get(storeKey + "_ZIP", uuid.toString()) as String
        val city = redisRepository.operation().get(storeKey + "_CITY", uuid.toString()) as String

        return Address(street, zip, city)
    }

    override fun delete(uuid: UUID) {
        redisRepository.operation().delete(storeKey + "_STREET", uuid.toString())
        redisRepository.operation().delete(storeKey + "_ZIP", uuid.toString())
        redisRepository.operation().delete(storeKey + "_CITY", uuid.toString())
    }
}