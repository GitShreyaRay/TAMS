package io.fullstackbasics.talent_request_service.command.command;

import java.time.LocalDate;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import fullstackbasics.io.tams_core_api.domain.CandidateSkills;
import fullstackbasics.io.tams_core_api.domain.JobDescription;
import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTalentRequestCommand {

	@TargetAggregateIdentifier
	private String talentRequestId;
	private String talentRequestTitle;
	private JobDescription jobDescription;
	private CandidateSkills candidateSkills;
	private RequestStatus requestStatus;
	private LocalDate startDate;

	
}
