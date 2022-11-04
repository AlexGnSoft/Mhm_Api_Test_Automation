package api;

import config.Endpoints;
import config.Utils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.api.responses.enrollment.EnrollmentResponse;
import model.api.responses.get_patient_by_id.GetPatientByIdResponse;

public class PatientApi extends Api{

    public PatientApi(RequestSpecification requestSpecification) {
        super(requestSpecification);
    }

    public EnrollmentResponse addPatient(Object body) {
        return requestSpecification.auth().basic(Utils.getUsername(), Utils.getPassword())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .log().all()
                .when()
                .post(Endpoints.ENROLLMENT.getValue())
                .then()
                .log().all()
                .assertThat()
                .extract()
                .response().as(EnrollmentResponse.class);
    }

    public GetPatientByIdResponse getPatientById(int patientId) {
        String patientIdAsString = String.valueOf(patientId);

        return requestSpecification.auth().basic(Utils.getUsername(), Utils.getPassword())
                .log().all()
                .when()
                .get(Endpoints.GET_PATIENT_BY_ID.getValue() + patientIdAsString)
                .then()
                .log().all()
                .assertThat()
                .extract()
                .response().as(GetPatientByIdResponse.class);
    }

    public String getPatientByIdAsString(int patientId) {
        String patientIdString = String.valueOf(patientId);

        return requestSpecification.auth().basic(Utils.getUsername(), Utils.getPassword())
                .log().all()
                .when()
                .get(Endpoints.GET_PATIENT_BY_ID.getValue()+patientIdString)
                .then()
                .log().all()
                .assertThat()
                .extract()
                .body().jsonPath().get().toString();
    }
}
