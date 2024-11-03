package io.fullstackbasics.talent_request_service.command.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.fullstackbasics.talent_request_service.command.dto.CreateTalentRequestCommandDTO;
import io.fullstackbasics.talent_request_service.command.service.TalentRequestService;

@RestController
@RequestMapping("talent-request")
public class TalentRequestCommandController {
	
	private final TalentRequestService talentRequestService;
	
	public TalentRequestCommandController(TalentRequestService talentRequestService) {
		this.talentRequestService = talentRequestService;
	}
	
	@PostMapping
	public ResponseEntity createTalentRequest(@RequestBody CreateTalentRequestCommandDTO createTalentRequestCommandDTO) {
		return talentRequestService.createNewTalentRequest(createTalentRequestCommandDTO);
	}

}
