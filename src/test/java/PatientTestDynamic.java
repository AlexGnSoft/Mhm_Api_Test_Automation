
import api.Specifications;
import config.Settings;
import model.api.requests.EnrollmentRequest;
import model.api.requests.PatientRequest;
import model.api.responses.enrollment.EnrollmentResponse;
import model.api.responses.get_patient_by_id.GetPatientByIdResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.CareSpeak;

public class PatientTestDynamic extends BaseTest {
    private int patientId;

    private PatientRequest getNewPatient(){
        return PatientRequest.builder()
                .firstName(RandomStringUtils.randomAlphabetic(7))
                .lastName(RandomStringUtils.randomAlphabetic(4))
                .mobile("+1555"+RandomStringUtils.randomNumeric(7))
                .email(RandomStringUtils.randomAlphabetic(5)+"r@tester.com")
                .build();
    }

    @Test(description = "Dynamic patient enrollment to a program")
    public void patientDynamicEnrollment(){
        Specifications.installSpecification(Specifications.requestSpec(Settings.getCareSpeakHost()), Specifications.responseSpec200());

        //patientFirstName = getNewPatient().firstName;
        EnrollmentResponse response = CareSpeak.api().patientApi()
                .addPatient(EnrollmentRequest.builder()

                        .patient(getNewPatient()).build());

        Assert.assertTrue(response.success = true);
        Assert.assertEquals(response.message, "patient successfully enrolled in program");
        patientId = response.patient.id;
    }

    @Test(description = "Get patient data by id", dependsOnMethods = "patientDynamicEnrollment")
    public void getPatientById(){
        Specifications.installSpecification(Specifications.requestSpec(Settings.getCareSpeakHost()), Specifications.responseSpec200());

        GetPatientByIdResponse response = CareSpeak.api().patientApi().getPatientById(patientId);

        Assert.assertEquals(response.id, patientId);
    }
}
