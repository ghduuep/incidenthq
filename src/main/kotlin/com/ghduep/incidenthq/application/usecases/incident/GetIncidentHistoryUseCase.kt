package com.ghduep.incidenthq.application.usecases.incident

import com.ghduep.incidenthq.domain.Incident
import com.ghduep.incidenthq.domain.repository.IncidentRepository
import org.springframework.stereotype.Service
import kotlin.time.Clock
import kotlin.time.Duration.Companion.days

@Service
class GetIncidentHistoryUseCase(private val repository: IncidentRepository) {
    suspend fun execute(daysAgo: Long = 7): List<Incident> {
        require(daysAgo > 0) { "daysAgo must be greater than 0" }

        val cutOffDate = Clock.System.now().minus(daysAgo.days)

        val incidents = repository.findAllCreatedAfter(cutOffDate)

        return incidents.sortedByDescending { it.createdAt }
    }
}