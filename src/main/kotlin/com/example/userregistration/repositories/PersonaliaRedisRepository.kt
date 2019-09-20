package com.example.userregistration.repositories

import com.example.userregistration.models.Personalia
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PersonaliaRedisRepository : RedisRepository, CacheRepository<Personalia> {
    private val keyEmail = "PERSONALIA_EMAIL"
    private val keyFirstName = "PERSONALIA_FIRSTNAME"
    private val keyLastName = "PERSONALIA_LASTNAME"

    @Autowired
    constructor(redisTemplate: RedisTemplate<Any, Any>) : super(redisTemplate)

    override fun save(uuid: UUID, obj: Personalia) {
        super.operation().put(keyEmail, uuid.toString(), obj.email)
        super.operation().put(keyFirstName, uuid.toString(), obj.firstName)
        super.operation().put(keyLastName, uuid.toString(), obj.lastName)
    }

    override fun findByUuid(uuid: UUID): Personalia {
        val email = super.operation().get(keyEmail, uuid.toString()) as String
        val firstName = super.operation().get(keyFirstName, uuid.toString()) as String
        val lastName = super.operation().get(keyLastName, uuid.toString()) as String

        return Personalia(email, firstName, lastName)
    }

    override fun delete(uuid: UUID) {
        super.operation().delete(keyEmail, uuid.toString())
        super.operation().delete(keyFirstName, uuid.toString())
        super.operation().delete(keyLastName, uuid.toString())
    }
}