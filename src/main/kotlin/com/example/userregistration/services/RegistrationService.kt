package com.example.userregistration.services

import com.example.userregistration.models.Address
import com.example.userregistration.models.Personalia
import com.example.userregistration.models.Ssn
import com.example.userregistration.models.User
import com.example.userregistration.repositories.AddressRedisRepository
import com.example.userregistration.repositories.PersonaliaRedisRepository
import com.example.userregistration.repositories.SsnRedisRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegistrationService {
    @Autowired
    private lateinit var ssnRepo: SsnRedisRepository
    @Autowired
    private lateinit var personaliaRepo: PersonaliaRedisRepository
    @Autowired
    private lateinit var addressRepo: AddressRedisRepository

    fun createRegistration(ssn: Ssn): UUID {
        val uuid = UUID.randomUUID()
        ssnRepo.save(uuid, ssn)

        return uuid
    }

    fun registerPersonalia(uuid: UUID, personalia: Personalia): Personalia {
        personaliaRepo.save(uuid, personalia)
        return personaliaRepo.findByUuid(uuid) // This redis read is not really necessary, but for now its a kind of validation that it actually persists.
    }

    fun registerAddress(uuid: UUID, address: Address): User {
        addressRepo.save(uuid, address)
        return finalizeRegistration(uuid)
    }

    fun finalizeRegistration(uuid: UUID): User {
        // Fetch everything from Redis
        val ssn = ssnRepo.findByUuid(uuid)
        val personalia = personaliaRepo.findByUuid(uuid)
        val address = addressRepo.findByUuid(uuid)

        // Purge redis of data
        ssnRepo.delete(uuid)
        personaliaRepo.delete(uuid)
        addressRepo.delete(uuid)

        return User(
                ssn.ssn,
                personalia.firstName,
                personalia.lastName,
                personalia.email,
                address.street,
                address.zip,
                address.city
        )
    }
}