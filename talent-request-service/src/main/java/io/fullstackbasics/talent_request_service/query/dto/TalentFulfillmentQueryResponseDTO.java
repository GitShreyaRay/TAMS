package io.fullstackbasics.talent_request_service.query.dto;

import java.time.LocalDate;

import fullstackbasics.io.tams_core_api.domain.CandidateSkills;
import fullstackbasics.io.tams_core_api.domain.JobDescription;
import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import lombok.Data;

@Data
public class TalentFulfillmentQueryResponseDTO {
 
    private String talentRequestId;
    private String talentRequestTitle;
 
    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
 
    private RequestStatus requestStatus;
 
    private LocalDate startDate;
}
