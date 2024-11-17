package io.fullstackbasics.talent_fulfillment_service.query.eventhandler;

import java.util.UUID;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import fullstackbasics.io.tams_core_api.domain.EmploymentType;
import fullstackbasics.io.tams_core_api.domain.RoleLevel;
import fullstackbasics.io.tams_core_api.event.TalentFulfillmentCreatedEvent;
import io.fullstackbasics.talent_fulfillment_service.query.repository.TalentFulfillment;
import io.fullstackbasics.talent_fulfillment_service.query.repository.TalentFulfillmentRepository;

@Component
public class TalentFulfillmentEventHandler {

	private TalentFulfillmentRepository talentFulfillmentRepository;

	public TalentFulfillmentEventHandler(TalentFulfillmentRepository talentFulfillmentRepository) {
		this.talentFulfillmentRepository = talentFulfillmentRepository;
	}
	
	@EventHandler
	void on(TalentFulfillmentCreatedEvent talentFulfillmentCreatedEvent) {
		TalentFulfillment talentFulfillment = new TalentFulfillment();
		BeanUtils.copyProperties(talentFulfillmentCreatedEvent, talentFulfillment);
		
		talentFulfillment.setRoleLevel(RoleLevel.INDIVIDUAL_CONTRIBUTOR);
		talentFulfillment.setJobPostId(UUID.randomUUID().toString());
		talentFulfillment.setEmploymentType(EmploymentType.FULL_TIME);
		
		talentFulfillmentRepository.save(talentFulfillment);
	}
}
