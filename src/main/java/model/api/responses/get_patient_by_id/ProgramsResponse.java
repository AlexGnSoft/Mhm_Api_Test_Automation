package model.api.responses.get_patient_by_id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "url",
        "links"
})
public class ProgramsResponse {
    @JsonProperty("id")
    public int id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("url")
    public String url;

    @JsonProperty("links")
    public LinksInsideProgram links;

    static class LinksInsideProgram{
        @JsonProperty("href")
        public String  href;

        @JsonProperty("ref")
        public String ref;
    }
}
