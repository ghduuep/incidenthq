package com.ghduep.incidenthq.api.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateComponentRequest(
    @NotBlank(message = "Component name must not be empty")
    @field:Size(max = 100, message = "Incident title must between 100 characters")
    val name: String,

    val description: String?,

    val status: String?
)
