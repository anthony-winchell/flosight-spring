package controller;

import dto.LeadRequest;
import entity.Lead;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.LeadService;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin("*")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping
    public ResponseEntity<Lead> createLead(@Valid @RequestBody LeadRequest leadRequest){
        Lead savedLead = leadService.createLead(leadRequest);
        return ResponseEntity.ok(savedLead);
    }
}
