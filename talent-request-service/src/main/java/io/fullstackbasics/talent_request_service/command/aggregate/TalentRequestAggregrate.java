package io.fullstackbasics.talent_request_service.command.aggregate;

import java.time.LocalDate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import fullstackbasics.io.tams_core_api.domain.CandidateSkills;
import fullstackbasics.io.tams_core_api.domain.JobDescription;
import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import io.fullstackbasics.talent_request_service.command.command.CreateTalentRequestCommand;
import io.fullstackbasics.talent_request_service.core.events.TalentRequestCreatedEvent;

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
	
	@CommandHandler
	public TalentRequestAggregrate(CreateTalentRequestCommand createTalentRequestCommand) {
		TalentRequestCreatedEvent talentRequestCreatedEvent = new TalentRequestCreatedEvent();
		BeanUtils.copyProperties(createTalentRequestCommand, talentRequestCreatedEvent);
		
		AggregateLifecycle.apply(talentRequestCreatedEvent);
	}
	
	@EventSourcingHandler
	public void on(TalentRequestCreatedEvent talentRequestCreatedEvent) {
		this.talentRequestID = talentRequestCreatedEvent.getTalentRequestId();
		this.talentRequestTitle = talentRequestCreatedEvent.getTalentRequestTitle();
		this.jobDescription = talentRequestCreatedEvent.getJobDescription();
		this.candidateSkills = talentRequestCreatedEvent.getCandidateSkills();
		this.requestStatus = talentRequestCreatedEvent.getRequestStatus();
		this.startDate = talentRequestCreatedEvent.getStartDate();
	}
}
