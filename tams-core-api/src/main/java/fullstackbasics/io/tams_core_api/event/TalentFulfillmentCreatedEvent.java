package fullstackbasics.io.tams_core_api.event;

import java.time.LocalDate;

import org.axonframework.modelling.command.AggregateIdentifier;

import fullstackbasics.io.tams_core_api.domain.CandidateSkills;
import fullstackbasics.io.tams_core_api.domain.EmploymentType;
import fullstackbasics.io.tams_core_api.domain.JobDescription;
import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import fullstackbasics.io.tams_core_api.domain.RoleLevel;
import lombok.Data;

@Data
public class TalentFulfillmentCreatedEvent {

	private String talentFulfillmentId;
	private String jobPostId;
	private String talentRequestId;
	private String talentRequestTitle;
	private LocalDate startDate;
	private JobDescription jobDescription;
	private CandidateSkills candidateSkills;
	private RequestStatus requestStatus;


}
