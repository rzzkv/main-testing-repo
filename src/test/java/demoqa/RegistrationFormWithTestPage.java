package demoqa;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationFormWithTestPage extends TestBase {

    @Owner("rzzkv")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("demoqa")
    @DisplayName("The check for the possibility of registering a new user.")
    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
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

    }
}
