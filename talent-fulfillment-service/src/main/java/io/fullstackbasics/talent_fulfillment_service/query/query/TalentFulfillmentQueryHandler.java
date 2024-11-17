package io.fullstackbasics.talent_fulfillment_service.query.query;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import io.fullstackbasics.talent_fulfillment_service.query.dto.TalentFulfillmentQueryResponseDTO;
import io.fullstackbasics.talent_fulfillment_service.query.repository.TalentFulfillment;
import io.fullstackbasics.talent_fulfillment_service.query.repository.TalentFulfillmentRepository;



@Component
public class TalentFulfillmentQueryHandler {
	
    private final TalentFulfillmentRepository talentFulfillmentRepository;
    
    public TalentFulfillmentQueryHandler(TalentFulfillmentRepository talentFulfillmentRepository) {
        this.talentFulfillmentRepository = talentFulfillmentRepository;
    }
	 @QueryHandler
	    public List<TalentFulfillmentQueryResponseDTO> findAllTalentFulfillmentRequests (FindAllTalentFulfillmentRequestsQuery findAllTalentFulfillmentRequestsQuery){
	        List<TalentFulfillmentQueryResponseDTO> talentFulfillmentResponseDTOList = new ArrayList<>();
	        generateTalentFulfillmentDTOListFromDatabase(talentFulfillmentResponseDTOList);
	 
	        return talentFulfillmentResponseDTOList;
	    }
	    
	    @QueryHandler
	    public TalentFulfillmentQueryResponseDTO FindTalentFulfillmentByTalentFulfillmentId (FindTalentFulfillmentByTalentFulfillmentIdQuery findTalentFulfillmentByTalentFulfillmentIdQuery){
	    	TalentFulfillmentQueryResponseDTO talentRequestResponseDTO = new TalentFulfillmentQueryResponseDTO();
	    	TalentFulfillment talentFulfillment = talentFulfillmentRepository.findById(findTalentFulfillmentByTalentFulfillmentIdQuery.getTalentFulfillmentId()).get();
	    	BeanUtils.copyProperties(talentFulfillment, talentRequestResponseDTO);
	    	return talentRequestResponseDTO;
	    }
	 
	 
	    private void generateTalentFulfillmentDTOListFromDatabase(List<TalentFulfillmentQueryResponseDTO> talentRequestResponseDTOList) {
	        List<TalentFulfillment> talentFulfillmentList = talentFulfillmentRepository.findAll();
	        for (TalentFulfillment talentFulfillment : talentFulfillmentList) {
	        	TalentFulfillmentQueryResponseDTO talentFulfillmentResponseDTO = new TalentFulfillmentQueryResponseDTO();
	            BeanUtils.copyProperties(talentFulfillment, talentFulfillmentResponseDTO);
	            talentRequestResponseDTOList.add(talentFulfillmentResponseDTO);
	        }
	    }

}
