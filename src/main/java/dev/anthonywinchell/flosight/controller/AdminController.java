package dev.anthonywinchell.flosight.controller;

import dev.anthonywinchell.flosight.dto.LeadResponse;
import dev.anthonywinchell.flosight.dto.UpdateStatusRequest;
import dev.anthonywinchell.flosight.enums.LeadStatus;
import dev.anthonywinchell.flosight.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final LeadService leadService;

    public AdminController(LeadService leadService) {
        this.leadService = leadService;
    }


    @GetMapping("/leads")
    public ResponseEntity<List<LeadResponse>> getLeads(
            @RequestParam(required = false) LeadStatus status
    ){
        List<LeadResponse> leads = (status != null) ?
                leadService.getLeadsByStatus(status) :
                leadService.getAllLeads();
        return ResponseEntity.ok(leads);
    }

    @GetMapping("/leads/{id}")
    public ResponseEntity<LeadResponse> getLead(@PathVariable Long id) {
        return ResponseEntity.ok(leadService.getLeadById(id));
    }

    @PatchMapping("/leads/{id}/status")
    public ResponseEntity<LeadResponse> updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStatusRequest updateStatusRequest
    ) {
        return ResponseEntity.ok(leadService.updateStatus(updateStatusRequest, id));
    }

    @DeleteMapping("/leads/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }


}
