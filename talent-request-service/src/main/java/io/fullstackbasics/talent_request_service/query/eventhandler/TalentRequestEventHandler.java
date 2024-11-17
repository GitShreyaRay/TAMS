package io.fullstackbasics.talent_request_service.query.eventhandler;

import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import io.fullstackbasics.talent_request_service.core.events.TalentRequestCreatedEvent;
import io.fullstackbasics.talent_request_service.core.events.TalentRequestStatusUpdatedEvent;
import io.fullstackbasics.talent_request_service.query.repository.TalentRequest;
import io.fullstackbasics.talent_request_service.query.repository.TalentFulfillmentRepository;

@Component
public class TalentRequestEventHandler {
	
	private final Logger log = LoggerFactory.getLogger(TalentRequestEventHandler.class);

	private TalentFulfillmentRepository talentRequestRepository;
	
	public TalentRequestEventHandler(TalentFulfillmentRepository talentRequestRepository) {
		this.talentRequestRepository = talentRequestRepository;
		
	}
	
	 @EventHandler
	public void on(TalentRequestCreatedEvent talentRequestCreatedEvent) {
		
		TalentRequest talentRequest = new TalentRequest();
		BeanUtils.copyProperties(talentRequestCreatedEvent, talentRequest);
		log.info("Reached here to try to save talentRequest");
		talentRequestRepository.save(talentRequest);
		
	}
	 
	 @EventHandler
	 public void on(TalentRequestStatusUpdatedEvent talentRequestStatusUpdatedEvent) {
		 
		 TalentRequest talentRequest = talentRequestRepository.findById(talentRequestStatusUpdatedEvent.getTalentRequestId()).get();
		 talentRequest.setRequestStatus(talentRequestStatusUpdatedEvent.getRequestStatus());
		 log.info("Reached here to try to update Talent Request Status");
		 talentRequestRepository.save(talentRequest);
		 
	 }
}
