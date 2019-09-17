package com.example.userregistration.resources

import org.springframework.stereotype.Component
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType

@Component
@Path("ping")
class PingResource {
    @GET
    @Path("/")
    fun ping(): String {
        return "pong"
    }
}