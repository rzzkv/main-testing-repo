package demoqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithTestObject extends TestBase {

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.userEmail)
                .setGender()
                .setNumber(data.userNumber)
                .setDateOfBirth()
                .uploadPicture(data.picture)
                .setAddress(data.currentAddress)
                .setSubject(data.subject)
                .setHobbies(data.hobbies)
                .submit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Student Email", data.userEmail)
                .verifyResult("Mobile", data.userNumber)
                .verifyResult("Date of Birth", "16 April,2000");
        Assertions.assertEquals(21,21);
    }
}
