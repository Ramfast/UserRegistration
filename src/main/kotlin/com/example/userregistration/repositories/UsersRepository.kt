package com.example.userregistration.repositories

import com.example.userregistration.models.hibernate.User
import org.springframework.data.repository.CrudRepository

interface UsersRepository : CrudRepository<User, Long>