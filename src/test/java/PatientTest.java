
import api.Specifications;
import config.Endpoints;
import config.Settings;
import model.api.requests.EnrollmentRequest;
import model.api.responses.enrollment.EnrollmentResponse;
import model.api.responses.get_patient_by_id.GetPatientByIdResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.CareSpeak;

public class PatientTest extends BaseTest {
    private String patientFirstName;
    private String patientLastName;
    private String patientMobileNumber;
    private int patientId;

    @Test(description = "Patient enrollment to a program")
    public void patientEnrollment(){
        Specifications.installSpecification(Specifications
                .requestSpec(Settings.getCareSpeakHost()+
                        Endpoints.ENROLLMENT.getValue()), Specifications.responseSpec200());

        EnrollmentResponse response = CareSpeak.api().patientApi().addPatient(EnrollmentRequest.builder().build());

        Assert.assertTrue(response.success = true);
        Assert.assertEquals(response.message, "patient successfully enrolled in program");
        patientId = response.patient.id;
    }

    @Test(description = "Get patient data by id", dependsOnMethods = "patientEnrollment")
    public void getPatientById(){
        Specifications.installSpecification(Specifications
                .requestSpec(Settings.getCareSpeakHost()+
                        Endpoints.GET_PATIENT_BY_ID), Specifications.responseSpec200());

        //Test data
        patientFirstName = EnrollmentRequest.builder().build().getPatient().firstName;
        patientLastName = EnrollmentRequest.builder().build().getPatient().lastName;
        patientMobileNumber = EnrollmentRequest.builder().build().getPatient().mobile;

        GetPatientByIdResponse response = CareSpeak.api().patientApi().getPatientById(patientId);

        Assert.assertEquals(response.id, patientId);
        Assert.assertEquals(response.firstName, patientFirstName);
        Assert.assertEquals(response.lastName, patientLastName);
        Assert.assertEquals(response.mobile, patientMobileNumber);
        Assert.assertEquals(response.status, "Pending");
    }
}
