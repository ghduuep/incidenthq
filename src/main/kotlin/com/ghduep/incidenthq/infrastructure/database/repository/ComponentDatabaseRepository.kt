package com.ghduep.incidenthq.infrastructure.database.repository

import com.ghduep.incidenthq.domain.Component
import com.ghduep.incidenthq.domain.ComponentStatus
import com.ghduep.incidenthq.domain.repository.ComponentRepository
import com.ghduep.incidenthq.infrastructure.database.entity.ComponentEntity
import com.ghduep.incidenthq.infrastructure.database.entity.IncidentEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Repository
import kotlin.uuid.Uuid

@Repository
class ComponentDatabaseRepository(private val r2dbcRepository: ComponentR2dbcRepository) : ComponentRepository {
    override fun findAll(): Flow<Component> {
        return r2dbcRepository.findAll().map { entity -> entity.toDomain() }
    }

    override fun findAllById(id: Uuid): Flow<Component>? {
        TODO("Not yet implemented")
    }

    override suspend fun save(component: Component): Component {
        val entity = component.toEntity()
        val savedEntity = r2dbcRepository.save(entity)
        return savedEntity.toDomain()
    }

    override fun saveAll(components: List<Component>): Flow<Component> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Uuid) {
        r2dbcRepository.deleteById(id)
    }

    private fun Component.toEntity() = ComponentEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        status = ComponentStatus.valueOf(this.status)
    )

    private fun Component.toDomain() = Component (
        id = this.id,
        name = this.name,
        description = this.description,
        status = ComponentStatus.valueOf(this.status)
    )
}