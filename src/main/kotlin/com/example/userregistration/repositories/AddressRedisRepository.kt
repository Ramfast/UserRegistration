package com.example.userregistration.repositories

import com.example.userregistration.models.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AddressRedisRepository: RedisRepository, CacheRepository<Address> {
    private val keyStreet = "ADDRESS_STREET"
    private val keyZip = "ADDRESS_ZIP"
    private val keyCity = "ADDRESS_CITY"

    @Autowired
    constructor(redisTemplate: RedisTemplate<Any, Any>) : super(redisTemplate)

    override fun save(uuid: UUID, obj: Address) {
        super.operation().put(keyStreet, uuid.toString(), obj.street)
        super.operation().put(keyZip, uuid.toString(), obj.zip)
        super.operation().put(keyCity, uuid.toString(), obj.city)
    }

    override fun findByUuid(uuid: UUID): Address {
        val street = super.operation().get(keyStreet, uuid.toString()) as String
        val zip = super.operation().get(keyZip, uuid.toString()) as String
        val city = super.operation().get(keyCity, uuid.toString()) as String

        return Address(street, zip, city)
    }

    override fun delete(uuid: UUID) {
        super.operation().delete(keyStreet, uuid.toString())
        super.operation().delete(keyZip, uuid.toString())
        super.operation().delete(keyCity, uuid.toString())
    }
}