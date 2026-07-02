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
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping("/leads")
    public ResponseEntity<LeadResponse> createLead(@Valid @RequestBody LeadRequest leadRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(leadService.createLead(leadRequest));
    }

}
