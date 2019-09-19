package com.example.userregistration.resources

import com.example.userregistration.models.Address
import com.example.userregistration.models.Personalia
import com.example.userregistration.models.Ssn
import com.example.userregistration.services.RegistrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Component
@Path("registration")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class RegistrationResource {
    @Autowired
    lateinit var registrationService: RegistrationService

    @POST
    @Path("/")
    fun initialize(@Valid ssn: Ssn): UUID {
        return registrationService.createRegistration(ssn)
    }

    @POST
    @Path("/{uuid}/personalia")
    fun personalia(@PathParam("uuid") uuid: UUID, @Valid personalia: Personalia): Personalia {
        return registrationService.registerPersonalia(uuid, personalia)
    }

    @POST
    @Path("/{uuid}/address")
    fun address(@PathParam("uuid") uuid: UUID, @Valid address: Address): Address {
        return registrationService.registerAddress(uuid, address)
    }

}