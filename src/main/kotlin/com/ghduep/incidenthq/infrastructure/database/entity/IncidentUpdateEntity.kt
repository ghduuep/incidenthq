package com.ghduep.incidenthq.infrastructure.database.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import kotlin.time.Instant
import kotlin.uuid.Uuid

@Table("incident_updates")
data class IncidentUpdateEntity(
    @Id val id: Uuid,
    val incidentId: Uuid,
    val message: String,
    val status: String,
    val createdAt: Instant
)
