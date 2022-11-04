package config;

public enum Endpoints {

    ENROLLMENT("/enrollementprogram/enrollment"),
    GET_PATIENT_BY_ID ("/base/1.0/patients/");

    private String value;

    Endpoints(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
