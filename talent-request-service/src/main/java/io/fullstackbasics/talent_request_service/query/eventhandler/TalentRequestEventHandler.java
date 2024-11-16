package io.fullstackbasics.talent_request_service.query.eventhandler;

import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import io.fullstackbasics.talent_request_service.core.events.TalentRequestCreatedEvent;
import io.fullstackbasics.talent_request_service.query.repository.TalentRequest;
import io.fullstackbasics.talent_request_service.query.repository.TalentRequestRepository;

@Component
public class TalentRequestEventHandler {
	
	private final Logger log = LoggerFactory.getLogger(TalentRequestEventHandler.class);

	private TalentRequestRepository talentRequestRepository;
	
	public TalentRequestEventHandler(TalentRequestRepository talentRequestRepository) {
		this.talentRequestRepository = talentRequestRepository;
		
	}
	
	 @EventHandler
	public void on(TalentRequestCreatedEvent talentRequestCreatedEvent) {
		
		TalentRequest talentRequest = new TalentRequest();
		BeanUtils.copyProperties(talentRequestCreatedEvent, talentRequest);
		log.info("Reached here to try to save talentRequest");
		talentRequestRepository.save(talentRequest);
		
	}
}
