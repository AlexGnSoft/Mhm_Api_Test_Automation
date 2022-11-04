package model.api.requests;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class PatientRequest {
    @NonNull
    @Builder.Default
    public String firstName = "Eddard";

    @NonNull
    @Builder.Default
    public String lastName = "Stark";

    @NonNull
    @Builder.Default
    public String mobile = "+15551234569";

    @NonNull
    @Builder.Default
    public String email = "tester@tester.com";
}
