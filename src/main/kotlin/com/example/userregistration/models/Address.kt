package com.example.userregistration.models

import javax.validation.constraints.NotNull

data class Address(
        @NotNull
        val street: String,
        @NotNull
        val zip: String,
        @NotNull
        val city: String
)