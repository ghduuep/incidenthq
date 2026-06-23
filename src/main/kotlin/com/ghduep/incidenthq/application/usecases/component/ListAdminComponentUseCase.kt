package com.ghduep.incidenthq.application.usecases.component

import com.ghduep.incidenthq.domain.Component
import com.ghduep.incidenthq.domain.repository.ComponentRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

@Service
class ListAdminComponentUseCase(private val repository: ComponentRepository) {
    fun execute(): Flow<Component> {
        return repository.findAll()
    }
}