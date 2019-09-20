package com.example.userregistration.repositories

import com.example.userregistration.models.Ssn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class SsnRedisRepository: RedisRepository, CacheRepository<Ssn> {
    private val keySsn = "SSN"

    @Autowired
    constructor(redisTemplate: RedisTemplate<Any, Any>) : super(redisTemplate)

    override fun save(uuid: UUID, obj: Ssn) {
        super.operation().put(keySsn, uuid.toString(), obj.ssn)
    }

    override fun findByUuid(uuid: UUID): Ssn {
        val uuidString = super.operation().get(keySsn, uuid.toString()) as String

        return Ssn(uuidString)
    }

    override fun delete(uuid: UUID) {
        super.operation().delete(keySsn, uuid.toString())
    }
}