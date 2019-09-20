package com.example.userregistration.models

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

data class Personalia(
        @NotNull
        @Email
        val email: String,
        @NotNull
        val firstName: String,
        @NotNull
        val lastName: String
)