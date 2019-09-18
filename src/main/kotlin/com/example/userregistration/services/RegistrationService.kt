package com.example.userregistration.services

import com.example.userregistration.models.fragments.Address
import com.example.userregistration.models.fragments.Personalia
import com.example.userregistration.models.fragments.Ssn
import com.example.userregistration.repositories.cache.AddressRedisRepository
import com.example.userregistration.repositories.cache.PersonaliaRedisRepository
import com.example.userregistration.repositories.cache.SsnRedisRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegistrationService {
    @Autowired
    private lateinit var ssnRepo: SsnRedisRepository

    fun createRegistration(ssn: Ssn): UUID {
        val uuid = UUID.randomUUID()
        ssnRepo.save(uuid, ssn)

        return uuid
    }

    fun registerPersonalia(uuid: UUID, personalia: Personalia) {
        //personliaRepo.save(uuid, personalia)
    }

    fun registerAddress(uuid: UUID, address: Address) {
        //addressRepo.save(uuid, address)
    }

    fun finalizeRegistration(uuid: UUID) {

    }
}