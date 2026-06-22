package com.ghduep.incidenthq.domain

import kotlin.uuid.Uuid

data class Component(
    val id: Uuid = Uuid.random(),
    val name: String,
    val description: String?,
    val status: ComponentStatus = ComponentStatus.OPERATIONAL
)
