package com.ghduep.incidenthq.infrastructure.database.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import kotlin.uuid.Uuid

@Table("components")
data class ComponentEntity(
    @Id val id: Uuid,
    val name: String,
    val description: String?,
    val status: String,
)
