package com.example.userregistration.repositories

import com.example.userregistration.models.Personalia
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PersonaliaRedisRepository : CacheRepository<Personalia> {
    @Autowired
    private lateinit var redisRepository: RedisRepository
    private val storeKey = "PERSONALIA"

    override fun save(uuid: UUID, obj: Personalia) {
        redisRepository.operation().put(storeKey + "_EMAIL", uuid.toString(), obj.email)
        redisRepository.operation().put(storeKey + "_FIRSTNAME", uuid.toString(), obj.firstName)
        redisRepository.operation().put(storeKey + "_LASTNAME", uuid.toString(), obj.lastName)
    }

    override fun findByUuid(uuid: UUID): Personalia {
        val email = redisRepository.operation().get(storeKey + "_EMAIL", uuid.toString()) as String
        val firstName = redisRepository.operation().get(storeKey + "_FIRSTNAME", uuid.toString()) as String
        val lastName = redisRepository.operation().get(storeKey + "_LASTNAME", uuid.toString()) as String

        return Personalia(email, firstName, lastName)
    }

    override fun delete(uuid: UUID) {
        redisRepository.operation().delete(storeKey + "_EMAIL", uuid.toString())
        redisRepository.operation().delete(storeKey + "_FIRSTNAME", uuid.toString())
        redisRepository.operation().delete(storeKey + "_LASTNAME", uuid.toString())
    }
}