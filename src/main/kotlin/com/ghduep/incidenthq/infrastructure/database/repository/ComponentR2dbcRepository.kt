package com.ghduep.incidenthq.infrastructure.database.repository

import com.ghduep.incidenthq.infrastructure.database.entity.ComponentEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import kotlin.uuid.Uuid

interface ComponentR2dbcRepository: CoroutineCrudRepository<ComponentEntity, Uuid>