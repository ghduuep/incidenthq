package com.ghduep.incidenthq.application.usecases.component

import com.ghduep.incidenthq.domain.Component
import com.ghduep.incidenthq.domain.repository.ComponentRepository
import org.springframework.stereotype.Service

@Service
class ListAdminComponentUseCase(private val repository: ComponentRepository) {
    suspend fun execute(): List<Component> {
        return repository.findAll()
    }
}