package io.fullstackbasics.talent_request_service.query.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.fullstackbasics.talent_request_service.query.dto.TalentFulfillmentQueryResponseDTO;
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
		List<TalentFulfillmentQueryResponseDTO> talentRequestResponseDTOList = queryGateway
				.query(findTalentRequestsQuery, ResponseTypes.multipleInstancesOf(TalentFulfillmentQueryResponseDTO.class))
				.join();

		return new ResponseEntity(talentRequestResponseDTOList, HttpStatus.OK);
	}

	public ResponseEntity findTalentRequestByTalentRequestId (String talentRequestId) throws ExecutionException, InterruptedException {
		FindTalentRequestByTalentRequestIdQuery findTalentRequestByTalentRequestIdQuery = new FindTalentRequestByTalentRequestIdQuery(talentRequestId);
		
		TalentFulfillmentQueryResponseDTO talentRequestQueryResponseDTO = queryGateway.query(findTalentRequestByTalentRequestIdQuery, ResponseTypes.instanceOf(TalentFulfillmentQueryResponseDTO.class)).get();
		
		return new ResponseEntity(talentRequestQueryResponseDTO, HttpStatus.OK);
    }
}