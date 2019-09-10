package com.example.userregistration.services

import com.example.userregistration.models.User
import com.example.userregistration.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsersService {

    @Autowired
    lateinit var usersRepository: UsersRepository

    fun getAllUsers(): Iterable<User> {
        return usersRepository.findAll()
    }

    fun getUserById(userId: Long): Optional<User> {
        return usersRepository.findById(userId)
    }

}