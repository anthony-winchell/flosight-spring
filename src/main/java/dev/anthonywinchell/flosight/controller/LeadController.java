package dev.anthonywinchell.flosight.controller;

import dev.anthonywinchell.flosight.dto.LeadRequest;
import dev.anthonywinchell.flosight.dto.LeadResponse;
import dev.anthonywinchell.flosight.dto.UpdateStatusRequest;
import dev.anthonywinchell.flosight.enums.LeadStatus;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.anthonywinchell.flosight.service.LeadService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping("/leads")
    public ResponseEntity<LeadResponse> createLead(@Valid @RequestBody LeadRequest leadRequest){
        return ResponseEntity.ok(leadService.createLead(leadRequest));
    }

    @GetMapping("/admin/leads")
    public List<LeadResponse> getLeads(
            @RequestParam(required = false) LeadStatus status
    ){
        if(status != null){
            return leadService.getLeadsByStatus(status);
        } else {
            return leadService.getAllLeads();
        }
    }

    @GetMapping("/admin/leads/{id}")
    public LeadResponse getLead(@PathVariable Long id) {
        return leadService.getLeadById(id);
    }

    @PatchMapping("/admin/leads/{id}/status")
    public LeadResponse updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateStatusRequest updateStatusRequest
    ) {
        return leadService.updateStatus(updateStatusRequest, id);
    }

    @DeleteMapping("/admin/leads/{id}")
    public void deleteLead(@PathVariable Long id) {
        leadService.deleteLead(id);
    }

}
