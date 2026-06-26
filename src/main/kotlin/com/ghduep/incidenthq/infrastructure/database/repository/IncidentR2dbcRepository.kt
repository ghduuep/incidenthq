package com.ghduep.incidenthq.infrastructure.database.repository

import com.ghduep.incidenthq.infrastructure.database.entity.IncidentEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import kotlin.uuid.Uuid

interface IncidentR2dbcRepository: CoroutineCrudRepository<IncidentEntity, Uuid> {

}