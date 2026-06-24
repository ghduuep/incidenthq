package com.ghduep.incidenthq.domain.repository

import com.ghduep.incidenthq.domain.Component
import com.ghduep.incidenthq.domain.Incident
import kotlinx.coroutines.flow.Flow
import kotlin.uuid.Uuid

interface ComponentRepository {
    fun findAll(): Flow<Component>
    fun findAllById(ids: List<Uuid>): Flow<Component>?
    suspend fun save(component: Component): Component
    fun saveAll(components: Flow<Component>): Flow<Component>
    suspend fun delete(id: Uuid)
}