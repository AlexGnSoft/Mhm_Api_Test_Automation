package model.api.responses.enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientResponse {
    @JsonProperty("id")
    public int id;


}
