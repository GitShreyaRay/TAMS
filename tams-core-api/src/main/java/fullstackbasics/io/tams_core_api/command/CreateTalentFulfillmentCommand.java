package fullstackbasics.io.tams_core_api.command;

import java.time.LocalDate;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import fullstackbasics.io.tams_core_api.domain.CandidateSkills;
import fullstackbasics.io.tams_core_api.domain.JobDescription;
import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTalentFulfillmentCommand {
	@TargetAggregateIdentifier
	private String talentFulfillmentId;
	private String jobPostId;
	private String talentRequestId;
	private String talentRequestTitle;
	private LocalDate startDate;
	 
	private JobDescription jobDescription;
	private CandidateSkills candidateSkills;
	private RequestStatus requestStatus;


}
