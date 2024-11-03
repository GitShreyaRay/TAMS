package fullstackbasics.io.tams_core_api.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Embeddable
public class CandidateSkills {
	
	@Enumerated(EnumType.STRING)
	private CoreSkill coreskill;
	@Enumerated(EnumType.STRING)
	private SkillLevel skillLevel;
}