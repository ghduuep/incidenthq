package com.ghduep.incidenthq.domain.repository

import com.ghduep.incidenthq.domain.Component
import kotlin.uuid.Uuid

interface ComponentRepository {
    suspend fun findAll(): List<Component>
    suspend fun findAllById(ids: List<Uuid>): List<Component>?
    suspend fun save(component: Component): Component
    suspend fun saveAll(components: List<Component>): List<Component>
    suspend fun delete(id: Uuid)
}