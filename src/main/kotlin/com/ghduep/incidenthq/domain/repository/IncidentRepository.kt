package com.ghduep.incidenthq.domain.repository

import com.ghduep.incidenthq.domain.Incident
import kotlin.uuid.Uuid

interface IncidentRepository {
    fun findAll(): List<Incident>
    fun findById(id: Uuid): Incident?
    fun save(incident: Incident)
    fun delete(id: Uuid)
}