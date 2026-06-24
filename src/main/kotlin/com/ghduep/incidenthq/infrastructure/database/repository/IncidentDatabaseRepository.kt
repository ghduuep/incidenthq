package com.ghduep.incidenthq.infrastructure.database.repository

import com.ghduep.incidenthq.domain.Incident
import com.ghduep.incidenthq.domain.repository.IncidentRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Repository
import kotlin.time.Instant
import kotlin.uuid.Uuid

@Repository
class IncidentDatabaseRepository(private val incidentRepository: IncidentR2dbcRepository, private val updateRepository: IncidentUpdateR2dbcRepository):
    IncidentRepository {
    override suspend fun findAll(): List<Incident> {
        return incidentRepository.findAll().map { it.toDomainWithUpdates() }.toList()
    }

    override suspend fun findAllPaginated(
        page: Int,
        size: Int
    ): List<Incident> {
        val offset = page * size
        return incidentRepository.findAllPaginated(size, offset).map { it.toDomainWithUpdates() }.toList()
    }

    override suspend fun findAllCreatedAfter(dateTime: Instant): List<Incident> {
        return incidentRepository.findAllCreatedAfter(datetime).map { it.toDomainWithUpdates() }.toList()
    }

    override suspend fun findById(id: Uuid): Incident? {
        val entity = incidentRepository.findById(id) ?: return null
        return entity.toDomainWithUpdates()
    }

    override suspend fun save(incident: Incident): Incident {
        val saved = incidentRepository.save(incident.toEntity())
        updateRepository.deleteByIncidentId(saved.id)
        if (incident.updates.isNotEmpty()) {
            updateRepository.saveAll(incident.updates.map { it.toEntity(saved.id) }).toList()
        }
        return saved.toDomainWithUpdates()
    }

    override suspend fun delete(id: Uuid) {
        updateRepository.deleteByIncidentId(id)
        incidentRepository.deleteById(id)
    }

    private fun Inci

}