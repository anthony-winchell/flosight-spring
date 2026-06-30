package dev.anthonywinchell.flosight.dto;

import dev.anthonywinchell.flosight.enums.LeadStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStatusRequest {
    private LeadStatus status;
}
