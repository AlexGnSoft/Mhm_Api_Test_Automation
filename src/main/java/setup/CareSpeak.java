package setup;

import api.PatientApi;
import config.Utils;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class CareSpeak {
    private RequestSpecification requestSpecification;

    public CareSpeak(RequestSpecification config) {
        this.requestSpecification = config;
    }

    public static CareSpeak api() {
        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 180000)
                        .setParam("http.socket.timeout", 180000));

        return new CareSpeak(given().config(config));
    }

    public PatientApi patientApi() {
        return new PatientApi(requestSpecification.baseUri(Utils.getCareSpeakUrl()));
    }


}
