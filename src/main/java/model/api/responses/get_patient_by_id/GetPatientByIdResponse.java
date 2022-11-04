package model.api.responses.get_patient_by_id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "mobile",
        "zipcode",
        "status",
        "programs",
        "cards",
        "links",
        "campaignGroups"

})

public class GetPatientByIdResponse {

    @JsonProperty("id")
    public int id;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("mobile")
    public String mobile;

    @JsonProperty("zipcode")
    public String zipcode;

    @JsonProperty("status")
    public String status;

    @JsonProperty("programs")
    public ProgramsResponse[] programs;

    @JsonProperty("cards")
    public CardsResponse[] cards;

    @JsonProperty("links")
    public LinksResponse[] links;

    @JsonProperty("campaignGroups")
    public CampaignGroupsResponse[] campaignGroups;

}
