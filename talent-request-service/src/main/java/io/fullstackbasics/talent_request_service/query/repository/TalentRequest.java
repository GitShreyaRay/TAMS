package io.fullstackbasics.talent_request_service.query.repository;

import java.time.LocalDate;

import fullstackbasics.io.tams_core_api.domain.CandidateSkills;
import fullstackbasics.io.tams_core_api.domain.JobDescription;
import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TalentRequest {
	
	@Id
	private String talentRequestId;
	private String talentRequestTitle;
	
	@Embedded
	private JobDescription jobDescription;
	@Embedded
	private CandidateSkills candidateSkills;
	
	@Enumerated(EnumType.STRING)
	private RequestStatus requestStatus;
	private LocalDate startDate;

}
