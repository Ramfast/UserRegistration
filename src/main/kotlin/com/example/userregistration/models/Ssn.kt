package com.example.userregistration.models

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotNull

data class Ssn(
        @NotNull
        @Length(min = 11, max = 11)
        val ssn: String
)