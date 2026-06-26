package com.ghduep.incidenthq.infrastructure.database.mapper

import com.ghduep.incidenthq.domain.Incident
import com.ghduep.incidenthq.domain.IncidentImpact
import com.ghduep.incidenthq.domain.IncidentStatus
import com.ghduep.incidenthq.infrastructure.database.entity.IncidentEntity

fun IncidentEntity.toDomainWithUpdates() = Incident(
    id = this.id,
    title = this.title,
    status = IncidentStatus.valueOf(this.status),
    impact = IncidentImpact.valueOf(this.impact),
    affectedComponentIds = this.affectedComponentIds,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
    updates = this.updates.map { it.toDomain() }
)

fun Incident.toEntity() = IncidentEntity(
    id = this.id,
    title = this.title,
    status = this.status.name,
    impact = this.impact.name,
    affectedComponentIds = this.affectedComponentIds,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
    updates = this.updates.map { it.toEntity() }
)