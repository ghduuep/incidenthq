package com.ghduep.incidenthq.application.dto

import kotlin.uuid.Uuid

data class ResolveIncidentCommand(
    val incidentId: Uuid,
    val resolutionMessage: String
)
