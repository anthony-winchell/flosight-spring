package dev.anthonywinchell.flosight.dto;

import dev.anthonywinchell.flosight.enums.ProjectType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LeadRequest {

    @NotBlank
    private String fullName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotNull
    private LocalDate projectDate;

    @NotNull
    private ProjectType projectType;

    @NotBlank
    private String projectDescription;

    @NotBlank
    private String projectLocation;

    @NotBlank
    private String projectBudget;
}
