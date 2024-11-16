package io.fullstackbasics.talent_fulfillment_service.command.aggregate;

import java.time.LocalDate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import fullstackbasics.io.tams_core_api.command.CreateTalentFulfillmentCommand;
import fullstackbasics.io.tams_core_api.domain.CandidateSkills;
import fullstackbasics.io.tams_core_api.domain.EmploymentType;
import fullstackbasics.io.tams_core_api.domain.JobDescription;
import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import fullstackbasics.io.tams_core_api.domain.RoleLevel;
import fullstackbasics.io.tams_core_api.event.TalentFulfillmentCreatedEvent;

@Aggregate
public class TalentFulfillmentAggregate {
	
	@AggregateIdentifier
	private String talentFulfillmentId;
	private String jobPostId;
	private String talentRequestId;
	private String talentRequestTitle;
	private JobDescription jobDescription;
	private CandidateSkills candidateSkills;
	private RequestStatus requestStatus;
	private LocalDate startDate;
	private RoleLevel roleLevel;
	private EmploymentType employmentType;
	
	@CommandHandler
	public TalentFulfillmentAggregate(CreateTalentFulfillmentCommand createTalentFulfillmentCommand) {
		TalentFulfillmentCreatedEvent talentFulfillmentCreatedEvent = new TalentFulfillmentCreatedEvent();
		BeanUtils.copyProperties(createTalentFulfillmentCommand, talentFulfillmentCreatedEvent);
		
		talentFulfillmentCreatedEvent.setRequestStatus(RequestStatus.ASSIGNED_TO_TA);
		
		AggregateLifecycle.apply(talentFulfillmentCreatedEvent);

	}

	@EventSourcingHandler
	public void on(TalentFulfillmentCreatedEvent talentFulfillmentCreatedEvent) {
		talentFulfillmentId = talentFulfillmentCreatedEvent.getTalentFulfillmentId();
		jobPostId = talentFulfillmentCreatedEvent.getJobPostId();
		talentRequestId = talentFulfillmentCreatedEvent.getTalentRequestId();
		talentRequestTitle = talentFulfillmentCreatedEvent.getTalentRequestTitle();		
		startDate = talentFulfillmentCreatedEvent.getStartDate();
		jobDescription= talentFulfillmentCreatedEvent.getJobDescription();
		candidateSkills= talentFulfillmentCreatedEvent.getCandidateSkills();
		requestStatus= talentFulfillmentCreatedEvent.getRequestStatus();
	}


	

	
	
	
}
