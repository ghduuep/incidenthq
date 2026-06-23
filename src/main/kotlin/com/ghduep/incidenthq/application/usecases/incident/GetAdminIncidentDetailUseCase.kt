package com.ghduep.incidenthq.application.usecases.incident

import com.ghduep.incidenthq.domain.Incident
import com.ghduep.incidenthq.domain.repository.IncidentRepository
import org.springframework.stereotype.Service
import kotlin.uuid.Uuid

@Service
class GetAdminIncidentDetailUseCase(private val repository: IncidentRepository) {
    suspend fun execute(id: Uuid): Incident? {
        return repository.findById(id) ?: throw NoSuchElementException("Incident with id $id not found")
    }
}