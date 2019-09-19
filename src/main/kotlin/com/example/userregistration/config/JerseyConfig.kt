package com.example.userregistration.config

import com.example.userregistration.resources.PingResource
import com.example.userregistration.resources.RegistrationResource
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

@Component
class JerseyConfig() : ResourceConfig() {
    init {
        registerEndpoints()
    }

    private fun registerEndpoints() {
        register(PingResource())
        register(RegistrationResource())
    }
}