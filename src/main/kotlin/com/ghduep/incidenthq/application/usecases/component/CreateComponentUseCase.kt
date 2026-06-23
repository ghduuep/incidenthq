package com.ghduep.incidenthq.application.usecases.component

import com.ghduep.incidenthq.application.dto.CreateComponentCommand
import com.ghduep.incidenthq.domain.Component
import com.ghduep.incidenthq.domain.repository.ComponentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateComponentUseCase(private val repository: ComponentRepository) {
    @Transactional
    suspend fun execute(command: CreateComponentCommand) {
        val component = Component(
            name = command.name,
            description = command.description,
            status = command.status
        )

        repository.save(component)
    }
}