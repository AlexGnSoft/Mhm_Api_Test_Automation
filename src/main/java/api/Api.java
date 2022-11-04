package api;

import io.restassured.specification.RequestSpecification;

public abstract class Api {
    RequestSpecification requestSpecification;

    public Api(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }
}
