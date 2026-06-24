package com.ghduep.incidenthq.domain.repository

import com.ghduep.incidenthq.domain.IncidentUpdate
import kotlin.time.Instant
import kotlin.uuid.Uuid

interface IncidentUpdateRepository {
    suspend fun findByIncidentId(incidentId: Uuid): List<IncidentUpdate>
    suspend fun findAllCreatedBetween(from: Instant, to: Instant): List<IncidentUpdate>
}