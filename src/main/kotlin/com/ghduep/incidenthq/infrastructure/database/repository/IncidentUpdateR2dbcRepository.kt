package com.ghduep.incidenthq.infrastructure.database.repository

import com.ghduep.incidenthq.infrastructure.database.entity.IncidentUpdateEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import kotlin.uuid.Uuid

interface IncidentUpdateR2dbcRepository: CoroutineCrudRepository<IncidentUpdateEntity, Uuid>