package io.fullstackbasics.talent_request_service.command.aggregate;

import java.time.LocalDate;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import fullstackbasics.io.tams_core_api.domain.CandidateSkills;
import fullstackbasics.io.tams_core_api.domain.JobDescription;
import fullstackbasics.io.tams_core_api.domain.RequestStatus;

@Aggregate
public class TalentRequestAggregrate {

	@AggregateIdentifier
	private String talentRequestID;
	private String talentRequestTitle;
	private JobDescription jobDescription;
	private CandidateSkills candidateSkills;
	private RequestStatus requestStatus;
	private LocalDate startDate;
	
	public TalentRequestAggregrate() {
	}
	
}
