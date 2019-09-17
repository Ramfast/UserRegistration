package com.example.userregistration.models.hibernate

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
        var ssn: String,
        var firstName : String,
        var lastName : String,
        var email : String,
        var street : String,
        var zip : String,
        var city : String
)