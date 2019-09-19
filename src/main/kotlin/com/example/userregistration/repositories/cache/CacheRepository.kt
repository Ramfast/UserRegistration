package com.example.userregistration.repositories.cache

import java.util.*

interface CacheRepository<T> {
    fun save(uuid: UUID, obj: T)

    fun findByUuid(uuid: UUID): T

    fun delete(uuid: UUID)
}