package com.ghduep.incidenthq.api.controller.admin

import com.ghduep.incidenthq.api.dto.request.CreateIncidentRequest
import com.ghduep.incidenthq.api.dto.request.UpdateIncidentRequest
import com.ghduep.incidenthq.api.dto.response.AdminIncidentDetailResponse
import com.ghduep.incidenthq.application.dto.ResolveIncidentCommand
import com.ghduep.incidenthq.application.usecases.incident.ResolveIncidentUseCase
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.uuid.Uuid
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/api/v1/admin/incidents")
class AdminIncidentController {

    @GetMapping()
    suspend fun getIncidents() {
    }

    @GetMapping("/{id}")
    suspend fun getIncident(@PathVariable id: Uuid) {}

    @PostMapping
    suspend fun createIncident(@RequestBody dto: CreateIncidentRequest): AdminIncidentDetailResponse {}

    @PutMapping("/{id}")
    suspend fun resolveIncident(@PathVariable id: Uuid, @RequestBody dto: ResolveIncidentRequest): AdminIncidentDetailResponse {
        val command = ResolveIncidentCommand(
            incidentId = id,
            resolutionMessage = dto.message
        )

        val resolvedIncident = ResolveIncidentUseCase.execute(command)
        return AdminIncidentDetailResponse()
    }

    @PatchMapping("/{id}")
    suspend fun updateIncident(@PathVariable id: Uuid, @RequestBody dto: UpdateIncidentRequest): AdminIncidentDetailResponse {}

    @DeleteMapping("/{id}")
    suspend fun deleteIncident(@PathVariable id: Uuid) {}
}