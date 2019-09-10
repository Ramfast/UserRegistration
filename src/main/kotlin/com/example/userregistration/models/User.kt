package com.example.userregistration.models

import org.springframework.lang.Nullable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id : Long,
        var firstName : String,
        var lastName : String,
        var userNamme : String,
        var address : String,
        var zip : String,
        @Nullable
        var city : String
)