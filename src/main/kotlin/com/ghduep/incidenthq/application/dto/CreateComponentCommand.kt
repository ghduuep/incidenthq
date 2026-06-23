package com.ghduep.incidenthq.application.dto

import com.ghduep.incidenthq.domain.ComponentStatus

data class CreateComponentCommand(
    val name: String,
    val description: String?,
    val status: ComponentStatus,
)
