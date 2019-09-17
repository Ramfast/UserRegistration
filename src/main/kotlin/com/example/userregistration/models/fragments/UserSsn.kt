package com.example.userregistration.models.fragments

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotNull

data class UserSsn(
        @NotNull
        @Length(min = 11, max = 11)
        val ssn: String
)