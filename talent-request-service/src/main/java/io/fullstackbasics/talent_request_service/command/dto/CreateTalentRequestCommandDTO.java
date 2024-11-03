package io.fullstackbasics.talent_request_service.command.dto;

import java.time.LocalDate;

import fullstackbasics.io.tams_core_api.domain.CandidateSkills;
import fullstackbasics.io.tams_core_api.domain.JobDescription;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateTalentRequestCommandDTO {
	//Receive from hiring manager
	private String talentRequestTitle;
	private JobDescription jobDescription;
	private CandidateSkills candidateSkills;
	private LocalDate startDate;
}
