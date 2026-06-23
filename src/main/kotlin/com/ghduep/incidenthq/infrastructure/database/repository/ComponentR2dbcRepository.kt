package com.ghduep.incidenthq.infrastructure.database.repository

import com.ghduep.incidenthq.infrastructure.database.entity.IncidentUpdateEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import kotlin.uuid.Uuid

interface ComponentR2dbcRepository: CoroutineCrudRepository<IncidentUpdateEntity, Uuid>