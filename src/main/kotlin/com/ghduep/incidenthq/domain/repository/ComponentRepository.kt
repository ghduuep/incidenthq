package com.ghduep.incidenthq.domain.repository

import com.ghduep.incidenthq.domain.Component
import com.ghduep.incidenthq.domain.Incident
import kotlin.uuid.Uuid

interface ComponentRepository {
    suspend fun findAll(): List<Component>
    suspend fun findAllById(id: Uuid): List<Component>?
    suspend fun save(component: Component): Incident
    suspend fun saveAll(components: List<Component>): List<Component>
    suspend fun delete(id: Uuid)
}