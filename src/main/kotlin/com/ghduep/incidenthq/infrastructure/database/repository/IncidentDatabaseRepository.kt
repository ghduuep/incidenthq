package com.ghduep.incidenthq.infrastructure.database.repository

import com.ghduep.incidenthq.domain.Incident
import com.ghduep.incidenthq.domain.IncidentImpact
import com.ghduep.incidenthq.domain.IncidentStatus
import com.ghduep.incidenthq.domain.repository.IncidentRepository
import com.ghduep.incidenthq.infrastructure.database.entity.IncidentEntity
import com.ghduep.incidenthq.infrastructure.database.mapper.toDomainWithUpdates
import com.ghduep.incidenthq.infrastructure.database.mapper.toEntity
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import kotlin.time.Instant
import kotlin.uuid.Uuid

@Repository
class IncidentDatabaseRepository(private val repository: IncidentR2dbcRepository):
    IncidentRepository {
    override suspend fun findAll(): List<Incident> {
        return repository.findAll().map { it.toDomainWithUpdates() }.toList()
    }

    override suspend fun findAllCreatedAfter(dateTime: Instant): List<Incident> {
        return repository.findAllCreatedAfter(datetime).map { it.toDomainWithUpdates() }.toList()
    }

    override suspend fun findById(id: Uuid): Incident? {
        val entity = repository.findById(id) ?: return null
        return entity.toDomainWithUpdates()
    }

    @Transactional
    override suspend fun save(incident: Incident): Incident {
        val saved = repository.save(incident.toEntity())
        repository.deleteByIncidentId(saved.id)
        if (incident.updates.isNotEmpty()) {
            repository.saveAll(incident.updates.map { it.toEntity(saved.id) }).toList()
        }
        return saved.toDomainWithUpdates()
    }

    override suspend fun delete(id: Uuid) {
        repository.deleteByIncidentId(id)
        repository.deleteById(id)
    }
}