package com.ghduep.incidenthq.application.dto

import com.ghduep.incidenthq.domain.IncidentImpact
import com.ghduep.incidenthq.domain.IncidentStatus
import kotlin.uuid.Uuid

data class CreateIncidentCommand(
    val title: String,
    val status: IncidentStatus,
    val impact: IncidentImpact,
    val initialMessage: String,
    val affectedComponentIds: List<Uuid>
)
