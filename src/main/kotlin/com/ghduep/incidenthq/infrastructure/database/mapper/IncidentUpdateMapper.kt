package com.ghduep.incidenthq.infrastructure.database.mapper

import com.ghduep.incidenthq.domain.IncidentStatus
import com.ghduep.incidenthq.domain.IncidentUpdate
import com.ghduep.incidenthq.infrastructure.database.entity.IncidentUpdateEntity

fun IncidentUpdate.toEntity() = IncidentUpdateEntity(
    id = this.id,
    incidentId = this.incidentId,
    message = this.message,
    status = this.status.name,
    createdAt = this.createdAt,
)

fun IncidentUpdateEntity.toDomain() = IncidentUpdate(
    id = this.id,
    incidentId = this.incidentId,
    message = this.message,
    status = IncidentStatus.valueOf(this.status),
    createdAt = this.createdAt,
)