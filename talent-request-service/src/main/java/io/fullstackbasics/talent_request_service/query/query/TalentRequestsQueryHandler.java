package io.fullstackbasics.talent_request_service.query.query;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import io.fullstackbasics.talent_request_service.query.dto.TalentRequestQueryResponseDTO;
import io.fullstackbasics.talent_request_service.query.repository.TalentRequest;
import io.fullstackbasics.talent_request_service.query.repository.TalentRequestRepository;

@Component
public class TalentRequestsQueryHandler {
 
    private final TalentRequestRepository talentRequestRepository;
 
    public TalentRequestsQueryHandler(TalentRequestRepository talentRequestRepository) {
        this.talentRequestRepository = talentRequestRepository;
    }
 
    @QueryHandler
    public List<TalentRequestQueryResponseDTO> findAllTalentRequests (FindTalentRequestsQuery findTalentRequestsQuery){
        List<TalentRequestQueryResponseDTO> talentRequestResponseDTOList = new ArrayList<>();
        generateTalentRequestDTOListFromDatabase(talentRequestResponseDTOList);
 
        return talentRequestResponseDTOList;
    }
    
    @QueryHandler
    public TalentRequestQueryResponseDTO findTalentRequestByTalentRequestId (FindTalentRequestByTalentRequestIdQuery findTalentRequestByTalentRequestIdQuery){
    	TalentRequestQueryResponseDTO talentRequestResponseDTO = new TalentRequestQueryResponseDTO();
    	TalentRequest talentRequest = talentRequestRepository.findById(findTalentRequestByTalentRequestIdQuery.getTalentRequestId()).get();
    	BeanUtils.copyProperties(talentRequest, talentRequestResponseDTO);
    	return talentRequestResponseDTO;
    }
 
 
    private void generateTalentRequestDTOListFromDatabase(List<TalentRequestQueryResponseDTO> talentRequestResponseDTOList) {
        List<TalentRequest> talentRequestList = talentRequestRepository.findAll();
        for (TalentRequest talentRequest : talentRequestList) {
            TalentRequestQueryResponseDTO talentRequestResponseDTO = new TalentRequestQueryResponseDTO();
            BeanUtils.copyProperties(talentRequest, talentRequestResponseDTO);
            talentRequestResponseDTOList.add(talentRequestResponseDTO);
        }
    }
}
