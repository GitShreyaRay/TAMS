package fullstackbasics.io.tams_core_api.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import fullstackbasics.io.tams_core_api.domain.RequestStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateTalentRequestStatusCommand {

	@TargetAggregateIdentifier
	private String talentRequestId;
	private RequestStatus requestStatus;
}
