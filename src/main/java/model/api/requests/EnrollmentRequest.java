package model.api.requests;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class EnrollmentRequest {
    @NonNull
    @Builder.Default
    private int transactionId = 1234567;

    @NonNull
    @Builder.Default
    private PatientRequest patient = PatientRequest.builder().build();
}
