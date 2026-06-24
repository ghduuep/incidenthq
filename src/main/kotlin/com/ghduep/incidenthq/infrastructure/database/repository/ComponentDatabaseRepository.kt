package com.ghduep.incidenthq.infrastructure.database.repository

import com.ghduep.incidenthq.domain.Component
import com.ghduep.incidenthq.domain.ComponentStatus
import com.ghduep.incidenthq.domain.repository.ComponentRepository
import com.ghduep.incidenthq.infrastructure.database.entity.ComponentEntity
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Repository
import kotlin.uuid.Uuid

@Repository
class ComponentDatabaseRepository(private val r2dbcRepository: ComponentR2dbcRepository) : ComponentRepository {
    override suspend fun findAll(): List<Component> {
        return r2dbcRepository.findAll().map { entity -> entity.toDomain() }.toList()
    }

    override suspend fun findAllById(ids: List<Uuid>): List<Component> {
        return r2dbcRepository.findAllById(ids).map { entity -> entity.toDomain() }.toList()
    }

    override suspend fun save(component: Component): Component {
        val entity = component.toEntity()
        val savedEntity = r2dbcRepository.save(entity)
        return savedEntity.toDomain()
    }

    override suspend fun saveAll(components: List<Component>): List<Component> {
        return r2dbcRepository.saveAll(components.map { it.toEntity() }).map { it.toDomain() }.toList()
    }

    override suspend fun delete(id: Uuid) {
        r2dbcRepository.deleteById(id)
    }

    private fun Component.toEntity() = ComponentEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        status = this.status.name
    )

    private fun ComponentEntity.toDomain() = Component (
        id = this.id,
        name = this.name,
        description = this.description,
        status = ComponentStatus.valueOf(this.status)
    )
}