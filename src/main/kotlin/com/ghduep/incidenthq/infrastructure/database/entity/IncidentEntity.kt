package com.ghduep.incidenthq.infrastructure.database.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import kotlin.time.Instant
import kotlin.uuid.Uuid

@Table("incidents")
data class IncidentEntity(
    @Id val id: Uuid,
    val name: String,
    val status: String,
    val impact: String,
    val affectedComponentIds: String,
    val createdAt: Instant,
    val updatedAt: Instant
)
