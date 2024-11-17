package io.fullstackbasics.talent_request_service.command.service;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import io.fullstackbasics.talent_request_service.command.command.CreateTalentRequestCommand;
import io.fullstackbasics.talent_request_service.command.dto.CreateTalentRequestCommandDTO;
import io.fullstackbasics.talent_request_service.command.dto.TalentRequestResponseDTO;

@Service
public class TalentRequestService {
	
	private final CommandGateway commandGateway;
	private final Logger log = LoggerFactory.getLogger(TalentRequestService.class);
	
	public TalentRequestService(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	public ResponseEntity createNewTalentRequest(CreateTalentRequestCommandDTO createTalentRequestCommandDTO) {
		
		log.info("coreSkill :" + createTalentRequestCommandDTO.getCandidateSkills().getCoreSkill());
		CreateTalentRequestCommand createTalentRequestCommand = CreateTalentRequestCommand.builder()
				.talentRequestId(UUID.randomUUID().toString())
				.requestStatus(RequestStatus.OPEN)
				.talentRequestTitle(createTalentRequestCommandDTO.getTalentRequestTitle())
				.jobDescription(createTalentRequestCommandDTO.getJobDescription())
				.candidateSkills(createTalentRequestCommandDTO.getCandidateSkills())
				.startDate(createTalentRequestCommandDTO.getStartDate())
				.build();
		
		log.info("-------------After CreateTalentRequestCommand.build() coreSkill " + createTalentRequestCommand.getCandidateSkills().getCoreskill() + "-------------");
		
		try {
			commandGateway.sendAndWait(createTalentRequestCommand);
			TalentRequestResponseDTO talentRequestResponseDTO = new TalentRequestResponseDTO();
			BeanUtils.copyProperties(createTalentRequestCommand, talentRequestResponseDTO);
			
			return new ResponseEntity<>(talentRequestResponseDTO, HttpStatus.CREATED);
		} catch (Exception exception) {
			var exceptionMessage = "Unable to create new Talent Request";
			return new ResponseEntity(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
