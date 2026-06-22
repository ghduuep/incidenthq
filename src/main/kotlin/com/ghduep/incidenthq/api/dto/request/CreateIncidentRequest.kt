package com.ghduep.incidenthq.api.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import kotlin.uuid.Uuid

data class CreateIncidentRequest(
    @field:NotBlank(message = "Incident title cannot be empty")
    @field:Size(max = 100, message = "Incident title must between 100 characters")
    val title: String,

    @field:NotBlank(message = "Initial status is required")
    val status: String,

    @field:NotBlank(message = "Impact is required")
    val impact: String,

    @field:NotBlank(message = "Initial message is required")
    val message: String,

    @field:NotEmpty(message = "At least one component must be affected")
    val affectedComponents: List<Uuid>
)
