package dev.anthonywinchell.flosight.entity;

import dev.anthonywinchell.flosight.enums.LeadStatus;
import dev.anthonywinchell.flosight.enums.ProjectType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private LocalDate projectDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectType projectType;

    @Column(length = 2500, nullable = false)
    private String projectDescription;

    @Column(nullable = false)
    private String projectLocation;

    @Column(nullable = false)
    private String projectBudget;

    @Enumerated(EnumType.STRING)
    private LeadStatus status = LeadStatus.NEW;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
