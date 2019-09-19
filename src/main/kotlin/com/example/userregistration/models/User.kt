package com.example.userregistration.models

data class User(
        val ssn: String,
        val firstName : String,
        val lastName : String,
        val email : String,
        val street : String,
        val zip : String,
        val city : String
)