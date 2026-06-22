package com.ghduep.incidenthq.domain.repository

import com.ghduep.incidenthq.domain.Component
import kotlin.uuid.Uuid

interface ComponentRepository {
    fun findAll(): List<Component>
    fun findAllById(id: Uuid): Component?
    fun save(component: Component)
    fun delete(id: Uuid)
}