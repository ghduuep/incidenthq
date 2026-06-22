package com.ghduep.incidenthq.api.controller.admin

import com.ghduep.incidenthq.api.dto.request.CreateIncidentRequest
import com.ghduep.incidenthq.api.dto.request.UpdateIncidentRequest
import com.ghduep.incidenthq.api.dto.response.AdminIncidentDetailResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/admin/incidents")
class AdminIncidentController {

    @GetMapping()
    suspend fun getIncidents() {}

    @GetMapping("/{id}")
    suspend fun getIncident(@PathVariable id: UUID) {}

    @PostMapping
    suspend fun createIncident(dto: CreateIncidentRequest): AdminIncidentDetailResponse {}

    @PatchMapping("/{id}")
    suspend fun updateIncident(dto: UpdateIncidentRequest): AdminIncidentDetailResponse {}

    @DeleteMapping("/{id}")
    suspend fun deleteIncident(@PathVariable id: UUID) {}
}