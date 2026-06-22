package com.ghduep.incidenthq.application.usecases

import com.ghduep.incidenthq.application.dto.CreateIncidentCommand
import com.ghduep.incidenthq.domain.ComponentStatus
import com.ghduep.incidenthq.domain.Incident
import com.ghduep.incidenthq.domain.IncidentImpact
import com.ghduep.incidenthq.domain.IncidentUpdate
import com.ghduep.incidenthq.domain.repository.ComponentRepository
import com.ghduep.incidenthq.domain.repository.IncidentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateIncidentUseCase (
    private val incidentRepository: IncidentRepository,
    private val componentRepository: ComponentRepository,) {
    @Transactional
    fun execute(command: CreateIncidentCommand): Incident {
        val components = componentRepository.findAllById(command.affectedComponentIds)
        if (components.isEmpty()) {
            throw IllegalArgumentException("At least one component must be present.")
        }

        val firstUpdate = IncidentUpdate(
            message = command.initialMessage,
            status = command.status
        )

        val incident = Incident(
            title = command.title,
            status = command.status,
            impact = command.impact,
            affectedComponentIds = components.map { it.id },
            updates = listOf(firstUpdate)
        )

        if (command.impact == IncidentImpact.CRITICAL) {
            val updatedComponents = components.map { component ->
                component.copy(status = ComponentStatus.MAJOR_OUTAGE)
            }

            componentRepository.saveAll(updatedComponents)
        }

        return incidentRepository.save(incident)
    }
}