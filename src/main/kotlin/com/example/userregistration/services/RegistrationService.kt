package com.example.userregistration.services

import com.example.userregistration.models.fragments.UserAddress
import com.example.userregistration.models.fragments.UserPersonalia
import com.example.userregistration.models.fragments.UserSsn
import com.example.userregistration.repositories.RedisRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegistrationService {
    @Autowired
    private lateinit var redisRepository: RedisRepository

    fun createRegistration(userSsn: UserSsn): String {
        val uuid = UUID.randomUUID().toString()
        // We could do some sort of validation of the ssn here to ensure the person actually exists.
        redisRepository.putSsn(uuid, userSsn)

        return uuid
    }

    fun registerUserPersonalia(userPersonalia: UserPersonalia) {
        
    }

    fun registerUserAddress(userAddress: UserAddress) {

    }

    fun finalizeUserRegistration() {

    }
}