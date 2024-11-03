package fullstackbasics.io.tams_core_api.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class JobDescription {
	private String responsibilities;
	private String qualifications;

}
