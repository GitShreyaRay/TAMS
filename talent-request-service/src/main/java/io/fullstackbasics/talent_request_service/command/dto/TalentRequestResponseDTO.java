package io.fullstackbasics.talent_request_service.command.dto;

import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import lombok.Data;

@Data
public class TalentRequestResponseDTO {
	
	private String talentRequestId;
	private String talentRequestTitle;
	private RequestStatus requestStatus;

}
