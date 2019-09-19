package com.example.userregistration.controllers

import com.example.userregistration.models.Address
import com.example.userregistration.models.Personalia
import com.example.userregistration.models.Ssn
import com.example.userregistration.models.User
import com.example.userregistration.services.RegistrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/registration")
class RegistrationController {
    @Autowired
    private lateinit var registrationService: RegistrationService

    @PostMapping
    fun initialize(@Valid @RequestBody ssn: Ssn): UUID {
        return registrationService.createRegistration(ssn)
    }

    @PostMapping("/{uuid}/personalia")
    fun personalia(@PathVariable("uuid") uuid: UUID, @Valid @RequestBody personalia: Personalia): Personalia {
        return registrationService.registerPersonalia(uuid, personalia)
    }

    @PostMapping("/{uuid}/address")
    fun address(@PathVariable("uuid") uuid: UUID, @Valid @RequestBody address: Address): User {
        return registrationService.registerAddress(uuid, address)
    }
}