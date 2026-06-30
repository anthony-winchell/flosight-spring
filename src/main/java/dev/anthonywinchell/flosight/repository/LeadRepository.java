package dev.anthonywinchell.flosight.repository;

import dev.anthonywinchell.flosight.entity.Lead;
import dev.anthonywinchell.flosight.enums.LeadStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, Long> {
    List<Lead> findAllByOrderByCreatedAtDesc();
    List<Lead> findAllByStatusOrderByCreatedAtDesc(LeadStatus status);
}
