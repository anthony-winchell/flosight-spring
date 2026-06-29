package dto;

import enums.ProjectType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private LocalDate projectDate;

    @NotBlank
    private ProjectType projectType;

    @NotBlank
    private String projectDescription;

    @NotBlank
    private String projectLocation;

    @NotBlank
    private String projectBudget;
}
