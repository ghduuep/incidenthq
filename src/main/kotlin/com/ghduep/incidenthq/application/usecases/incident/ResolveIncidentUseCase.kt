package com.ghduep.incidenthq.application.usecases.incident

import com.ghduep.incidenthq.application.dto.ResolveIncidentCommand
import com.ghduep.incidenthq.domain.ComponentStatus
import com.ghduep.incidenthq.domain.Incident
import com.ghduep.incidenthq.domain.IncidentStatus
import com.ghduep.incidenthq.domain.IncidentUpdate
import com.ghduep.incidenthq.domain.repository.ComponentRepository
import com.ghduep.incidenthq.domain.repository.IncidentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.time.Clock

@Service
class ResolveIncidentUseCase(private val incidentRepository: IncidentRepository, private val componentRepository: ComponentRepository) {
    @Transactional
    suspend fun execute(command: ResolveIncidentCommand): Incident {
        val incident = incidentRepository.findById(command.incidentId) ?: throw NoSuchElementException("Incident not found")

        if (incident.isResolved()) {
            return incident
        }

        val finalUpdate = IncidentUpdate(
            message = command.resolutionMessage,
            status = IncidentStatus.RESOLVED
        )

        val resolvedIncident = incident.copy(
            status = IncidentStatus.RESOLVED,
            updatedAt = Clock.System.now(),
            updates = incident.updates + finalUpdate
        )

        if (incident.affectedComponentIds.isNotEmpty()) {
            val affectedComponents = componentRepository.findAllById(incident.affectedComponentIds)

            val normalizedComponents = affectedComponents.map { component -> component.copy(status = ComponentStatus.OPERATIONAL)}

            componentRepository.saveAll(normalizedComponents)
        }

        return incidentRepository.save(resolvedIncident)
    }
}