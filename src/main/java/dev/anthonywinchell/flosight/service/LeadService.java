package dev.anthonywinchell.flosight.service;

import dev.anthonywinchell.flosight.dto.LeadRequest;
import dev.anthonywinchell.flosight.dto.LeadResponse;
import dev.anthonywinchell.flosight.dto.UpdateStatusRequest;
import dev.anthonywinchell.flosight.entity.Lead;
import dev.anthonywinchell.flosight.enums.LeadStatus;
import org.springframework.stereotype.Service;
import dev.anthonywinchell.flosight.repository.LeadRepository;

import java.util.List;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public LeadResponse createLead(LeadRequest request) {
        Lead lead = toEntity(request);
        Lead savedLead = leadRepository.save(lead);
        return toResponse(savedLead);
    }

    public List<LeadResponse> getAllLeads() {
        return leadRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(this::toResponse)
                .toList();
    }

    public LeadResponse getLeadById(Long id) {
        return leadRepository.findById(id).map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Lead not found"));
    }

    public LeadResponse updateStatus(UpdateStatusRequest request, Long id) {
        Lead lead = leadRepository.findById(id).orElseThrow(() -> new RuntimeException("Lead not found"));
        lead.setStatus(request.getStatus());
        Lead updatedLead = leadRepository.save(lead);
        return toResponse(updatedLead);
    }

    public List<LeadResponse> getLeadsByStatus(LeadStatus status) {
        return leadRepository.findAllByStatusOrderByCreatedAtDesc(status).stream()
                .map(this::toResponse)
                .toList();
    }

    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }


    // Helper methods to convert between entities and dtos
    private Lead toEntity(LeadRequest request) {
        return Lead.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .projectDate(request.getProjectDate())
                .projectType(request.getProjectType())
                .projectDescription(request.getProjectDescription())
                .projectLocation(request.getProjectLocation())
                .projectBudget(request.getProjectBudget())
                .build();
    }

    private LeadResponse toResponse(Lead lead) {
        return LeadResponse.builder()
                .id(lead.getId())
                .fullName(lead.getFullName())
                .email(lead.getEmail())
                .phone(lead.getPhone())
                .projectDate(lead.getProjectDate())
                .projectType(lead.getProjectType())
                .projectDescription(lead.getProjectDescription())
                .projectLocation(lead.getProjectLocation())
                .projectBudget(lead.getProjectBudget())
                .status(lead.getStatus())
                .createdAt(lead.getCreatedAt())
                .build();
    }

}
