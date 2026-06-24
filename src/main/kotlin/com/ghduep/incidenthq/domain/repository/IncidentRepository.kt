package com.ghduep.incidenthq.domain.repository

import com.ghduep.incidenthq.domain.Incident
import kotlinx.coroutines.flow.Flow
import kotlin.time.Instant
import kotlin.uuid.Uuid

interface IncidentRepository {
    fun findAll(): Flow<Incident>
    fun findAllPaginated(page: Int, size: Int): Flow<Incident>
    fun findAllCreatedAfter(dateTime: Instant): Flow<Incident>
    suspend fun findById(id: Uuid): Incident?
    suspend fun save(incident: Incident): Incident
    suspend fun delete(id: Uuid)
}