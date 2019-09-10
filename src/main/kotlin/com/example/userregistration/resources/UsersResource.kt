package com.example.userregistration.resources

import com.example.userregistration.models.User
import com.example.userregistration.services.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Component
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
class UsersResource {

    @Autowired
    lateinit var usersService : UsersService

    @GET
    @Path("/")
    fun usersIndex(): Iterable<User> {
        return usersService.getAllUsers()
    }

    @GET
    @Path("/{id}")
    fun userById(@PathParam("id") id: Long): Optional<User> {
        return usersService.getUserById(id)
    }
}