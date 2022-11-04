package model.api.responses.enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "success",
        "patient",
        "message"
})
public class EnrollmentResponse {
    @JsonProperty("success")
    public boolean success;

    @JsonProperty("patient")
    public PatientResponse patient;

    @JsonProperty("message")
    public String message;
}
