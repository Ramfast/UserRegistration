package com.example.userregistration.resources

import com.example.userregistration.models.fragments.UserSsn
import com.example.userregistration.models.hibernate.User
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
    fun initialize(@Valid ssn: UserSsn): String {
        return registrationService.createRegistration(ssn)
    }
}