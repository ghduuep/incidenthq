package com.ghduep.incidenthq.domain

import kotlin.time.Clock
import kotlin.time.Instant
import kotlin.uuid.Uuid

data class IncidentUpdate(
    val id: Uuid = Uuid.random(),
    val message: String,
    val status: IncidentStatus,
    val createdAt: Instant = Clock.System.now(),
)
