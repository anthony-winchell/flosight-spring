package dev.anthonywinchell.flosight.dto;

import dev.anthonywinchell.flosight.enums.LeadStatus;
import dev.anthonywinchell.flosight.enums.ProjectType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeadResponse {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private LocalDate projectDate;
    private ProjectType projectType;
    private String projectDescription;
    private String projectLocation;
    private String projectBudget;
    private LeadStatus status;
    private LocalDateTime createdAt;

}