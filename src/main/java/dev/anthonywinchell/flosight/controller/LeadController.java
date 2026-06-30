package dev.anthonywinchell.flosight.controller;

import dev.anthonywinchell.flosight.dto.LeadRequest;
import dev.anthonywinchell.flosight.dto.LeadResponse;
import dev.anthonywinchell.flosight.dto.UpdateStatusRequest;
import dev.anthonywinchell.flosight.enums.LeadStatus;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(leadService.createLead(leadRequest));
    }

    @GetMapping("/admin/leads")
    public ResponseEntity<List<LeadResponse>> getLeads(
            @RequestParam(required = false) LeadStatus status
    ){
        List<LeadResponse> leads = (status != null) ?
                leadService.getLeadsByStatus(status) :
                leadService.getAllLeads();
        return ResponseEntity.ok(leads);
    }

    @GetMapping("/admin/leads/{id}")
    public ResponseEntity<LeadResponse> getLead(@PathVariable Long id) {
        return ResponseEntity.ok(leadService.getLeadById(id));
    }

    @PatchMapping("/admin/leads/{id}/status")
    public ResponseEntity<LeadResponse> updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStatusRequest updateStatusRequest
    ) {
        return ResponseEntity.ok(leadService.updateStatus(updateStatusRequest, id));
    }

    @DeleteMapping("/admin/leads/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }

}
