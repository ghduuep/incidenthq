package com.ghduep.incidenthq.domain.repository

import com.ghduep.incidenthq.domain.Incident
import kotlin.time.Instant
import kotlin.uuid.Uuid

interface IncidentRepository {
    suspend fun findAll(): List<Incident>
    suspend fun findAllPaginated(page: Int, size: Int): List<Incident>
    suspend fun findAllCreatedAfter(dateTime: Instant): List<Incident>
    suspend fun findById(id: Uuid): Incident?
    suspend fun save(incident: Incident)
    suspend fun delete(id: Uuid)
}