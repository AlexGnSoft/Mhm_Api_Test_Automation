package model.api.responses.get_patient_by_id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "href",
        "ref"
})
public class LinksResponse {
    @JsonProperty("href")
    public String href;

    @JsonProperty("ref")
    public String ref;

}
