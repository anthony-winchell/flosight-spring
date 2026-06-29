package dev.anthonywinchell.flosight.service;

import dev.anthonywinchell.flosight.dto.LeadRequest;
import dev.anthonywinchell.flosight.entity.Lead;
import org.springframework.stereotype.Service;
import dev.anthonywinchell.flosight.repository.LeadRepository;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead createLead(LeadRequest request) {
        Lead lead = new Lead();

        lead.setFullName(request.getFullName());
        lead.setEmail(request.getEmail());
        lead.setPhone(request.getPhone());
        lead.setProjectDate(request.getProjectDate());
        lead.setProjectType(request.getProjectType());
        lead.setProjectDescription(request.getProjectDescription());
        lead.setProjectLocation(request.getProjectLocation());
        lead.setProjectBudget(request.getProjectBudget());

        return leadRepository.save(lead);
    }
}
