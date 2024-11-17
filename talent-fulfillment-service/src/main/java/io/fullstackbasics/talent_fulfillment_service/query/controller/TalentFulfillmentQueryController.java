package io.fullstackbasics.talent_fulfillment_service.query.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.fullstackbasics.talent_fulfillment_service.query.service.TalentFulfillmentQueryService;

@RestController
@RequestMapping("talent-fulfillment")
public class TalentFulfillmentQueryController {
	
	private final TalentFulfillmentQueryService talentFulfillmentQueryService;

	public TalentFulfillmentQueryController(TalentFulfillmentQueryService talentFulfillmentQueryService) {
		this.talentFulfillmentQueryService = talentFulfillmentQueryService;
	}


	
	 @GetMapping
	    public ResponseEntity findAllTalentRequests(){
	        return talentFulfillmentQueryService.findAllTalentFulfillmentRequests();
	    }
	    
	    @GetMapping("/{talentFulfillmentId}")
	    public ResponseEntity findTalentRequestByTalentRequestId(@PathVariable String talentFulfillmentId) throws ExecutionException, InterruptedException{
	        return talentFulfillmentQueryService.FindTalentFulfillmentByTalentFulfillmentId(talentFulfillmentId);
	    }

}
