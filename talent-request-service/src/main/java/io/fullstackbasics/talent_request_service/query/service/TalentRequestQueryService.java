package io.fullstackbasics.talent_request_service.query.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.fullstackbasics.talent_request_service.query.dto.TalentRequestQueryResponseDTO;
import io.fullstackbasics.talent_request_service.query.query.FindTalentRequestByTalentRequestIdQuery;
import io.fullstackbasics.talent_request_service.query.query.FindTalentRequestsQuery;

@Service
public class TalentRequestQueryService {

	private final QueryGateway queryGateway;

	public TalentRequestQueryService(QueryGateway queryGateway) {
		this.queryGateway = queryGateway;
	}

	public ResponseEntity findAllTalentRequests() {

		FindTalentRequestsQuery findTalentRequestsQuery = new FindTalentRequestsQuery();
		List<TalentRequestQueryResponseDTO> talentRequestResponseDTOList = queryGateway
				.query(findTalentRequestsQuery, ResponseTypes.multipleInstancesOf(TalentRequestQueryResponseDTO.class))
				.join();

		return new ResponseEntity(talentRequestResponseDTOList, HttpStatus.OK);
	}

	public ResponseEntity findTalentRequestByTalentRequestId (String talentRequestId) throws ExecutionException, InterruptedException {
		FindTalentRequestByTalentRequestIdQuery findTalentRequestByTalentRequestIdQuery = new FindTalentRequestByTalentRequestIdQuery(talentRequestId);
		
		TalentRequestQueryResponseDTO talentRequestQueryResponseDTO = queryGateway.query(findTalentRequestByTalentRequestIdQuery, ResponseTypes.instanceOf(TalentRequestQueryResponseDTO.class)).get();
		
		return new ResponseEntity(talentRequestQueryResponseDTO, HttpStatus.OK);
    }
}