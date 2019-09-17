package com.example.userregistration.config

import com.example.userregistration.resources.PingResource
import com.example.userregistration.resources.RegistrationResource
import com.example.userregistration.resources.UsersResource
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

@Component
class JerseyConfig() : ResourceConfig() {
    init {
        registerEndpoints()
    }

    private fun registerEndpoints() {
        register(PingResource())
        register(UsersResource())
        register(RegistrationResource())
    }
}