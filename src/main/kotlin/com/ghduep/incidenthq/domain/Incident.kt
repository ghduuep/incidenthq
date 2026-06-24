package com.ghduep.incidenthq.domain

import kotlin.time.Clock
import kotlin.time.Instant
import kotlin.uuid.Uuid

data class Incident(
    val id: Uuid = Uuid.random(),
    val title: String,
    val status: IncidentStatus,
    val impact: IncidentImpact,
    val affectedComponentIds: List<Uuid>,
    val createdAt: Instant = Clock.System.now(),
    val updatedAt: Instant = Clock.System.now(),
    val updates: List<IncidentUpdate> = emptyList(),
) {
    init {
        require(title.isNotEmpty()) { "Title must not be empty" }
    }
    fun isResolved(): Boolean = status == IncidentStatus.RESOLVED
}
