package com.ghduep.incidenthq.application.usecases.incident

import com.ghduep.incidenthq.domain.Incident
import com.ghduep.incidenthq.domain.repository.IncidentRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

@Service
class ListAdminIncidentUseCase(private val incidentRepository: IncidentRepository) {
    fun execute(page: Int, size: Int): Flow<Incident> {
        return incidentRepository.findAllPaginated(page, size)
    }
}