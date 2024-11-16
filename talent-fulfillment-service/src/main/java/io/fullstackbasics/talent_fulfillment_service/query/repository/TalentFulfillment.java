package io.fullstackbasics.talent_fulfillment_service.query.repository;

import java.time.LocalDate;

import fullstackbasics.io.tams_core_api.domain.CandidateSkills;
import fullstackbasics.io.tams_core_api.domain.EmploymentType;
import fullstackbasics.io.tams_core_api.domain.JobDescription;
import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import fullstackbasics.io.tams_core_api.domain.RoleLevel;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TalentFulfillment {
	
	@Id
	private String talentFulfillmentId;
	private String jobPostId;
	private String talentRequestId;
	private LocalDate startDate;
	@Embedded
	private JobDescription jobDescription;
	@Embedded
	private CandidateSkills candidateSkills;
	@Enumerated(EnumType.STRING)
	private RequestStatus requestStatus;
	@Enumerated(EnumType.STRING)
	private RoleLevel roleLevel;
	@Enumerated(EnumType.STRING)
	private EmploymentType employmentType;

}
