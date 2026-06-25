package com.ghduep.incidenthq.application.usecases.incident

import com.ghduep.incidenthq.domain.Incident
import com.ghduep.incidenthq.domain.repository.IncidentRepository
import org.springframework.stereotype.Service

@Service
class ListAdminIncidentUseCase(private val incidentRepository: IncidentRepository) {
    suspend fun execute(page: Int, size: Int): List<Incident> {
        return incidentRepository.findAllPaginated(page, size)
    }
}