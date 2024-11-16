package io.fullstackbasics.talent_request_service.saga;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import fullstackbasics.io.tams_core_api.command.CreateTalentFulfillmentCommand;
import io.fullstackbasics.talent_request_service.core.events.TalentRequestCreatedEvent;

@Saga
public class TalentRequestSaga {
	
	public static final String TALENT_REQUEST_ID = "talentRequestId";

	@Autowired
	private transient CommandGateway commandGateway;
	
	@StartSaga
	@SagaEventHandler(associationProperty=TALENT_REQUEST_ID)
	public void handle(TalentRequestCreatedEvent talentRequestCreatedEvent) {
		
		CreateTalentFulfillmentCommand createTalentFulfillmentCommand =CreateTalentFulfillmentCommand.builder()
				.talentFulfillmentId(UUID.randomUUID().toString())
				.talentRequestId(talentRequestCreatedEvent.getTalentRequestId())
				.talentRequestTitle(talentRequestCreatedEvent.getTalentRequestTitle())
				.jobDescription(talentRequestCreatedEvent.getJobDescription())
				.candidateSkills(talentRequestCreatedEvent.getCandidateSkills())
				.requestStatus(talentRequestCreatedEvent.getRequestStatus())
				.startDate(talentRequestCreatedEvent.getStartDate())
				.build();
		
		commandGateway.send(createTalentFulfillmentCommand);
				
		
	}
}
