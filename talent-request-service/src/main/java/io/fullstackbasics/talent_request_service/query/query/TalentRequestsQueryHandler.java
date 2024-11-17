package io.fullstackbasics.talent_request_service.query.query;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import io.fullstackbasics.talent_request_service.query.dto.TalentFulfillmentQueryResponseDTO;
import io.fullstackbasics.talent_request_service.query.repository.TalentRequest;
import io.fullstackbasics.talent_request_service.query.repository.TalentFulfillmentRepository;

@Component
public class TalentRequestsQueryHandler {
 
    private final TalentFulfillmentRepository talentRequestRepository;
 
    public TalentRequestsQueryHandler(TalentFulfillmentRepository talentRequestRepository) {
        this.talentRequestRepository = talentRequestRepository;
    }
 
    @QueryHandler
    public List<TalentFulfillmentQueryResponseDTO> findAllTalentRequests (FindTalentRequestsQuery findTalentRequestsQuery){
        List<TalentFulfillmentQueryResponseDTO> talentRequestResponseDTOList = new ArrayList<>();
        generateTalentRequestDTOListFromDatabase(talentRequestResponseDTOList);
 
        return talentRequestResponseDTOList;
    }
    
    @QueryHandler
    public TalentFulfillmentQueryResponseDTO findTalentRequestByTalentRequestId (FindTalentRequestByTalentRequestIdQuery findTalentRequestByTalentRequestIdQuery){
    	TalentFulfillmentQueryResponseDTO talentRequestResponseDTO = new TalentFulfillmentQueryResponseDTO();
    	TalentRequest talentRequest = talentRequestRepository.findById(findTalentRequestByTalentRequestIdQuery.getTalentRequestId()).get();
    	BeanUtils.copyProperties(talentRequest, talentRequestResponseDTO);
    	return talentRequestResponseDTO;
    }
 
 
    private void generateTalentRequestDTOListFromDatabase(List<TalentFulfillmentQueryResponseDTO> talentRequestResponseDTOList) {
        List<TalentRequest> talentRequestList = talentRequestRepository.findAll();
        for (TalentRequest talentRequest : talentRequestList) {
            TalentFulfillmentQueryResponseDTO talentRequestResponseDTO = new TalentFulfillmentQueryResponseDTO();
            BeanUtils.copyProperties(talentRequest, talentRequestResponseDTO);
            talentRequestResponseDTOList.add(talentRequestResponseDTO);
        }
    }
}
