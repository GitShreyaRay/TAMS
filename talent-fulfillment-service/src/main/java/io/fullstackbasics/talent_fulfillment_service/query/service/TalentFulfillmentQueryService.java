package io.fullstackbasics.talent_fulfillment_service.query.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.fullstackbasics.talent_fulfillment_service.query.dto.TalentFulfillmentQueryResponseDTO;
import io.fullstackbasics.talent_fulfillment_service.query.query.FindAllTalentFulfillmentRequestsQuery;
import io.fullstackbasics.talent_fulfillment_service.query.query.FindTalentFulfillmentByTalentFulfillmentIdQuery;

@Service
public class TalentFulfillmentQueryService {
	
	private final QueryGateway queryGateway;

	public TalentFulfillmentQueryService(QueryGateway queryGateway) {
		this.queryGateway = queryGateway;
	}

	public ResponseEntity findAllTalentFulfillmentRequests() {

		FindAllTalentFulfillmentRequestsQuery findAllTalentFulfillmentRequestsQuery = new FindAllTalentFulfillmentRequestsQuery();
		List<TalentFulfillmentQueryResponseDTO> talentFulfillmenttResponseDTOList = queryGateway
				.query(findAllTalentFulfillmentRequestsQuery, ResponseTypes.multipleInstancesOf(TalentFulfillmentQueryResponseDTO.class))
				.join();

		return new ResponseEntity(talentFulfillmenttResponseDTOList, HttpStatus.OK);
	}

	public ResponseEntity FindTalentFulfillmentByTalentFulfillmentId (String talentFulfillmentId) throws ExecutionException, InterruptedException {
		FindTalentFulfillmentByTalentFulfillmentIdQuery findTalentRequestByTalentRequestIdQuery = new FindTalentFulfillmentByTalentFulfillmentIdQuery(talentFulfillmentId);
		
		TalentFulfillmentQueryResponseDTO TalentFulfillmentQueryResponseDTO = queryGateway.query(findTalentRequestByTalentRequestIdQuery, ResponseTypes.instanceOf(TalentFulfillmentQueryResponseDTO.class)).get();
		
		return new ResponseEntity(TalentFulfillmentQueryResponseDTO, HttpStatus.OK);
    }

}
