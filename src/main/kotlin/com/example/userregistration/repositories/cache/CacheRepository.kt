package com.example.userregistration.repositories.cache

import java.util.*

interface CacheRepository<T> {
    fun save(uuid: UUID, obj: T)

    fun findAll(): List<*>

    fun findByUuid(uuid: UUID): T

    fun update(uuid: UUID, obj: T)

    fun delete(uuid: UUID)
}