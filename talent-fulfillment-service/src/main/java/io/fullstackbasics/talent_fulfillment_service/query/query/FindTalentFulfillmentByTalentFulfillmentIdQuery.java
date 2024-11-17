package io.fullstackbasics.talent_fulfillment_service.query.query;

import lombok.Data;

@Data
public class FindTalentFulfillmentByTalentFulfillmentIdQuery {
	private String talentFulfillmentId;

	public FindTalentFulfillmentByTalentFulfillmentIdQuery(String talentFulfillmentId) {
		this.talentFulfillmentId = talentFulfillmentId;
	}
	
	

}
