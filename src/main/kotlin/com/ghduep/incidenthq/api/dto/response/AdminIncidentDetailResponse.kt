package com.ghduep.incidenthq.api.dto.response

import com.ghduep.incidenthq.domain.IncidentImpact
import com.ghduep.incidenthq.domain.IncidentStatus
import com.ghduep.incidenthq.domain.IncidentUpdate
import kotlin.time.Clock
import kotlin.time.Instant
import kotlin.uuid.Uuid

data class AdminIncidentDetailResponse(
    val title: String,
    val status: IncidentStatus,
    val impact: IncidentImpact,
    val affectedComponentIds: List<Uuid>,
    val createdAt: Instant = Clock.System.now(),
    val updatedAt: Instant = Clock.System.now(),
    val updates: List<IncidentUpdate>,
    )
