package io.fullstackbasics.talent_fulfillment_service.query.dto;

import java.time.LocalDate;

import fullstackbasics.io.tams_core_api.domain.CandidateSkills;
import fullstackbasics.io.tams_core_api.domain.EmploymentType;
import fullstackbasics.io.tams_core_api.domain.JobDescription;
import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import fullstackbasics.io.tams_core_api.domain.RoleLevel;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class TalentFulfillmentQueryResponseDTO {
 
	private String talentFulfillmentId;
	private String jobPostId;
	private String talentRequestId;
	private LocalDate startDate;
	private JobDescription jobDescription;
	private CandidateSkills candidateSkills;
	private RequestStatus requestStatus;
	private RoleLevel roleLevel;
	private EmploymentType employmentType;
}
