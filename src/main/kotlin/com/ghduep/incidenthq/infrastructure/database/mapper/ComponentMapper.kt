package com.ghduep.incidenthq.infrastructure.database.mapper

import com.ghduep.incidenthq.domain.Component
import com.ghduep.incidenthq.domain.ComponentStatus
import com.ghduep.incidenthq.infrastructure.database.entity.ComponentEntity

fun Component.toEntity() = ComponentEntity(
    id = this.id,
    name = this.name,
    description = this.description,
    status = this.status.name
)

fun ComponentEntity.toDomain() = Component (
    id = this.id,
    name = this.name,
    description = this.description,
    status = ComponentStatus.valueOf(this.status)
)